package main;

import model.ShapeList;
import view.interfaces.ICommand;

public class CopyShapeCommand implements ICommand {

	ShapeList my_shapelist;
	ShapeList selected_shapelist;
	ShapeList clipboard_shapelist;
	public CopyShapeCommand(ShapeList my_shapelist, ShapeList selected_shapelist, ShapeList clipboard_shapelist) {
		this.my_shapelist = my_shapelist;
		this.selected_shapelist = selected_shapelist;
		this.clipboard_shapelist = clipboard_shapelist;
	}
	
	
	@Override
	public void run() {
		
		clipboard_shapelist.clear();
		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			clipboard_shapelist.add_selection(selected_shapelist.get_list_of_shapes().get(counter), 
					selected_shapelist.get_list_of_starting_coordinates().get(counter)
					, selected_shapelist.get_list_of_ending_coordinates().get(counter));
		}
		
	}

}
