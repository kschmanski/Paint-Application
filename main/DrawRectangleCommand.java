package main;

import model.Pair;

public class DrawRectangleCommand implements ICommand {
	
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawRectangleCommand(Pair starting_coords, Pair ending_coords) {
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		//run();
		
	}
	
	@Override
	public void run() {
		System.out.printf("we'll be printing a rectangle\n");
		
	}
}
