package main;

import model.Pair;
import model.ShapeConfiguration;
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
		
		//for each shape - move it by the amount moved using the move command:
		//for example, if we click and move 10 pixels down, each shape selected should move 10 pixels down
		
		int delta_x = ending.getX() - starting.getX();
		int delta_y = ending.getY() - starting.getY();
		
		for (ShapeConfiguration sc : selected_shapelist.get_list_of_shapes()) {
			System.out.printf("we'll be moving shape %s by x: %d y: %d\n", sc.getCurrentShapeType().toString(), delta_x, delta_y);
						
		}
	}

}
