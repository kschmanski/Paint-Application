package main;

import model.Pair;
import model.ShapeConfiguration;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class MoveSelectedShapesCommand implements ICommand, IUndoable {
	
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
		
		CommandHistory.add(this);

	}
	
	@Override
	public void run() {
		
		//for each shape - move it by the amount moved using the move command:
		//for example, if we click and move 10 pixels down, each shape selected should move 10 pixels down
		
		int delta_x = ending.getX() - starting.getX();
		int delta_y = ending.getY() - starting.getY();
		int counter = 0;
		
		for (ShapeConfiguration sc : selected_shapelist.get_list_of_shapes()) {
			
			int location_in_master_list = my_shapelist.getArrayLocation(sc, selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter));
			
			my_shapelist.list_of_starting_coordinates.get(location_in_master_list).x += delta_x;
			my_shapelist.list_of_ending_coordinates.get(location_in_master_list).x += delta_x;
			my_shapelist.list_of_starting_coordinates.get(location_in_master_list).y += delta_y;
			my_shapelist.list_of_ending_coordinates.get(location_in_master_list).y += delta_y;
			
			counter++;
		}
		
		//notify observers
		my_shapelist.notifyObservers();
	}

	@Override
	public void undo() {

		
	}

	@Override
	public void redo() {

		
		
	}

}
