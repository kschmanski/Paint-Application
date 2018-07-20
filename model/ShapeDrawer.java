package model;

import java.util.ArrayList;

import main.IInsertionObserver;

//observer class
public class ShapeDrawer implements IInsertionObserver {

	@Override
	public void update(ArrayList<ShapeConfiguration> list_of_shapes, ArrayList<Pair> list_of_starting_coordinates, ArrayList<Pair> list_of_ending_coordinates) {
		System.out.println("we're updating now!\n");
		
	}

	
	
}
