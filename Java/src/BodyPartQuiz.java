// Copyright Wintriss Technical Schools 2013
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BodyPartQuiz {
	
	String image1 = "/Users/mingdahe/Documents/workspace/Mingdalvl1/src/Shailene Woodley.jpeg";
	String image2 = "/Users/mingdahe/Documents/workspace/Mingdalvl1/src/Andrew Lincoln.jpg";
	String image3 = "/Users/mingdahe/Documents/workspace/Mingdalvl1/src/Matt Smith.jpg";

	Frame window = new Frame();
	
	private void startQuiz() {
		window.setSize(300, 500);
		int score = 0;
		
		loadImage(image1);
		String answer = JOptionPane.showInputDialog("Who is this?");
		if (answer.equalsIgnoreCase("Shailene Woodley")) {
			JOptionPane.showMessageDialog(null, "You are right!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "You are incorrect!");
			score--;
		}
		System.out.println("Your score is " + score);
		
		
		showNextImage();
		loadImage(image2);
		String answer2 = JOptionPane.showInputDialog("Who is this?");
		if (answer2.equalsIgnoreCase("Andrew Lincoln")) {
			JOptionPane.showMessageDialog(null, "You are right!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "You are incorrect!");
			score--;
		}
		System.out.println("Your score is " + score);
		
		
		showNextImage();
		loadImage(image3);
		String answer3 = JOptionPane.showInputDialog("Who is this?");
		if (answer3.equalsIgnoreCase("Matt Smith")) {
			JOptionPane.showMessageDialog(null, "You are right!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "You are incorrect!");
			score--;
		}
		System.out.println("Your final "
				+ "score is " + score);
	}

	public void showNextImage() {
		window.removeAll();
		window.add(getNextImage());
		window.pack();
	}

	public static void main(String[] args) {
		BodyPartQuiz quiz = new BodyPartQuiz();
		quiz.initializeGui();
		quiz.startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setVisible(true);
		showNextImage();
	}

	private JLabel loadImage(String fileName) {
		Icon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		return image;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(image1);
		imageList.add(imageLabel);
		imageLabel = loadImage(image2);
		imageList.add(imageLabel);
		imageLabel = loadImage(image3);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();
		window.dispose();
		return new JLabel();
	}
}
