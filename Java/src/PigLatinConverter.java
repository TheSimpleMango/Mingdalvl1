import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PigLatinConverter implements ActionListener{
	public static void main(String[] args) {
		PigLatinConverter a = new PigLatinConverter();
		a.setupUI();
	}
	
	JFrame frame = new JFrame("Pig Latin Translator");
	JPanel panel = new JPanel();
	JTextField input = new JTextField(25);
	JLabel answer = new JLabel();
	JButton button = new JButton("Translate");
	
	public void setupUI(){
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(input);
		
		panel.add(button);
		button.addActionListener(this);
		
		panel.add(answer);
		
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		answer.setText(translate(input.getText()));
		frame.pack();
	}
	
	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}
			if (i >= s.length())
				break;
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}
	
	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e'
					|| word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
}