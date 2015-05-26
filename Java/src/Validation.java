import java.util.Random;

import javax.swing.JOptionPane;

public class Validation {
	public static void main(String[] args) {
		int x = 0;
		while(x != 10){
		// 1. Watch the first 2 minutes of this movie: http://vimeo.com/2485018
		int randomNumber = new Random().nextInt(5);
		// 2. On paper, write all the numbers that get printed when you run this class
		//System.out.println(randomNumber);

		// 3. Use the randomNumber to give the user a random compliment.
		switch (randomNumber) {
		case 0:
			System.out.println("If Einstein could meet you, he'd be mildly to moderately intimidated.");
			break;
			
		case 1:
			System.out.println("Your siblings are pissed that your photo is the star of your parent's mantle.");
			break;
			
		case 2:
			System.out.println("Your principal would call you to the office just to look cool.");
			break;
			
		case 3:
			System.out.println("You are freakishly good at thumb wars.");
			break;
			
		case 4:
			System.out.println("Cockroaches, mice and other pests avoid your place out of respect.");
			break;
			
		case 5:
			System.out.println("Some dudes hope you start a band so they can start a cover band of that band.");
			break;
			
		case 6:
			System.out.println("A 3rd tier cable network would totally create a television show about you.");
			break;
			
		case 7:
			System.out.println("Cops admire your ability to stay a perfect 3-5 miles above the speed limit.");
			break;
			
		case 8:
			System.out.println("The FBI tapped your phone just to hear the sound of your voice.");
			break;
			
		case 9:
			System.out.println("At least two friends are going to name their child and/or goldfish after you.");
			break;
			
		case 10:
			System.out.println("You kick ass.");
			break;
			
		default:
			break;
		}
		
		x++;
		// 4. Repeat all the code above 10 times
		}
		// 5. Find someone to test out your program. They will like it :)
	}
}