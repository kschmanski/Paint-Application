package model;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.AddSelectedShapesCommand;
import main.DrawShapeCommand;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class MouseHandler extends MouseAdapter  {
	
	
	PaintCanvas canvas;
	ApplicationState a;
	ShapeList s;
	static Pair starting;
	static Pair ending;
	
	public MouseHandler(PaintCanvas canvas, ApplicationState a, ShapeList s) {
		this.canvas = canvas;
		this.a = a;
		this.s = s;
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
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
			command = new DrawShapeCommand(canvas, config, s, starting, ending);			
			break;
		}
		
		// TO BE IMPLEMENTED SOON
		
		case "SELECT":
			ShapeConfiguration config = a.getCurrentShapeConfiguration();
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
			int starting_x = Math.min(starting.getX(), ending.getX());
			int starting_y = Math.min(starting.getY(), ending.getY());
			int width = Math.max(ending.getX() - starting.getX(), starting.getX() - ending.getX());
			int height = Math.max(ending.getY() - starting.getY(), starting.getY() - ending.getY());
			
			Rectangle selection_area = new Rectangle(starting_x, starting_y, width, height);
			CollisionDetector cd = new CollisionDetector(selection_area,s);
			
			command = new AddSelectedShapesCommand(starting, ending, s);
			break;
		/*	
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
