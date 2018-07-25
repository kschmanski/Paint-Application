package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.Pair;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class DrawEllipseCommand implements ICommand {
	
	private PaintCanvas canvas;
	private ShapeConfiguration config;
	private Pair starting_coords;
	private Pair ending_coords;
	

	public DrawEllipseCommand(PaintCanvas canvas, ShapeConfiguration config, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.config = config;
		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;
		
	}
	
	@Override
	public void run() {
		
		int starting_x = Math.min(starting_coords.getX(), ending_coords.getX());
		int starting_y = Math.min(starting_coords.getY(), ending_coords.getY());
		int width = Math.max(ending_coords.getX() - starting_coords.getX(), starting_coords.getX() - ending_coords.getX());
		int height = Math.max(ending_coords.getY() - starting_coords.getY(), starting_coords.getY() - ending_coords.getY());
		
		Graphics2D graphics2d = canvas.getGraphics2D();
		if (config.getShadingType().toString() != "OUTLINE")
			graphics2d.setColor(config.getPrimaryColor().toColor(config.getPrimaryColor()));
		else
			graphics2d.setColor(new Color(0, 0, 0, 0)); //transparent color
        graphics2d.fillOval(starting_x, starting_y, width, height);
        graphics2d.setStroke(new BasicStroke(5));
        if (config.getShadingType().toString() == "OUTLINE_AND_FILLED_IN")
        	graphics2d.setColor(config.getSecondaryColor().toColor(config.getSecondaryColor()));
        else if (config.getShadingType().toString() == "OUTLINE")
        	graphics2d.setColor(config.getPrimaryColor().toColor(config.getPrimaryColor()));
        graphics2d.drawOval(starting_x, starting_y, width, height);
        
		
	}
}
