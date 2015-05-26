import javax.swing.JOptionPane;

public class IsPrime {
	public static void main(String[] args) {
		// gets a number between 1 and 500 from the user
		String inputStr = JOptionPane
				.showInputDialog("input a number between 1 and 500");
		int inputInt = Integer.parseInt(inputStr);
		boolean isPrime = false;

		// checks if the number is prime
		for (int i = 2; i < inputInt; i++) {
			if (inputInt % i == 0) {
				isPrime = false;
				break;
			} else {
				isPrime = true;
			}
			i++;
		}
		if (isPrime == false && inputInt != 2) {
			System.out.println("Your number is not prime.");
		} else {
			System.out.println("Your number is prime");
		}
	}
}
