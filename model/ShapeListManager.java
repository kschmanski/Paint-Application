package model;

import view.gui.PaintCanvas;

//class that holds the three shapelists we'll need to use
public class ShapeListManager {

	private ShapeList master_shapelist;
	private ShapeList selected_shapelist;
	private ShapeList clipboard_shapelist;
	
	public ShapeListManager(PaintCanvas canvas) {
		master_shapelist = new ShapeList(canvas);
		selected_shapelist = new ShapeList(canvas);
		clipboard_shapelist = new ShapeList(canvas);
	}
	
	public ShapeList getMasterShapeList() {
		return master_shapelist;
	}
	
	public ShapeList getSelectedShapeList() {
		return selected_shapelist;
	}
	
	public ShapeList getClipboardShapeList() {
		return clipboard_shapelist;
	}
	
	
}
