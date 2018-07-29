package main;

import model.Pair;
import model.ShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class PasteShapeCommand implements ICommand {
	
	PaintCanvas canvas;
	ShapeList my_shapelist;
	ShapeList selected_shapelist;
	ShapeList clipboard_shapelist;
	
	public PasteShapeCommand(PaintCanvas canvas, ShapeList my_shapelist, ShapeList selected_shapelist, ShapeList clipboard_shapelist) {
		this.canvas = canvas;
		this.my_shapelist = my_shapelist;
		this.selected_shapelist = selected_shapelist;
		this.clipboard_shapelist = clipboard_shapelist;

	}

	@Override
	public void run() {	
		
		int counter;
		for (counter = 0; counter < clipboard_shapelist.get_list_of_shapes().size(); counter++) {
			
			int starting_x = 200;
			int starting_y = 200;
			int ending_x = clipboard_shapelist.list_of_ending_coordinates.get(counter).getX() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getX();
			int ending_y = clipboard_shapelist.list_of_ending_coordinates.get(counter).getY() - clipboard_shapelist.list_of_starting_coordinates.get(counter).getY();
		
			ICommand command = new DrawShapeCommand(canvas, clipboard_shapelist.get_list_of_shapes().get(counter), my_shapelist, new Pair(starting_x, starting_y), new Pair(ending_x + starting_x, ending_y + starting_y));	
			command.run();
		}
	}
}
