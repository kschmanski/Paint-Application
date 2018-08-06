package main;

import model.Pair;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class PasteShapeCommand implements ICommand, IUndoable {
	
	PaintCanvas canvas;
	ShapeList master_shapelist;
	ShapeList selected_shapelist;
	ShapeList clipboard_shapelist;
	
	public PasteShapeCommand(PaintCanvas canvas, ShapeList master_shapelist, ShapeList selected_shapelist, ShapeList clipboard_shapelist) {
		this.canvas = canvas;
		this.master_shapelist = master_shapelist;
		this.selected_shapelist = selected_shapelist;
		this.clipboard_shapelist = clipboard_shapelist;
		
		CommandHistory.add(this);
	}

	@Override
	public void run() {	
		
		int counter;
		for (counter = 0; counter < clipboard_shapelist.get_list_of_shapes().size(); counter++) {
			
			int starting_x = 200;
			int starting_y = 200;
			int ending_x = clipboard_shapelist.list_of_ending_coordinates.get(counter).getX() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getX();
			int ending_y = clipboard_shapelist.list_of_ending_coordinates.get(counter).getY() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getY();
		
			master_shapelist.add(clipboard_shapelist.get_list_of_shapes().get(counter), new Pair(starting_x, starting_y), new Pair(ending_x + starting_x, ending_y + starting_y));
			master_shapelist.notifyObservers();
		}
	}

	@Override
	public void undo() {
		int counter;
		
		for (counter = 0; counter < clipboard_shapelist.get_list_of_shapes().size(); counter++) {
			int starting_x = 200;
			int starting_y = 200;
			int ending_x = clipboard_shapelist.list_of_ending_coordinates.get(counter).getX() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getX();
			int ending_y = clipboard_shapelist.list_of_ending_coordinates.get(counter).getY() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getY();
		
			master_shapelist.delete(clipboard_shapelist.list_of_shapes.get(counter), new Pair(200, 200), new Pair(ending_x + starting_x, ending_y + starting_y));	
			master_shapelist.notifyObservers();
		}
		
	}

	@Override
	public void redo() {
		int counter;
		for (counter = 0; counter < clipboard_shapelist.get_list_of_shapes().size(); counter++) {
			
			int starting_x = 200;
			int starting_y = 200;
			int ending_x = clipboard_shapelist.list_of_ending_coordinates.get(counter).getX() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getX();
			int ending_y = clipboard_shapelist.list_of_ending_coordinates.get(counter).getY() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getY();
		
			master_shapelist.add(clipboard_shapelist.get_list_of_shapes().get(counter), new Pair(starting_x, starting_y), new Pair(ending_x + starting_x, ending_y + starting_y));
			master_shapelist.notifyObservers();
		}
		
	}
}
