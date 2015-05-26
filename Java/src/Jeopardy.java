// Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton, secondButton, thirdButton, fourthButton, fifthButton, sixthButton;
	
	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		JFrame frame = new JFrame();
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());
		frame.show();
		frame.setTitle("Jeopardy");
		
		JPanel header = createHeader("");
		quizPanel.add(header);
		
		frame.add(quizPanel);
		
		firstButton = createButton("$100");
		quizPanel.add(firstButton);
		firstButton.addActionListener(this);
		
		secondButton = createButton("$200");
		quizPanel.add(secondButton);
		secondButton.addActionListener(this);
		
		thirdButton = createButton("$400");
		quizPanel.add(thirdButton);
		thirdButton.addActionListener(this);
		
		fourthButton = createButton("$600");
		quizPanel.add(fourthButton);
		fourthButton.addActionListener(this);
		
		fifthButton = createButton("$800");
		quizPanel.add(fifthButton);
		fifthButton.addActionListener(this);
		
		sixthButton = createButton("$1000");
		quizPanel.add(sixthButton);
		sixthButton.addActionListener(this);
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount+1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height, Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 /*
	 [optional] Use the showImage or playSound methods when the user answers a question 
	 [optional] Add new topics for the quiz
	 */
	
	private JButton createButton(String dollarAmount) {
		JButton button = new JButton();
		button.setText(dollarAmount);
		buttonCount++;
		return button;
	}

	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null,"You pressed " + ((JButton)arg0.getSource()).getText() + " button.");
		
		playJeopardyTheme();

		JButton buttonPressed = (JButton) arg0.getSource();
		
		if (buttonPressed == firstButton) {
			askQuestion("whut", "whut", 100);
		}
		else if (buttonPressed == secondButton) {
			askQuestion("whut", "whut", 200);
		}
		else if (buttonPressed ==thirdButton) {
			askQuestion("whut", "whut", 400);
		}
		else if (buttonPressed == fourthButton) {
			askQuestion("whut", "whut", 600);
		}
		else if (buttonPressed == fifthButton) {
			askQuestion("whut", "whut", 800);
		}
		else if (buttonPressed == sixthButton) {
			askQuestion("When is election day?", "the first tuesday after the first monday after the national pheonix bald eagle has been sacrificed and its ashes and blood have been spilled on the statue of liberty, under the blue moon of the leap year during the solstice ritual of the illuminati.", 1000);
		}
		
		buttonPressed.setText(null);
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		String answer = JOptionPane.showInputDialog(question);
		
		if (answer.equals(correctAnswer)) {
			score+=prizeMoney;
			updateScore();
			JOptionPane.showMessageDialog(null, "You are Correct!");
		}
		else {
			score-=prizeMoney;
			JOptionPane.showMessageDialog(null, "The correct answer was " + correctAnswer);
			updateScore();
		}
	}

	public void playJeopardyTheme() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new URL("http://school.wintrisstech.org/sounds/jeopardy.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}


	private void playSound(String fileName, boolean play) throws InterruptedException {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource("JeopardyTheme.mp3"));
			scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}