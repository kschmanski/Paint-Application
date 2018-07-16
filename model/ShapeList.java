package model;

import java.util.ArrayList;

public class ShapeList {
	
	ArrayList<ShapeConfiguration> list_of_shapes;
	ArrayList<Pair> list_of_starting_coordinates;
	ArrayList<Pair> list_of_ending_coordinates;
	
	//constructor
	public ShapeList(ArrayList<ShapeConfiguration> list_of_shapes, ArrayList<Pair> list_of_starting_coordinates,
			ArrayList<Pair> list_of_ending_coordinates) {
		this.list_of_shapes = list_of_shapes;
		this.list_of_starting_coordinates = list_of_starting_coordinates;
		this.list_of_ending_coordinates = list_of_ending_coordinates;
	}

	public void add(ShapeConfiguration config, Pair starting, Pair ending) {
		list_of_shapes.add(config);
		list_of_starting_coordinates.add(starting);
		list_of_ending_coordinates.add(ending);
	}
	
	
}
