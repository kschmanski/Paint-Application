package main;


import controller.IJPaintController;
import controller.JPaintController;
import model.MouseHandler;
import model.ShapeListManager;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	PaintCanvas canvas = PaintCanvas.getInstance();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        ShapeListManager manager = new ShapeListManager(canvas); //holder class for the three ShapeLists we'll use
    	canvas.addMouseListener(new MouseHandler(canvas, appState, manager.getMasterShapeList(), manager.getSelectedShapeList()));
        IJPaintController controller = new JPaintController(uiModule, appState, manager.getMasterShapeList(), manager.getSelectedShapeList(), manager.getClipboardShapeList(), canvas);
        controller.setup();
      
     
    }
}
