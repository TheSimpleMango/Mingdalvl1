import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class StartGame extends JPanel implements MouseListener, ActionListener, KeyListener {
	JFrame menuFrame = new JFrame("HERO?");
	BufferedImage gameImage;
	Hero player = new Hero(300, 500);
	
	Timer timer = new Timer(1000/60, this);
	long waitTime;
	
	StartGame(){
		waitTime = -1;
		timer.start();
	}

	public void start() {
		try {
			gameImage = ImageIO.read(new File("menuArt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuFrame.setSize(601, 601);
		menuFrame.setVisible(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.add(this);
		menuFrame.validate();
		menuFrame.repaint();
		menuFrame.addKeyListener(this);
		
		this.setLayout(null);
		this.addMouseListener(this);
	}

	Font font = new Font("Helvetica Neue", Font.PLAIN, 20);
	Font backFont = new Font("Arial", Font.PLAIN, 12);

	public void paint(Graphics g) {
		if (waitTime == -1) {
			waitTime = System.currentTimeMillis();
		}
		if (System.currentTimeMillis()-waitTime<1000) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 601, 601);
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString("Save the world", 220, 275);
			g.drawString("Be the Hero", 235, 295);
		}
		else{
			g.drawImage(gameImage, 0, 0, null);
			g.setColor(Color.black);
			g.fillRect(10, 10, 40, 15);
			
			g.setColor(Color.white);
			g.setFont(backFont);
			g.drawString("<back", 10, 22);
		}
		player.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		System.out.println(mX + ", " + mY);
		if (mX > 10 && mX < 50 && mY > 10 && mY < 25) {
			System.out.println("gameBackButton" + 10 + ", " + 10 + ", "
					+ 50 + ", " + 25);
			repaint();
			Menu newMenu = new Menu();
			newMenu.start();
			menuFrame.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
//use booleans to move player and set move boolean false in keyreleased
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed");
		int keyPressed = e.getKeyCode();
		if (keyPressed==KeyEvent.VK_W) {
			System.out.println("w pressed");
			player.jump();
		}
		if (keyPressed==KeyEvent.VK_A) {
			System.out.println("a pressed");
			player.left();
		}
		if (keyPressed==KeyEvent.VK_D) {
			System.out.println("d pressed");
			player.right();
		}
		if (keyPressed==KeyEvent.VK_SPACE) {
			System.out.println("space pressed");
			player.shoot();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}