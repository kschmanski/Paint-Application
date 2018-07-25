package model;

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
	ShapeList my_shapelist;
	static Pair starting;
	static Pair ending;
	
	public MouseHandler(PaintCanvas canvas, ApplicationState a, ShapeList my_shapelist) {
		this.canvas = canvas;
		this.a = a;
		this.my_shapelist = my_shapelist;
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
			command = new DrawShapeCommand(canvas, config, my_shapelist, starting, ending);			
			break;
		}
		
	
		
		case "SELECT":
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
			command = new AddSelectedShapesCommand(starting, ending, my_shapelist);
			break;
			
		// TO BE IMPLEMENTED SOON
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
