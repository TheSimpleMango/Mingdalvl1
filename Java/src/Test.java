import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Test implements ActionListener {
	
	Test(){
	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;

	//Create the menu bar.
	menuBar = new JMenuBar();

	//Build the first menu.
	menu = new JMenu("File");
	menu.setMnemonic(KeyEvent.VK_F);
	menu.getAccessibleContext().setAccessibleDescription(
	        "File menu");
	menuBar.add(menu);

	//JMenuItems show the menu items
	menuItem = new JMenuItem("New",
	                         new ImageIcon("images/new.gif"));
	menuItem.setMnemonic(KeyEvent.VK_N);
	menu.add(menuItem);

	// add a separator
	menu.addSeparator();

	menuItem = new JMenuItem("Pause", new ImageIcon("images/pause.gif"));
	menuItem.setMnemonic(KeyEvent.VK_P);
	menu.add(menuItem);

	menuItem = new JMenuItem("Exit", new ImageIcon("images/exit.gif"));
	menuItem.setMnemonic(KeyEvent.VK_E);
	menu.add(menuItem);

	// add menu bar to frame
	frame.setJMenuBar(theJMenuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

   