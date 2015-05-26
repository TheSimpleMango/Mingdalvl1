// Copyright Wintriss Technical Schools 2013

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {
	
    public JLabel image;	//bass
    public JLabel image2;	//snare
    public JLabel image3;	//floor tom
    public JLabel image4;	//mid tom
    public JLabel image5;	//ride cymbal
    public JLabel image6;	//crash cymbal
    public JLabel image7;	//hi-hat

    public static void main(String[] args) throws Exception {
   	 new DrumKit().getGoing();
    }

    private void getGoing() throws MalformedURLException {
   	 JFrame frame = new JFrame();
   	 frame.setVisible(true);
   	 frame.setSize(500, 300);
   	 frame.setTitle("Drum Kit");
   	 
   	 JPanel panel = new JPanel();
   	 frame.add(panel);
   	 
   	 
   	 image = createImage("bass drum.jpeg");
   	 panel.add(image);
   	 image.addMouseListener(this);
   	 
  	 image2 = createImage("snare drum.jpeg");
  	 panel.add(image2);
  	 image2.addMouseListener(this);
   	 
  	 image3 = createImage("low tom.jpeg");
  	 panel.add(image3);
  	 image3.addMouseListener(this);
   	 
  	 image4 = createImage("mid tom.jpeg");
  	 panel.add(image4);
  	 image4.addMouseListener(this);
   	 
  	 image5 = createImage("ride cymbal.jpeg");
  	 panel.add(image5);
  	 image5.addMouseListener(this);
   	 
  	 image6 = createImage("crash cymbal.jpeg");
  	 panel.add(image6);
  	 image6.addMouseListener(this);
   	 
  	 image7 = createImage("hi hat.jpeg");
  	 panel.add(image7);
  	 
  	 image7.addMouseListener(this);
   	 
     /*
   	 
  	 JLabel image = createImage("");
  	 panel.add(image);
  	 image.addMouseListener(this);
   	 */
   	 
   	 panel.setLayout(new GridLayout());
   	 frame.pack();
    }

    public void mouseClicked(MouseEvent e) {
    	System.out.println("mouse clicked");
   	 	JLabel drumClicked = (JLabel) e.getSource();
   	 	
   	 	if (drumClicked == image){
   		playSound("bass drum.wav");
   	 	}
   	 	else if (drumClicked == image2){
   		playSound("snare.wav");
   	 	}
   	 	else if (drumClicked == image3){
   		playSound("FloorTom.wav");
   	 	}
   	 	else if (drumClicked == image4){
   		playSound("mid tom.wav");
   	 	}
   	 	else if (drumClicked == image5){
   		playSound("ride cymbal.wav");
   	 	}
   	 	else if (drumClicked == image6){
   		playSound("crash cymbal.wav");
   	 	}
   	 	else if (drumClicked == image7){
   		playSound("hi hat.wav");
   	 	}
    }

    private JLabel createImage(String fileName) throws MalformedURLException {
   	 URL imageURL = getClass().getResource(fileName);
   	 Icon icon = new ImageIcon(imageURL);
   	 JLabel imageLabel = new JLabel(icon);
   	 return imageLabel;
    }

    private void playSound(String fileName) {
   	 AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
   	 sound.play();
    }

}
