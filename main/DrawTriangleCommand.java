package main;

import java.awt.Graphics2D;

import model.Pair;
import model.ShapeColor;
import view.gui.PaintCanvas;

public class DrawTriangleCommand implements ICommand {

	private PaintCanvas canvas;
	private ShapeColor primary_color;
	private ShapeColor secondary_color;
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawTriangleCommand(PaintCanvas canvas, ShapeColor primary_color, ShapeColor secondary_color, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.primary_color = primary_color;
		this.secondary_color = secondary_color;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;

		
	}
	
	@Override
	public void run() {
		System.out.printf("we'll be printing a triangle\n");
		Graphics2D graphics2d = canvas.getGraphics2D();
		
        graphics2d.setColor(primary_color.toColor(primary_color));
        //graphics2d.drawPolygon(p);
		
	}
	
}
