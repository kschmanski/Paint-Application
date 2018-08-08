package main;

import model.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable {

	ShapeList master_shapelist;
	ShapeList selected_shapelist;
	
	public DeleteShapeCommand(ShapeList master_shapelist, ShapeList selected_shapelist) {
		this.master_shapelist = master_shapelist;
		this.selected_shapelist = selected_shapelist;
		CommandHistory.add(this);
	}
	
	@Override
	public void run() {

		
		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			
			if (master_shapelist.getArrayLocation(selected_shapelist.get_list_of_shapes().get(counter), selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter)) > -1)
				master_shapelist.delete(selected_shapelist.get_list_of_shapes().get(counter), selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter));
			master_shapelist.notifyObservers();
		}
		
		//selected_shapelist.clear();
	}
	@Override
	public void undo() {
	
		int counter;
		for (counter = 0; counter < selected_shapelist.get_list_of_shapes().size(); counter++) {
			master_shapelist.add(selected_shapelist.get_list_of_shapes().get(counter), selected_shapelist.get_list_of_starting_coordinates().get(counter), selected_shapelist.get_list_of_ending_coordinates().get(counter));
			master_shapelist.notifyObservers();
		}
		
	}
	@Override
	public void redo() {
		run();
		
	}
		
		

}
