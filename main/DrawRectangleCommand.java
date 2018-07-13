package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.Pair;
import model.ShapeColor;
import view.gui.PaintCanvas;
import java.lang.Math.*;

public class DrawRectangleCommand implements ICommand {
	
	private PaintCanvas canvas;
	private ShapeColor color;
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawRectangleCommand(PaintCanvas canvas, ShapeColor color, Pair starting_coords, Pair ending_coords) {
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		this.canvas = canvas;
		this.color = color;
	
	}

	

	@Override
	public void run() {
		
		int starting_x = Math.min(starting_coords.getX(), ending_coords.getX());
		int starting_y = Math.min(starting_coords.getY(), ending_coords.getY());
		int width = Math.max(ending_coords.getX() - starting_coords.getX(), starting_coords.getX() - ending_coords.getX());
		int height = Math.max(ending_coords.getY() - starting_coords.getY(), starting_coords.getY() - ending_coords.getY());
		
		Graphics2D graphics2d = canvas.getGraphics2D();
		
		//System.out.printf("we're setting the color to %s", color.toString());
		
		
        graphics2d.setColor();
        
        
        Color.class.string
       
        
        
        graphics2d.fillRect(starting_x, starting_y, width, height);
        graphics2d.setStroke(new BasicStroke(5));
       // graphics2d.setColor(Color.blue);
        graphics2d.setColor(Color.getColor(color.toString()));
        graphics2d.drawRect(starting_x, starting_y, width, height);


		
	}
}
