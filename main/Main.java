package main;


import controller.IJPaintController;
import controller.JPaintController;
import model.MouseHandler;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	PaintCanvas canvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        
        //should create a holder class for these three shapelists
        
    	ShapeList my_shapelist = new ShapeList(canvas);
    	ShapeList selected_shapelist = new ShapeList(canvas);
    	ShapeList clipboard_shapelist = new ShapeList(canvas);
    	
    	canvas.addMouseListener(new MouseHandler(canvas, appState, my_shapelist, selected_shapelist));
        IJPaintController controller = new JPaintController(uiModule, appState, my_shapelist, selected_shapelist, clipboard_shapelist, canvas);
        controller.setup();
      
     
    }
}


/*
 * Observer pattern for the ShapeDrawer class listening to ShapeList
 * Dependency Injection passing the canvas (and other variables) around
 * Command pattern for DrawEllipse, DrawRectangle, DrawTriangle etc
 */