package view.gui;

import javax.swing.JComponent;


import java.awt.*;

//refactored to use singleton pattern so we only create one instance of PaintCanvas

public class PaintCanvas extends JComponent {
	
	private static final PaintCanvas instance = new PaintCanvas();
	
	private PaintCanvas() {}
	
	public static PaintCanvas getInstance(){
		return instance;
	}
    public Graphics2D getGraphics2D() {
    	Graphics2D graphics = (Graphics2D)getGraphics();
    
        return (Graphics2D)getGraphics();
    }
    
    
}
