package main;

import model.Pair;

public class DrawEllipseCommand implements ICommand {
	
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawEllipseCommand(Pair starting_coords, Pair ending_coords) {
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		//run();
		
	}
	
	@Override
	public void run() {
		System.out.printf("we'll be printing an ellipse\n");
		
	}
}
