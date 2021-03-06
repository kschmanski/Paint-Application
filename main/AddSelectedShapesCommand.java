package main;


import java.awt.Rectangle;

import model.CollisionDetector;
import model.Pair;
import model.ShapeList;
import view.interfaces.ICommand;

public class AddSelectedShapesCommand implements ICommand {

	Pair starting;
	Pair ending;
	ShapeList master_shapelist;
	ShapeList selected_shapelist;
	
	public AddSelectedShapesCommand (Pair starting, Pair ending, ShapeList master_shapelist, ShapeList selected_shapelist) {
		this.starting = starting;
		this.ending = ending;
		this.master_shapelist = master_shapelist;
		this.selected_shapelist = selected_shapelist;
	}
	
	//adds our selected shapes to the "selected_shapelist" object
	@Override
	public void run() {
		
		int starting_x = Math.min(starting.getX(), ending.getX());
		int starting_y = Math.min(starting.getY(), ending.getY());
		int width = Math.max(ending.getX() - starting.getX(), starting.getX() - ending.getX());
		int height = Math.max(ending.getY() - starting.getY(), starting.getY() - ending.getY());
		
		Rectangle selection_area = new Rectangle(starting_x, starting_y, width, height);
		CollisionDetector cd = new CollisionDetector(selection_area, master_shapelist);
		
		int min_x = Math.min(starting.getX(), ending.getX());
		int min_y = Math.min(starting.getY(), ending.getY());
		int max_x = Math.max(starting.getX(),  ending.getX());
		int max_y = Math.max(starting.getY(),  ending.getY());
	
		Pair lower_selection_area_boundary = new Pair(min_x, min_y);
		Pair higher_selection_area_boundary = new Pair(max_x, max_y);
		
		int counter = 0;
		while (counter < master_shapelist.list_of_shapes.size()) {
			if (cd.collides(master_shapelist.list_of_starting_coordinates.get(counter), master_shapelist.list_of_ending_coordinates.get(counter), lower_selection_area_boundary, higher_selection_area_boundary)) {
					
				selected_shapelist.add_selection(master_shapelist.list_of_shapes.get(counter), master_shapelist.list_of_starting_coordinates.get(counter),
						master_shapelist.list_of_ending_coordinates.get(counter));
			}
			counter++;
		}		
		
	}
	
	public ShapeList getSelectedShapes() {
		return selected_shapelist;
	}

}
