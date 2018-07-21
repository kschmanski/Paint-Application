package view.interfaces;

import java.util.ArrayList;

import model.Pair;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public interface IInsertionObserver {

	void update(PaintCanvas canvas, ArrayList<ShapeConfiguration> list_of_shapes, ArrayList<Pair> list_of_starting_coordinates, ArrayList<Pair> list_of_ending_coordinates);
	
}
