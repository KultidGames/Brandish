package code;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BlockDirt {
	private static ImageIcon Grass = new ImageIcon(BlockDirt.class.getResource("/Brandish/Game_01/Blocks/Grass.png"));
	private static ImageIcon Dirt = new ImageIcon(BlockDirt.class.getResource("/Brandish/Game_01/Blocks/TilledGrass.png"));
	
	public static Image getDirt(){
		return Dirt.getImage();
		
	}
	public static Image getGrass(){
		return Grass.getImage();
		
	}
}
 //On the third
