import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JokeButtons implements ActionListener {
		public static void main(String[] args) {
			JokeButtons x = new JokeButtons();
			x.makeButton();
		}
		
		JButton button1;
		JButton button2;
		
		public void makeButton(){
			JFrame frame = new JFrame();
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			frame.add(panel);
			
			button1 = new JButton("Joke");
			panel.add(button1);
			button1.addActionListener(this);
			
			button2 = new JButton("Punchline");
			panel.add(button2);
			button2.addActionListener(this);
			
			frame.pack();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int a = 100;
			JButton buttonPressed = (JButton) e.getSource();
			if (buttonPressed.equals(button1)) {
				JOptionPane.showMessageDialog(null, "Why de chiken cross teh rode");
			}
			else if (buttonPressed.equals(button2)) {
				JOptionPane.showMessageDialog(null, "to get to da other side hahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahaha");
				while (a==100) {
					System.out.println("hahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahaha");
				}
			}
		}
}
