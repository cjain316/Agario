package notes_arrays;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AgarMain extends JPanel implements KeyListener, ActionListener {
	ArrayList<Cell> cells = new ArrayList<Cell>();
	Cell c = new Cell();
	public void paint(Graphics g) {
		super.paintComponent(g);
		c.paint(g);
		
		for (int i = 0; i < cells.size();i++) {
			cells.get(i).paint(g);
			if (colliding(c,cells.get(i))) {
				if (cells.get(i).getSize() <= c.getSize()) {
					c.increase(cells.get(i).getSize()/10);
					cells.remove(i);
				}
				
				
			}
		}
	}
	
	Timer t;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgarMain f = new AgarMain();
	}
	
	public void keyPressed(KeyEvent arg) {
		if (arg.getExtendedKeyCode() == 87) {
			for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVy(2);
			}
	    }
	    if (arg.getExtendedKeyCode() == 83) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVy(-2);
			}
	    }
	    if (arg.getExtendedKeyCode() == 65) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVx(2);
			}
	    }
	    if (arg.getExtendedKeyCode() == 68) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVx(-2);
			}
	    }
	}
	
	public void keyReleased(KeyEvent arg) {
		if (arg.getExtendedKeyCode() == 87) {
			for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVy(0);
			}
	    }
	    if (arg.getExtendedKeyCode() == 83) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVy(0);
			}
	    }
	    if (arg.getExtendedKeyCode() == 65) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVx(0);
			}
	    }
	    if (arg.getExtendedKeyCode() == 68) {
	    	for (int i = 0; i < cells.size();i++) {
				cells.get(i).setVx(0);
			}
	    }
	}
	
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public AgarMain() {
        JFrame f = new JFrame("Agar.io");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,900);
        f.add(this);
        f.addKeyListener(this);
        t = new Timer(7,this);
        t.start();
        f.setVisible(true);
       
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		if (Math.random()>0.95) {
			if (cells.size() < 100) {
				cells.add(new Cell((int)(Math.random()*1920),(int)(Math.random()*1080),(int)(Math.random()*(c.getSize()*2))+10));
				for (int i = 0; i < cells.size();i++) {
					cells.get(i).setVy(cells.get(0).getVy());
					cells.get(i).setVx(cells.get(0).getVx());
				}
			}
		}
		
	}
	public boolean colliding(Cell b, Cell p){
        return b.getCollisionBox().intersects(p.getCollisionBox());
    }
}
