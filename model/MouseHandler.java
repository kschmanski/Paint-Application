package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("Mouse clicked at %d, %d\n", e.getX(), e.getY());
	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.print("Released!");
	}
	
	}
