 // Copyright Wintriss Technical Schools 2013
import java.awt.Component;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {
	static Frame quizWindow = new Frame();

	public static void main(String[] args) throws Exception {
		quizWindow.setVisible(true);
		
		String photoURL = "http://who-is-awesome.com/who-is-awesome.jpg";
		Component img = createImage(photoURL);
		quizWindow.add(img);
		quizWindow.pack();
		
		String answer = JOptionPane.showInputDialog("Who's Awesome?");
		
		if (answer.equalsIgnoreCase("me")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
		}
		else{
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		
		quizWindow.remove(img);
		
		String photo2URL = "http://i1.kym-cdn.com/photos/images/newsfeed/000/122/857/tumblr_kv4399hWWz1qzdr4go1_500.jpg";
		Component img2 = createImage(photo2URL);
		quizWindow.add(img2);
		quizWindow.pack();
		
		String answer2 = JOptionPane.showInputDialog("Who's Not Awesome?");
		
		if (answer2.equalsIgnoreCase("not me")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
			
		}
		else{
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		
		
	}
	
	/*
	public static void askQuestion(String URL, String question, String answer) throws MalformedURLException{
		String photoURL = URL;
		Component img;
		img = createImage(photoURL);
		quizWindow.add(img);
		quizWindow.pack();
		
		String answer = JOptionPane.showInputDialog(question);
		
		if (answer.equalsIgnoreCase(answer)) {
			JOptionPane.showMessageDialog(null, "CORRECT");
			
		}
		else{
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
	}
	*/
	
	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image (imageComponent.addMouseMotionListener()) 
}
