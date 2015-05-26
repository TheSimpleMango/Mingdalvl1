import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.TurtlePanel;

public class TurtlePond implements KeyEventDispatcher {

	// 1. Set a location for the food
	int cookieX = 100;
	int cookieY = 100;

	// 2. Choose the speed you want the Tortoise to go at
	int speed = 5;
	
	void setup() {
		// 3. Add an intro message to tell the user what to do
		JOptionPane.showMessageDialog(null, "Eat the food within 20 seconds, or the tortoise will die. ");
		// 4. For debugging purposes, show the food
		showFood();
	}

	private void goUp() {
		double x = Tortoise.getAngle();
		x=360-x;
		Tortoise.turn(x);
		Tortoise.move(speed);
	}

	private void goDown() {
		System.out.println("going down");
		double x = Tortoise.getAngle();
		x=540-x;
		Tortoise.turn(x);
		Tortoise.move(speed);
	}

	private void goLeft() {
		System.out.println("going left");
		double x = Tortoise.getAngle();
		x=630-x;
		Tortoise.turn(x);
		Tortoise.move(speed);
	}

	private void goRight() {
		System.out.println("going right");
		double x = Tortoise.getAngle();
		x=450-x;
		Tortoise.turn(x);
		Tortoise.move(speed);
	}

	private void checkForFood() throws Exception {
		int tortoiseLocationX = Tortoise.getX();
		int tortoiseLocationY = Tortoise.getY();

		// 7. If the Tortoise is within 100 pixels of the food, set the background color to yellow

		if ( Math.abs( Tortoise.getX() - cookieX) < 100 && Math.abs( Tortoise.getY() - cookieY) < 100) {
			setBackgroundColor(Color.yellow);
		}
		
		if ( Math.abs( Tortoise.getX() - cookieX) < 50 && Math.abs( Tortoise.getY() - cookieY) < 100) {
			setBackgroundColor(Color.orange);
		}
		
		if ( Math.abs( Tortoise.getX() - cookieX) < 10 && Math.abs( Tortoise.getY() - cookieY) < 100) {
			setBackgroundColor(Color.red);
		}
		
		// 11. If the Tortoise crosses it's own path, move them back to the beginning
		if (wasHereBefore(Tortoise.getX(), Tortoise.getY())) {
			Tortoise.penUp();
			Tortoise.moveTo(300, 200);
		}
		// 12. If more than 20 seconds have elapsed, tell them the turtle died of hunger
		if (getTimeElapsed() > 20) {
			JOptionPane.showMessageDialog(null, "Your turtle has died");
		}
	}
	
	private long getTimeElapsed() {
		 Date currentTime = new Date();
		 return (currentTime.getTime() - startTime.getTime())/1000;
	}

	void setBackgroundColor(Color color) {
		Tortoise.getBackgroundWindow().setBackground(color);
	}

	private void hideFood() {
		window.remove(component);
	}

	private void showFood() {
		// If the food doesn't show up, make sure you are on Java 1.6
		component.setLocation(cookieX, cookieY);
		window.add(component);
	}

	private boolean wasHereBefore(int xPosition, int yPosition) {
		if (previousLocations.contains(new Point(xPosition, yPosition)))
			return true;
		else
			return false;
	}

	/*********************** don't worry about the stuff under here ******************/

	TurtlePanel window = Tortoise.getBackgroundWindow();
	Label component = new Label("*");
	Date startTime = new Date();

	public static void main(String[] args) {
		TurtlePond feeder = new TurtlePond();
		feeder.controlTheTortoise();
		feeder.setup();
	}

	private void controlTheTortoise() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		Tortoise.show();
		Tortoise.setPenColor(Colors.Purples.DarkMagenta);
		Tortoise.getBackgroundWindow().setBackground(Colors.Grays.SlateGray);
		Tortoise.setSpeed(10);
	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				goRight();
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				goLeft();
			if (e.getKeyCode() == KeyEvent.VK_UP)
				goUp();
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				goDown();

			try {
				checkForFood();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			savePosition(Tortoise.getX(), Tortoise.getY());
		}
		return false;
	}

	ArrayList<Point> previousLocations = new ArrayList<Point>();

	private void savePosition(int xPosition, int yPosition) {
		previousLocations.add(new Point(xPosition, yPosition));
	}
}

