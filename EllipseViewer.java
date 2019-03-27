import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.sound.sampled.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EllipseViewer extends JFrame implements KeyListener{

	Drawing drawing;
	File slash = new File("slash.wav");
	File walk = new File("walk.wav");

	public EllipseViewer(){
		this.drawing = new Drawing();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.hero1.moveUp();
			System.out.println("pos: " + drawing.x + ", " + drawing.hero1.yPos);
			PlaySound(walk);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.hero1.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.hero1.yPos);
			PlaySound(walk);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.hero1.moveDown();
			System.out.println("pos: " + drawing.x + ", " + drawing.hero1.yPos);
			PlaySound(walk);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.hero1.moveLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.hero1.yPos);
			PlaySound(walk);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.hero1.attackAnimation();
			System.out.println("attack");
			PlaySound(slash);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			drawing.hero1.attackLeft();
			System.out.println("attack");
			PlaySound(slash);
		}

	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args[]){
		EllipseViewer gameFrame = new EllipseViewer();
		gameFrame.setSize(600,370);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("IP");
	}


	static void PlaySound(File Sound){

		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();

			
		}
		catch(Exception e)
		{

		}
	}

}