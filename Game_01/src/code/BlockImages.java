package code;

import java.awt.Image;

public class BlockImages {
	public static Image getBlockImages1(int id) {
		if(id == 0){
			return BlockDirt.getDirt();
		}else if(id == 1){
			return BlockDirt.getGrass();
		}
		
		
		else if(id == 10){
			return BlockStone.getStone();
		}
		return null;
	}

	public static Image getBlockImages(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
