package notes_arrays;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cell {
	private int size;
	private int x,y;
	private int vx,vy;
	private Color color;
	private Rectangle collisionBox;
	
	private int r = (int)(Math.random()*200);
	private int gr = (int)(Math.random()*200);
	private int b = (int)(Math.random()*200);
	
	
	
	public Cell() {
		size = 30;
		x = 800-size/2;
		y = 450-size/2;
		vx = 0;
		vy = 0;
		
		int r = (int)(Math.random()*200);
		int gr = (int)(Math.random()*200);
		int b = (int)(Math.random()*200);
		
		color = new Color(r,gr,b);
	}
	public Cell(int argX,int argY,int argSize) {
		size = argSize;
		x = argX;
		y = argY;
		vx = 0;
		vy = 0;
	}
	
	public void paint(Graphics g) {
		collisionBox = new Rectangle(x,y,size,size);
		x += vx;
		y += vy;
		color = new Color(r,gr,b);
		g.setColor(color);
		g.fillOval(x-5,y-5,size+10,size+10);
		
		color = new Color(r+29,gr+29,b+29);
		g.setColor(color);
		g.fillOval(x,y,size,size);
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getVx() {
		return vx;
	}
	public int getVy() {
		return vy;
	}
	public int getSize() {
		return size;
	}
	
	public void setVx(int argX) {
		vx = argX;
	}
	public void setVy(int argY) {
		vy = argY;
	}
	public void increase(int argS) {
		x -= argS/2;
		y -= argS/2;
		size+=argS;
	}
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
}
