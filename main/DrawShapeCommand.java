package main;

import model.Pair;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class DrawShapeCommand implements ICommand {
	
	PaintCanvas canvas;
	ShapeConfiguration config;
	Pair starting_coords;
	Pair ending_coords;
	
	public DrawShapeCommand(PaintCanvas canvas, ShapeConfiguration config, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.config = config;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
	}
		
	
	@Override
	public void run() {

	ICommand command;
	

	switch(config.getCurrentShapeType().toString()) {
		case "TRIANGLE":
			command = new DrawTriangleCommand(canvas, config, starting_coords, ending_coords);
			break;
		case "RECTANGLE":
			command = new DrawRectangleCommand(canvas, config, starting_coords, ending_coords);
			break;
		case "ELLIPSE":
			command = new DrawEllipseCommand(canvas, config, starting_coords, ending_coords);
			break;
		default:
			throw new Error();
		
		
}
	command.run();
	}
}
