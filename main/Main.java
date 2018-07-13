package main;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
    	canvas.addMouseListener(new MouseHandler(canvas, appState));
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
       
    }
}
