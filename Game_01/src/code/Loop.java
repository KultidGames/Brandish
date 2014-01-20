package code;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loop extends Applet implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	public int x,y;
	public Image offscreen;
	public Graphics d;
	public boolean up, down, left, right;
	public BufferedImage wleft, wright, wup, wdo, rri, rle, back, him, still, rs;
	public int counter;
	public int LeftA;
	public int UpA;
	public int DownA;
	public void run() {
		x = 100;
		y = 100; //1:50 if Background wanted http://www.youtube.com/watch?v=dabnz7NSiUc
		try {
		rle = ImageIO.read(new FileInputStream("Images/MainCharLeftRun.png)"));
		rri= ImageIO.read(new FileInputStream("Images/MainCharRightRun.png"));
		wup= ImageIO.read(new FileInputStream("Images/MainCharRunBack.png"));
		wdo= ImageIO.read(new FileInputStream("Images/MainChar.png"));
		wright=ImageIO.read(new FileInputStream("Images/MainCharRight.png"));
		wleft=ImageIO.read(new FileInputStream("Images/MainCharLeft.png"));
		back=ImageIO.read(new FileInputStream("Images/MainCharBack.png"));
		still=ImageIO.read(new FileInputStream("Images/MainCharStill.png"));
		rs= ImageIO.read(new FileInputStream("Images/MainCharRightStill.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		him = still;
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
