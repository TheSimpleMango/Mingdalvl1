import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FortuneCookie implements ActionListener {
	public static void main(String[] args) {
		FortuneCookie x = new FortuneCookie();
		x.showButton();
	}
	public void showButton(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBackground(Color.blue);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton button = new JButton();
		panel.add(button);
		button.setText("FORTUN COOKY");
		button.addActionListener(this);
		
		frame.pack();
	}
	public void actionPerformed(ActionEvent e){
		int rand = new Random().nextInt(4);
		if (rand==0) {
			JOptionPane.showMessageDialog(null, "Don't buy clams from the homeless man on the corner");
		}
		else if (rand==1) {
			JOptionPane.showMessageDialog(null, "idk man i cant predict the future");
		}
		else if (rand==2) {
			JOptionPane.showMessageDialog(null, "help im being forced to type fortune cookies");
		}
		else if (rand==3) {
			JOptionPane.showMessageDialog(null, "u will have good fortun");
		}
	}
}
