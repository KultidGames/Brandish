package code;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BlockStone {
		private static ImageIcon Stone = new ImageIcon(BlockDirt.class.getResource("/Blocks/Stone.png"));
		
		public static Image getStone(){
			return Stone.getImage();
		}
	} 
