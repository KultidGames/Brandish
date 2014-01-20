package code;

import java.awt.Graphics;


public class Skeleton extends Loop{ //Should extend Applet?
	private static final long serialVersionUID = 1L;
	public void init(){
	Thread th= new Thread(this);
	th.start();
	offscreen = createImage(1080,1080); // 120, 160
	d = offscreen.getGraphics();
	addKeyListener(this); //15:43
	GenLoader.blocks();
	}
public static final int HEIGHT = 120; //Original Height/Width= "120 x 160"
public static final int WIDTH = 160;
public static final String TITLE= "Test Game BETA";
public static final int SCALE = 3;

public void paint(Graphics g) {
	d.clearRect(0, 0, 1080, 1080); //Error Here, Scale perhaps? -Disregard //0, 0, 160, 120
    d.drawImage(him, x, y,60, 60, this);     //12:17 http://www.youtube.com/watch?v=XmRD0PlAXEY
	g.drawImage(offscreen, 0, 0, this);
	}
	public void update(Graphics g){  //http://www.javacodegeeks.com/2011/08/eclipse-how-attach-java-source.html
		paint(g); 

	} //Finished at 15:33 ERROR w/ the circle -Fixed
} 
//2D Tile Engine Must be Created
