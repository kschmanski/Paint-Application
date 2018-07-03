package main;

//this is a test comment 7/3/2018 from CDM


import controller.IJPaintController;
import controller.JPaintController;
import model.MouseHandler;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	PaintCanvas canvas = new PaintCanvas();
    	canvas.addMouseListener(new MouseHandler());
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
    }
}
