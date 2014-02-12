package code;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loop extends Applet implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	public int x,y;
	public Image offscreen;
	public Graphics d;
	public boolean up, down, left, right;
	public BufferedImage wleft, wright, wup, wdo, rri, rle, back, still, rs, him, map,ls, fore, Hrt;
	public int counter;
	public int LeftA;
	public int UpA;
	public int DownA;
	public int Health=10;

	public void run() {
		x = 100;
		y = 100; //1:50 if Background wanted http://www.youtube.com/watch?v=dabnz7NSiUc
		try {
		fore = ImageIO.read(new File("Map_F.png"));
		map = ImageIO.read(new File("Map.png"));
		rle = ImageIO.read(new File("MainCharRightRun.png")); //c
		rri= ImageIO.read(new File("MainCharLeftRun.png"));//-
		wup= ImageIO.read(new File("MainChar.png"));//c
		wdo= ImageIO.read(new File("MainCharRunBack.png"));//-
		wright=ImageIO.read(new File("MainCharLeft.png"));//c
		wleft=ImageIO.read(new File("MainCharRight.png"));//-
		back=ImageIO.read(new File("MainCharStill.png"));//c
		still=ImageIO.read(new File("MainCharBack.png"));//-
		rs= ImageIO.read(new File("MainCharLeftStill.png"));//c
		ls= ImageIO.read(new File("MainCharRightStill.png"));//-
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		him=still;
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
			if (LeftA >= 40){
				LeftA=0;
			}
			if (LeftA >= 10 && LeftA <= 20 && left == true){
				him=wleft;
			}
			if (LeftA <= 20 && LeftA >=10 && left == true){
				him=rle;
			}
			if (LeftA <=30 && LeftA >=40 && left==true){
				him=ls;
			}
			if (LeftA >= 30 && LeftA <= 40 && left == true){
				him=wleft;
			}
			UpA++; 
			if (UpA >= 30){
				UpA=0;
			}
			if (UpA >= 10 && UpA <= 20 && up == true){
				him=wup; //wup
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
				Thread.sleep(01); //Standard 20, makes you go faster
			} catch (InterruptedException e) {
				e.printStackTrace();
			} }
		}
	public void keyPressed(KeyEvent e) { //If Incorrect, e = "arg0"
		if (e.getKeyCode() == 68 ){ //left
			left = true;
		}
		if (e.getKeyCode() == 65 ){ //right
			right = true;
		}
		if (e.getKeyCode() == 83 ){ //up
			up = true;
		}
		if (e.getKeyCode() == 87 ){ //down
			down = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 68 ){
			left = false;
			him = rle;
		}
		if (e.getKeyCode() == 65 ){
				right = false;
				him = rri;
			}
		if (e.getKeyCode() == 83 ){
				up = false;
				him = wup;
			}
		if (e.getKeyCode() == 87 ){
				down = false;
				him = wdo;
			}			
		}
	public void keyTyped(KeyEvent e) {}

	public void Health() {
		if (Health==10){
			try {
				Hrt = ImageIO.read(new File("H" + Health + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	System.out.println(Health);
	}	
}