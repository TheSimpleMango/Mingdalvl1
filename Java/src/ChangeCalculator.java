import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class ChangeCalculator {
	public static void main(String[] args) {
		double q, d, n, p;
		
		q = Integer.parseInt(JOptionPane.showInputDialog("How many quarters do you have?"));
		d = Integer.parseInt(JOptionPane.showInputDialog("How many dimes do you have?"));
		n = Integer.parseInt(JOptionPane.showInputDialog("How many nickels do you have?"));
		p = Integer.parseInt(JOptionPane.showInputDialog("How many pennies do you have?"));
		
		double total = (q * 25 + d * 10 + n * 5 + p)/100;
		
		DecimalFormat f = new DecimalFormat("#.00");
		
		JOptionPane.showMessageDialog(null, "Your total amount of change is $" + f.format(total));
	}
}
