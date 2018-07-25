package model;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.AddSelectedShapesCommand;
import main.DrawShapeCommand;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class MouseHandler extends MouseAdapter  {
	
	
	PaintCanvas canvas;
	ApplicationState a;
	ShapeList my_shapelist;
	static Pair starting;
	static Pair ending;
	
	public MouseHandler(PaintCanvas canvas, ApplicationState a, ShapeList my_shapelist) {
		this.canvas = canvas;
		this.a = a;
		this.my_shapelist = my_shapelist;
	};
	
	@Override
	public void mousePressed(MouseEvent e) {
		int starting_x = e.getX();
		int starting_y = e.getY();
		starting = new Pair(starting_x, starting_y);
	
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		
		ICommand command;
		
		switch(a.getActiveStartAndEndPointMode().toString()) {
		case "DRAW": {
			ShapeConfiguration config = a.getCurrentShapeConfiguration();
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
			command = new DrawShapeCommand(canvas, config, my_shapelist, starting, ending);			
			break;
		}
		
	
		
		case "SELECT":
			//ShapeConfiguration config = a.getCurrentShapeConfiguration();
			int ending_x = e.getX();
			int ending_y = e.getY();
			ending = new Pair(ending_x, ending_y);
			
			int starting_x = Math.min(starting.getX(), ending.getX());
			int starting_y = Math.min(starting.getY(), ending.getY());
			int width = Math.max(ending.getX() - starting.getX(), starting.getX() - ending.getX());
			int height = Math.max(ending.getY() - starting.getY(), starting.getY() - ending.getY());
			
			Rectangle selection_area = new Rectangle(starting_x, starting_y, width, height);
			CollisionDetector cd = new CollisionDetector(selection_area, my_shapelist);
			
			int min_x = Math.min(starting.getX(), ending.getX());
			int min_y = Math.min(starting.getY(), ending.getY());
			int max_x = Math.max(starting.getX(),  ending.getX());
			int max_y = Math.max(starting.getY(),  ending.getY());
		
			Pair lower_selection_area_boundary = new Pair(min_x, min_y);
			Pair higher_selection_area_boundary = new Pair(max_x, max_y);
			
			
			ArrayList<ShapeConfiguration> selected_shapes = new ArrayList<ShapeConfiguration>();
			int counter = 0;
			int num_selected_shapes = 0;
			while (counter < my_shapelist.list_of_shapes.size()) {
				if (cd.collides(
						my_shapelist.list_of_starting_coordinates.get(counter), my_shapelist.list_of_ending_coordinates.get(counter), lower_selection_area_boundary, higher_selection_area_boundary)) {
						
					num_selected_shapes++;
					selected_shapes.add(my_shapelist.list_of_shapes.get(counter));
				}
				counter++;
			}
			
			System.out.printf("we've selected %d shapes\n", num_selected_shapes);
			command = new AddSelectedShapesCommand(starting, ending, my_shapelist);
			break;
			
		// TO BE IMPLEMENTED SOON
		/*	
		case "MOVE":
			
			break;
			*/
		
		default:
			throw new Error();
		

		}
		
		command.run();
		
		
	}
	
	}
