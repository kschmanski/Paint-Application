package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent e) {
		int starting_x = e.getX();
		int starting_y = e.getY();
		Pair toReturn = new Pair(starting_x, starting_y);
		System.out.printf("mouse clicked at %d, %d\n", toReturn.getX(), toReturn.getY());
	
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		int ending_x = e.getX();
		int ending_y = e.getY();
		Pair toReturn = new Pair(ending_x, ending_y);
		System.out.printf("mouse released at %d, %d\n", toReturn.getX(), toReturn.getY());
	}
	
	
	
	}

//drawshape command -> then run it w/ X,Y coords
//check StartandEndPointMode on MouseRelease - if select, create a select command.
//if move, create move command. etc.  But for now, just create a createshape command
//CreateShape command calls Run -> creates a shape that contains the start point and end point,
//primary color, secondary color, and the shading type.
//Use strategy pattern to show how we'll draw the shape
//add this newly created shape to the ShapeList (ShapeList could use Observer pattern)
