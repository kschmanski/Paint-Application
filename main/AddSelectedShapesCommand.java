package main;

import java.util.ArrayList;

import model.Pair;
import model.ShapeConfiguration;
import model.ShapeList;
import view.interfaces.ICommand;

public class AddSelectedShapesCommand implements ICommand {

	Pair starting;
	Pair ending;
	ShapeList s;
	
	public AddSelectedShapesCommand (Pair starting, Pair ending, ShapeList s) {
		this.starting = starting;
		this.ending = ending;
		this.s = s;
	}
	
	@Override
	public void run() {
		//ArrayList<ShapeConfiguration> list_of_selected_shapes = new ArrayList<ShapeConfiguration>();
		int num_selected_shapes = 0;
		
		
		num_selected_shapes = s.get_list_of_shapes().size();
		//System.out.printf("we've selected %d shapes!\n", num_selected_shapes);
		
		
	}

}
