import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;



public class Hero{
    public int xPos = 30;
    public int yPos = 215;
    // animation states
    public int state = 0;

    public BufferedImage image;
    public URL resource = getClass().getResource("hero1walk.png");
    public Drawing comp;
    public Hero(Drawing comp){
        this.comp = comp;
        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Hero(Drawing comp,int xPass, int yPass){
        xPos = xPass;
        yPos = yPass;
        this.comp = comp;

        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public void reloadImage(){

        Thread threadx = new Thread(new Runnable(){
            public void run(){
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
        });
        threadx.start();
        
    }

    public void runLeft(){

        Thread threadx = new Thread(new Runnable(){
            public void run(){
                state++;

                if(state == 0){
                resource = getClass().getResource("herowalkleft1.png");
                }
                else if(state == 1){
                    resource = getClass().getResource("herowalkleft2.png");
                }
                else if(state == 2){
                    resource = getClass().getResource("herowalkleft3.png");
                }
                else if(state == 3){
                    resource = getClass().getResource("herowalkleft4.png");
                }
                else if(state == 4){
                    resource = getClass().getResource("herowalkleft5.png");
                }
                else if(state == 5){
                    resource = getClass().getResource("herowalkleft6.png");
                    state = 0;
                }
                else if(state == 6){
                    resource = getClass().getResource("herowalkleft7.png");
                    state = 0;
                }
                else if(state == 7){
                    resource = getClass().getResource("herowalkleft8.png");
                    state = 0;
                }

                try{
                    image = ImageIO.read(resource);
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
        threadx.start();
        
    }

    public void attack(){
        attackAnimation();
        attackLeft();
        

    }

    public void moveUp(){
        yPos = yPos - 5;
        reloadImage();
        comp.repaint();
    }

    public void moveDown(){
        yPos = yPos + 5;
        reloadImage();
        comp.repaint();
    }

    public void moveLeft(){
        xPos = xPos - 5;
        runLeft();
        comp.repaint();
    }

    public void moveRight(){
        xPos = xPos + 5;
        reloadImage();
        comp.repaint();
    }

    public void attackAnimation(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 1; ctr < 5; ctr++){
                    try {
                        if(ctr==4){
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
                        comp.repaint();
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
                for(int ctr = 1; ctr < 5; ctr++){
                    try {
                        if(ctr==4){
                            resource = getClass().getResource("herowalkleft1.png");
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
                        comp.repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }
    
}