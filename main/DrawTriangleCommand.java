package main;

import model.Pair;
import model.ShapeType;

public class DrawTriangleCommand implements ICommand {

	private Pair starting_coords;
	private Pair ending_coords;

	public DrawTriangleCommand(Pair starting_coords, Pair ending_coords) {
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		//run();
		
	}
	
	@Override
	public void run() {
		System.out.printf("we'll be printing a triangle\n");
		
	}
	
}
