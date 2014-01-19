package code; //Blocks

import java.awt.Image;

public class Terrain {
	private int id;
	private Image getBlockImage;
	public int getid(){
		return id;
	}
	
	public Image getImage(){
		return getBlockImage;
	}
	
	public void setid(int id){
		getBlockImage = BlockImages.getBlockImages(id);
	}
}//http://www.youtube.com/watch?v=JO5WAY0oGlA 
