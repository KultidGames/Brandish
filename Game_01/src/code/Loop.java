package code;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Loop extends Applet implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	public int x,y;
	public Image offscreen;
	public Graphics d;
	public boolean up, down, left, right;
	public URL wleft, wright, wup, wdo, rri, rle, back, still, rs, him;
	public int counter;
	public int LeftA;
	public int UpA;
	public int DownA;
	public Image img = null;
	public void run() {
		x = 100;
		y = 100; //1:50 if Background wanted http://www.youtube.com/watch?v=dabnz7NSiUc
		URL rle = this.getClass().getResource("Images/MainCharLeftRun.png)");
		URL rri= this.getClass().getResource("Images/MainCharRightRun.png");
		URL wup= this.getClass().getResource("Images/MainCharRunBack.png");
		URL wdo= this.getClass().getResource("Images/MainChar.png");
		URL wright=this.getClass().getResource("Images/MainCharRight.png");
		URL wleft=this.getClass().getResource("Images/MainCharLeft.png");
		URL back=this.getClass().getResource("Images/MainCharBack.png");
		URL still=this.getClass().getResource("Images/MainCharStill.png");
		URL rs= this.getClass().getResource("Images/MainCharRightStill.png");
		//him=still;
		try {
			img = ImageIO.read(new FileInputStream("Images/MainCharStill.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			counter++;
			if (counter >= 40){
				counter=0;
			}
			if (counter >= 10 && counter <= 20 && right == true){ //Doesn't seem to work, is in res folder -FIXED-
				him=wright;
			}
			if (counter <= 20 && counter >=10 && right == true){
				him=rri;
			}
			if (counter >=20 && counter <=30 && right == true){
				him=rs;
			}
			if (counter >= 30 && counter <= 40 && right == true){
				him=wright;
			}
			LeftA++; 
			if (LeftA >= 30){
				LeftA=0;
			}
			if (LeftA >= 10 && LeftA <= 20 && left == true){
				him=wleft;
			}
			if (LeftA <= 20 && LeftA >=10 && left == true){
				him=rle;
			}
			if (LeftA >= 20 && LeftA <= 30 && left == true){
				him=wleft;
			}
			UpA++; 
			if (UpA >= 30){
				UpA=0;
			}
			if (UpA >= 10 && UpA <= 20 && up == true){
				him=wup;
			}
			if (UpA <= 20 && UpA >=10 && up == true){
				him=back;
			}
			if (UpA >= 20 && UpA <= 30 && up == true){
				him=wup;
			}
			DownA++; 
			if (DownA >= 30){
				DownA=0;
			}
			if (DownA >= 10 && DownA <= 20 && down == true){
				him=still;
			}
			if (DownA <= 20 && DownA >=10 && down == true){
				him=wdo;
			}
			if (DownA >= 20 && DownA <= 30 && down == true){
				him=still;
			}
			if (left == true){ //Something is wrong here -Fixed-
				x--;
			}
			if (right == true){ //Just fix all the animations -Fixed-
				x++;
			}
			if (up == true){ 				
				y--;
			}
			if (down == true){
				y++;
			}
			repaint();
			try {
				Thread.sleep(10); //Standard 20, makes you go faster
			} catch (InterruptedException e) {
				e.printStackTrace();
			} }
		}
	public void keyPressed(KeyEvent e) { //If Incorrect, e = "arg0"
		if (e.getKeyCode() == 65 ){
			left = true;
		}
		if (e.getKeyCode() == 68 ){
			right = true;
		}
		if (e.getKeyCode() == 87 ){
			up = true;
		}
		if (e.getKeyCode() == 83 ){
			down = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 65 ){
			left = false;
			him = rle;
		}
		if (e.getKeyCode() == 68 ){
				right = false;
				him = rri;
			}
		if (e.getKeyCode() == 87 ){
				up = false;
				him = wup;
			}
		if (e.getKeyCode() == 83 ){
				down = false;
				him = wdo;
			}			
		}
	public void keyTyped(KeyEvent e) {}
}
