import javax.swing.JOptionPane;


public class SecretMessageSystem {
	private static String password = "password";
	private static String message = "asdf";
	
	public static void main(String[] args) {
		passcode();
	}
	
	public static void passcode(){
		String passwordInput = JOptionPane.showInputDialog("Input the password");
		if (passwordInput.equals(password)) {
			int input = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do? \n" +
					"1. show message \n" +
					"2. create new message \n" +
					"3. quit program"));
			if (input == 1) {
				JOptionPane.showMessageDialog(null, message);
				String i = JOptionPane.showInputDialog("Would you like to change the message? Y/N");
				if (i.equals("Y")) {
					password = JOptionPane.showInputDialog("input your new password");
					message = JOptionPane.showInputDialog("input your new message");
					passcode();
				}
				else {
					passcode();
				}
			}
			else if (input == 2) {
				password = JOptionPane.showInputDialog("input your new password");
				message = JOptionPane.showInputDialog("input your new message");
			}
			else if (input == 3) {
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(null, "invalid input");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "y u no putt paswrd riht");
		}
	}
}
