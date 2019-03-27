import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Drawing extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("hero1walk.png");

	// circle's position
	public int x = 30;
	public int y = 30;

	// animation states
	public int state = 0;

	Enemy[] enemy = new Enemy[5];
	Hero hero1;
	


	public Drawing(){
		enemy[1] = new Enemy(200,200);
		enemy[2] = new Enemy(300,200);
		enemy[3] = new Enemy(400,200);
		hero1 = new Hero(this);
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bg.gif"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("hero1walk.png");
		}
		else if(state == 1){
			resource = getClass().getResource("hero2walk.png");
		}
		else if(state == 2){
			resource = getClass().getResource("hero3walk.png");
		}
		else if(state == 3){
			resource = getClass().getResource("hero4walk.png");
		}
		else if(state == 4){
			resource = getClass().getResource("hero5walk.png");
		}
		else if(state == 5){
			resource = getClass().getResource("hero6walk.png");
			state = 0;
		}
		else if(state == 6){
			resource = getClass().getResource("hero7walk.png");
			state = 0;
		}
		else if(state == 7){
			resource = getClass().getResource("hero8walk.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==5){
							resource = getClass().getResource("hero.png");
						}
						else{
							resource = getClass().getResource("hero"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	 public void attackLeft(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 0; ctr < 6; ctr++){
                    try {
                        if(ctr==5){
                            resource = getClass().getResource("heroleft.png");
                        }
                        else{
                            resource = getClass().getResource("heroleft"+ctr+".png");
                        }
                        
                        try{
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }
	

	public void attack(){
		attackAnimation();

	}

	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		reloadImage();
		repaint();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(hero1.image, hero1.xPos, hero1.yPos, this);


		for(int c = 0; c < enemy.length; c++){
			if(enemy[c]!=null){
				g.drawImage(enemy[c].image, enemy[c].xPos, enemy[c].yPos, this);
				g.setColor(Color.GREEN);
			}
		}
	}
}