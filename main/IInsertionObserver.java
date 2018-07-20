package main;

import java.util.ArrayList;

import model.Pair;
import model.ShapeConfiguration;

public interface IInsertionObserver {

	void update(ArrayList<ShapeConfiguration> list_of_shapes, ArrayList<Pair> list_of_starting_coordinates, ArrayList<Pair> list_of_ending_coordinates);
	
}
