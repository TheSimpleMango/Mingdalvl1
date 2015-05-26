import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

import org.teachingextensions.logo.ImageBackground;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;

/**
 * Note: You will need the latest version of the TKP jar:
 * http://school.wintrisstech.org/jars/TeachingKidsProgramming.jar
 **/

public class TurtleTreasureHunt implements KeyEventDispatcher {
	public static boolean win = false;

	private void goUp() {
		Tortoise.setAngle(0);
		Tortoise.move(5);
	}

	private void goDown() {
		Tortoise.setAngle(180);
		Tortoise.move(5);
	}

	private void goLeft() {
		Tortoise.setAngle(270);
		Tortoise.move(5);
	}

	private void goRight() {
		Tortoise.setAngle(90);
		Tortoise.move(5);
	}
	
	public int tortoiseLocationX = Tortoise.getX();
	public int tortoiseLocationY = Tortoise.getY();

	private void checkLocation() throws Exception {
		tortoiseLocationX = Tortoise.getX();
		tortoiseLocationY = Tortoise.getY();

		// 5. Print out the variables for tortoiseLocationX and tortoiseLocationY
		System.out.println(tortoiseLocationX);
		System.out.println(tortoiseLocationY);
		// 6. If tortoise is at same location as the little girl,
		// 		make a pop-up tell the Tortoise where to go next
		// 7. Give the user subsequent clues at different locations on the image (pirate robot, swamp, parrots, etc.)

	}
	
	public boolean isAtGirl(){
		if (Math.abs(tortoiseLocationX-510) <= 10 && Math.abs(tortoiseLocationY-295) <= 50) {
			return true;
		}
		else
		return false;
	}

	private void go() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(this);
		Paintable backgroundImage = new ImageBackground(
				"http://s30.postimg.org/oi69jth7l/fetch1.jpg");
		Tortoise.getBackgroundWindow().addPaintable(backgroundImage);
		Tortoise.penUp();
	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		Tortoise.setSpeed(10);
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				goRight();
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				goLeft();
			if (e.getKeyCode() == KeyEvent.VK_UP)
				goUp();
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				goDown();
			if (e.getKeyCode() == KeyEvent.VK_SPACE && isAtGirl()==true){
				JOptionPane.showMessageDialog(null, "You Win!");
				win = true;
		}
			try {
				checkLocation();
			} catch (Exception exception) {
			}
		}
		return false;
	}

	public static void main(String[] args) throws MalformedURLException {
		JOptionPane.showMessageDialog(null, "#FreeTheGirl2014");
		JOptionPane.showMessageDialog(null, "Press space over the girl to free her.");
		TurtleTreasureHunt tth = new TurtleTreasureHunt();
		tth.go();
		if (win == true) {
			System.exit(0);
		}
	}
}
