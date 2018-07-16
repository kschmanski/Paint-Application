package main;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.Pair;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class DrawTriangleCommand implements ICommand {

	private PaintCanvas canvas;

	private ShapeConfiguration config;
	private Pair starting_coords;
	private Pair ending_coords;

	public DrawTriangleCommand(PaintCanvas canvas, ShapeConfiguration config, Pair starting_coords, Pair ending_coords) {
		this.canvas = canvas;
		this.config = config;

		this.starting_coords = starting_coords;
		this.ending_coords = ending_coords;

	}
	
	@Override
	public void run() {
		Graphics2D graphics2d = canvas.getGraphics2D();
	
		int[] xpoints = { starting_coords.getX(), ending_coords.getX(), starting_coords.getX() - (ending_coords.getX() - starting_coords.getX()) };
		int[] ypoints = { starting_coords.getY(), ending_coords.getY(), ending_coords.getY() };	
		
        graphics2d.setColor(config.getPrimaryColor().toColor(config.getPrimaryColor()));

        graphics2d.fillPolygon(xpoints, ypoints, 3);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(config.getSecondaryColor().toColor(config.getSecondaryColor()));

        graphics2d.drawPolygon(xpoints, ypoints, 3);

	}
	
}
