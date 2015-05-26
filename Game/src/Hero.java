import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Hero {
	int x;
	int y;
	int speed;
	boolean isWalking;
	boolean isJumping;
	
	BufferedImage charImage;
	
	public Hero(int x, int y){
		this.x = x;
		this.y = y;
		
		try {
			charImage = ImageIO.read(new File("characterimage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jump(){
		for (int i = 0; i < 20; i++) {
			y-=1;
		}for (int i = 0; i < 20; i++) {
			y+=1;
		}
	}
	
	public void left(){
		x-=5;
	}
	
	public void right(){
		x+=5;
	}
	
	public void shoot(){
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(charImage, x, y, 30, 30, null);
	}
}
