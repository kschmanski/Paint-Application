package model;

import java.util.ArrayList;
import view.gui.PaintCanvas;

//subject class to inform observer
public class ShapeList {
	
	PaintCanvas canvas;
	public ArrayList<ShapeConfiguration> list_of_shapes;
	public ArrayList<Pair> list_of_starting_coordinates;
	public ArrayList<Pair> list_of_ending_coordinates;
	ShapeDrawer sd = new ShapeDrawer();
	
	//constructor
	public ShapeList(PaintCanvas canvas) {
		this.canvas = canvas;
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
		sd.update(canvas, list_of_shapes, list_of_starting_coordinates, list_of_ending_coordinates);
	}
	
	//add method for selected shapes - so that it doesn't notify the observers that the canvas has changed
	public void add_selection(ShapeConfiguration config, Pair starting, Pair ending) {
		list_of_shapes.add(config);
		list_of_starting_coordinates.add(starting);
		list_of_ending_coordinates.add(ending);	
	}
	
	public void delete(ShapeConfiguration config, Pair starting, Pair ending) {
		int place = getArrayLocation(config, starting, ending);
		list_of_shapes.remove(place);
		list_of_starting_coordinates.remove(place);
		list_of_ending_coordinates.remove(place);
		notifyObservers();
	}
	
	public ArrayList<ShapeConfiguration> get_list_of_shapes() {
		return list_of_shapes;
	}
	
	public ArrayList<Pair> get_list_of_starting_coordinates() {
		return list_of_starting_coordinates;
	}

	public ArrayList<Pair> get_list_of_ending_coordinates() {
		return list_of_ending_coordinates;
	}
	
	public int getArrayLocation(ShapeConfiguration config, Pair starting, Pair ending) {
		int i = 0;
		while (i < list_of_shapes.size()) {
			if (config.getCurrentShapeType().toString() != list_of_shapes.get(i).getCurrentShapeType().toString() || starting.getX() != list_of_starting_coordinates.get(i).getX()
					|| starting.getY() != list_of_starting_coordinates.get(i).getY()
					|| ending.getX() != list_of_ending_coordinates.get(i).getX()
					|| ending.getY() != list_of_ending_coordinates.get(i).getY()
					)
				i++;
			else
				return i;
		}
		
		return -1;
	}
	
	
}
