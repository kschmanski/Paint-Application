package model;

import java.util.ArrayList;

//subject class to inform observer
public class ShapeList {
	
	ArrayList<ShapeConfiguration> list_of_shapes;
	ArrayList<Pair> list_of_starting_coordinates;
	ArrayList<Pair> list_of_ending_coordinates;
	ShapeDrawer sd = new ShapeDrawer();
	//constructor
	public ShapeList() {
		list_of_shapes = new ArrayList<ShapeConfiguration>();
		list_of_starting_coordinates = new ArrayList<Pair>();
		list_of_ending_coordinates = new ArrayList<Pair>();
	};

	public void add(ShapeConfiguration config, Pair starting, Pair ending) {
		list_of_shapes.add(config);
		list_of_starting_coordinates.add(starting);
		list_of_ending_coordinates.add(ending);	
		notifyObservers();
	}
	
	public void notifyObservers() {
		sd.update(list_of_shapes, list_of_starting_coordinates, list_of_ending_coordinates);
	}
	
}
