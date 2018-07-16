package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.DrawEllipseCommand;
import main.DrawRectangleCommand;
import main.DrawShapeCommand;
import main.DrawTriangleCommand;
import main.ICommand;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class MouseHandler extends MouseAdapter  {
	
	PaintCanvas canvas;
	ApplicationState a;
	static Pair starting;
	static Pair ending;
	
	public MouseHandler(PaintCanvas canvas, ApplicationState a) {
		this.canvas = canvas;
		this.a = a;
	};
	
	@Override
	public void mousePressed(MouseEvent e) {
		int starting_x = e.getX();
		int starting_y = e.getY();
		starting = new Pair(starting_x, starting_y);
	
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		
		ICommand command;
		
		switch(a.getActiveStartAndEndPointMode().toString()) {
		case "DRAW": {
			ShapeConfiguration config = a.getCurrentShapeConfiguration();
			//ShapeColor primary_color = a.getActivePrimaryColor();
			//ShapeColor secondary_color = a.getActiveSecondaryColor();
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
		
			command = new DrawShapeCommand(canvas, config, starting, ending);
			break;
		}
		
		// TO BE IMPLEMENTED SOON
		/*
		case "SELECT": 
			
			break;
			
		case "MOVE":
			
			break;
			*/
		default:
			throw new Error();
		

		}
		
		command.run();
		
		
	}
	
	
	
	
	}

//drawshape command -> then run it w/ X,Y coords
//check StartandEndPointMode on MouseRelease - if select, create a select command.
//if move, create move command. etc.  But for now, just create a createshape command
//CreateShape command calls Run -> creates a shape that contains the start point and end point,
//primary color, secondary color, and the shading type.
//Use strategy pattern to show how we'll draw the shape
//add this newly created shape to the ShapeList (ShapeList could use Observer pattern)
