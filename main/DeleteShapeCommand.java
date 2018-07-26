package main;

import model.ShapeList;
import view.interfaces.ICommand;

public class DeleteShapeCommand implements ICommand {

	ShapeList my_shapelist;
	ShapeList selected_shapelist;
	
	public DeleteShapeCommand(ShapeList my_shapelist, ShapeList selected_shapelist) {
		this.my_shapelist = my_shapelist;
		this.selected_shapelist = selected_shapelist;
	}
	@Override
	public void run() {

		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			my_shapelist.delete(selected_shapelist.get_list_of_shapes().get(0), selected_shapelist.get_list_of_starting_coordinates().get(0), selected_shapelist.get_list_of_ending_coordinates().get(0));
			my_shapelist.notifyObservers();
		}
		
	}
		
		

}
