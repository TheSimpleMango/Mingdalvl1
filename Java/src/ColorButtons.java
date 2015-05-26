import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ColorButtons implements ActionListener {
	public static void main(String[] args) {
		ColorButtons x = new ColorButtons();
		x.setup();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	
	public void setup(){
		frame.setVisible(true);
		frame.add(panel);
		
		button1.setBackground(Color.yellow);
		button1.setOpaque(true);
		button1.setText("yellow");
		button1.addActionListener(this);
		panel.add(button1);

		button2.setBackground(Color.red);
		button2.setOpaque(true);
		button2.setText("red");
		button2.addActionListener(this);
		panel.add(button2);

		button3.setBackground(Color.blue);
		button3.setOpaque(true);
		button3.setText("blue");
		button3.addActionListener(this);
		panel.add(button3);

		button4.setBackground(Color.green);
		button4.setOpaque(true);
		button4.setText("green");
		button4.addActionListener(this);
		panel.add(button4);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed.equals(button1)) {
			speak("yellow");
		}
		else if (buttonPressed.equals(button2)) {
			speak("red");
		}
		else if (buttonPressed.equals(button3)) {
			speak("blue");
		}
		else if (buttonPressed.equals(button4)) {
			speak("green");
		}
	}
	
	public void speak(String words){
		try {
			Runtime.getRuntime().exec("say " + words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
