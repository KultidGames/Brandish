package code;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Menu {
	private static ImageIcon menu = new ImageIcon(Menu.class.getResource("/Stars.png"));

	public static Image getmenuSplash(){
		return menu.getImage();
	}
}
