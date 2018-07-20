package model;

import java.util.ArrayList;

import main.DrawEllipseCommand;
import main.DrawRectangleCommand;
import main.DrawTriangleCommand;
import main.ICommand;
import main.IInsertionObserver;
import view.gui.PaintCanvas;

//observer class
public class ShapeDrawer implements IInsertionObserver {

	@Override
	public void update(PaintCanvas canvas, ArrayList<ShapeConfiguration> list_of_shapes, ArrayList<Pair> list_of_starting_coordinates, ArrayList<Pair> list_of_ending_coordinates) {
		
		ICommand command;
		int counter = 0;
		
		//iterates over the list of our shapes to draw them on the canvas
		while (counter < list_of_shapes.size()) {
		
		switch(list_of_shapes.get(counter).getCurrentShapeType().toString()) {
			case "TRIANGLE":
				command = new DrawTriangleCommand(canvas, list_of_shapes.get(counter), list_of_starting_coordinates.get(counter), list_of_ending_coordinates.get(counter));
				break;
			case "RECTANGLE":
				command = new DrawRectangleCommand(canvas, list_of_shapes.get(counter), 
						list_of_starting_coordinates.get(counter), list_of_ending_coordinates.get(counter));
				break;
			case "ELLIPSE":
				command = new DrawEllipseCommand(canvas, list_of_shapes.get(counter), 
						list_of_starting_coordinates.get(counter), list_of_ending_coordinates.get(counter));
				break;
			default:
				throw new Error();
			
			
	}
		command.run(); 
		counter++;
		}
	}

	
	
}
