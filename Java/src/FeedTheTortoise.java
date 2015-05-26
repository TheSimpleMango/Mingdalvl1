import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.TurtlePanel;
public class FeedTheTortoise implements KeyEventDispatcher
{
	private void feedTheTortoise()
	{
		// 1. use the addFood() method to add food for the tortoise
		int ranNum = new Random().nextInt(300);
		int ranNumTwo = new Random().nextInt(400);
		addFood(ranNum,ranNumTwo);
	}

private void goUp()
	{
		// 2. Print “going up”. Test it out by running your code and pressing the up key
		System.out.println("going up");
		// 3. Make the tortoise move up the screen
		double x = Tortoise.getAngle();
		x=360-x;
		Tortoise.turn(x);
		Tortoise.move(1);
	}

	private void goDown()
	{
		System.out.println("going down");
		// 4. make the tortoise move down the screen
		double x = Tortoise.getAngle();
		x=540-x;
		Tortoise.turn(x);
		Tortoise.move(1);
	}
	
	private void goLeft()
	{
		System.out.println("going left");
		// 5. make the tortoise move left
		double x = Tortoise.getAngle();
		x=630-x;
		Tortoise.turn(x);
		Tortoise.move(1);
	}

	private void goRight()
	{
		System.out.println("going right");
		double x = Tortoise.getAngle();
		x=450-x;
		Tortoise.turn(x);
		Tortoise.move(1);
	}

	private void checkIfFoodFound() throws Exception
	{
		int tortoiseLocationX = Tortoise.getX();
		int tortoiseLocationY = Tortoise.getY();
		
		// 7. Print out the variables for tortoiseLocationX and tortoiseLocationY
		System.out.println(tortoiseLocationX+" "+tortoiseLocationY);
		// 8. if tortoise is at same location as food
		if (tortoiseLocationX==250&tortoiseLocationY==250) { 
			// print "chomp"
			System.out.println("chomp");
			// say “chomp” with Runtime.getRuntime().exec(“say chomp”);
			Runtime.getRuntime().exec("say chomp");
			// call the eatFood() method
			eatFood();
			JOptionPane.showMessageDialog(null, "you win!");
		}
	}

private void eatFood(){
		component.setText("");
	}




	private void addFood(int x, int y)
	{
		component.setLocation(x, y);
		window.add(component);
	}

	
	
	
	TurtlePanel window = Tortoise.getBackgroundWindow();
Label component = new Label("*");




	public static void main(String[] args)
	{
		FeedTheTortoise feeder = new FeedTheTortoise();
		feeder.controlTheTortoise();
		feeder.feedTheTortoise();
	}

	
	
	
	private void controlTheTortoise() 
{
KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		Tortoise.show();
		Tortoise.setSpeed(10);
	}

	 
	
	
	public boolean dispatchKeyEvent(KeyEvent e)
	{
		if (e.getID() == KeyEvent.KEY_PRESSED)
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				goRight();
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				goLeft();
			if (e.getKeyCode() == KeyEvent.VK_UP)
				goUp();
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				 goDown();
			try {
			checkIfFoodFound();
			} catch (Exception exception) {}
		}
		return false;
	}

}
