package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent e) {
		int starting_x = e.getX();
		int starting_y = e.getY();
		Pair toReturn = new Pair(starting_x, starting_y);
		//System.out.printf("Mouse clicked at %d, %d\n", starting_x, starting_y);
		System.out.printf("mouse clicked at %d, %d\n", toReturn.getFirst(), toReturn.getSecond());
	
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		int ending_x = e.getX();
		int ending_y = e.getY();
		Pair toReturn = new Pair(ending_x, ending_y);
		//System.out.printf("Mouse released at %d, %d\n", ending_x, ending_y);
		System.out.printf("mouse released at %d, %d\n", toReturn.getFirst(), toReturn.getSecond());
	}
	
	}
