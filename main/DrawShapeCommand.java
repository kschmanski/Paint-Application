package main;

import model.Pair;
import model.ShapeConfiguration;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class DrawShapeCommand implements ICommand, IUndoable {
	
	PaintCanvas canvas;
	ShapeConfiguration config;
	Pair starting_coords;
	Pair ending_coords;
	ShapeList master_shapelist;
	
	public DrawShapeCommand(PaintCanvas canvas, ShapeConfiguration config, ShapeList master_shapelist, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.config = config;
		this.master_shapelist = master_shapelist;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		
		CommandHistory.add(this);
	}
		
	
	@Override
	public void run() {
		master_shapelist.add(config, starting_coords, ending_coords);
	}


	@Override
	public void undo() {
		master_shapelist.delete(config, starting_coords, ending_coords);		
	}


	@Override
	public void redo() {
		run();
		
	}
}
