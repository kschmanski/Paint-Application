package main;

import model.Pair;
import model.ShapeColor;
import view.gui.PaintCanvas;

public class DrawEllipseCommand implements ICommand {
	
	private PaintCanvas canvas;
	private ShapeColor color;
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawEllipseCommand(PaintCanvas canvas, ShapeColor color, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.color = color;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		//run();
		
	}
	
	@Override
	public void run() {
		
		
		System.out.printf("we'll be printing an ellipse\n");
		
	}
}
