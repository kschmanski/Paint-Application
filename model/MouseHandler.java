package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.AddSelectedShapesCommand;
import main.DrawShapeCommand;
import main.MoveSelectedShapesCommand;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;

public class MouseHandler extends MouseAdapter  {
	
	PaintCanvas canvas;
	ApplicationState state;
	ShapeList master_shapelist;
	ShapeList selected_shapelist;
	static Pair starting;
	static Pair ending;
	
	public MouseHandler(PaintCanvas canvas, ApplicationState state, ShapeList master_shapelist, ShapeList selected_shapelist) {
		this.canvas = canvas;
		this.state = state;
		this.master_shapelist = master_shapelist;
		this.selected_shapelist = selected_shapelist;
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
		int ending_x = e.getX();
		int ending_y = e.getY();
		ending = new Pair(ending_x, ending_y);
		
		switch(state.getActiveStartAndEndPointMode().toString()) {
		
		case "DRAW": {
			ShapeConfiguration config = state.getCurrentShapeConfiguration();
			command = new DrawShapeCommand(canvas, config, master_shapelist, starting, ending);	
			break;
		}
	
		case "SELECT": {
			selected_shapelist.clear();
			command = new AddSelectedShapesCommand(starting, ending, master_shapelist, selected_shapelist);
			break;
		}
			
		case "MOVE": {
			command = new MoveSelectedShapesCommand(canvas, starting, ending, master_shapelist, selected_shapelist);
			break;
			
		}
		
		default:
			throw new Error("Command not recognized");	

		}
		
		command.run();
		
		
	}
	
	}
