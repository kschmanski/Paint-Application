package main;

import model.Pair;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class MoveSelectedShapesCommand implements ICommand {
	
	PaintCanvas canvas;
	Pair starting;
	Pair ending;
	ShapeList my_shapelist;
	ShapeList selected_shapelist;
	
	public MoveSelectedShapesCommand(PaintCanvas canvas, Pair starting, Pair ending, ShapeList my_shapelist, ShapeList selected_shapelist) {
		this.canvas = canvas;
		this.starting = starting;
		this.ending = ending;
		this.my_shapelist = my_shapelist;
		this.selected_shapelist = selected_shapelist;

	}
	
	@Override
	public void run() {
		System.out.printf("we'll be moving %d shapes!\n", selected_shapelist.list_of_shapes.size());
		
	}

}
