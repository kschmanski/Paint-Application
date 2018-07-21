package main;

import model.Pair;
import model.ShapeConfiguration;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class DrawShapeCommand implements ICommand {
	
	PaintCanvas canvas;
	ShapeConfiguration config;
	Pair starting_coords;
	Pair ending_coords;
	ShapeList my_shapelist;
	
	public DrawShapeCommand(PaintCanvas canvas, ShapeConfiguration config, ShapeList my_shapelist, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.config = config;
		this.my_shapelist = my_shapelist;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
	}
		
	
	@Override
	public void run() {
		my_shapelist.add(config, starting_coords, ending_coords);
	}
}
