package model;

import view.gui.PaintCanvas;

public class ShapeListManager {

	private ShapeList my_shapelist;
	private ShapeList selected_shapelist;
	private ShapeList clipboard_shapelist;
	
	public ShapeListManager(PaintCanvas canvas) {
		my_shapelist = new ShapeList(canvas);
		selected_shapelist = new ShapeList(canvas);
		clipboard_shapelist = new ShapeList(canvas);
	}
	
	public ShapeList getMyShapeList() {
		return my_shapelist;
	}
	
	public ShapeList getSelectedShapeList() {
		return selected_shapelist;
	}
	
	public ShapeList getClipboardShapeList() {
		return clipboard_shapelist;
	}
	
	
}
