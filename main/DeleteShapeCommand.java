package main;

import model.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable {

	ShapeList my_shapelist;
	ShapeList selected_shapelist;
	
	public DeleteShapeCommand(ShapeList my_shapelist, ShapeList selected_shapelist) {
		this.my_shapelist = my_shapelist;
		this.selected_shapelist = selected_shapelist;
		CommandHistory.add(this);
	}
	
	@Override
	public void run() {

		
		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			my_shapelist.delete(selected_shapelist.get_list_of_shapes().get(counter), selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter));
			my_shapelist.notifyObservers();
		}
		
		//selected_shapelist.clear();
	}
	@Override
	public void undo() {
	
		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			my_shapelist.add(selected_shapelist.get_list_of_shapes().get(counter), selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter));
			my_shapelist.notifyObservers();
		}
		
	}
	@Override
	public void redo() {
		run();
		
	}
		
		

}
