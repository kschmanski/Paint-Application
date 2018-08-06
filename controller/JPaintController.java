package controller;

import main.CopyShapeCommand;
import main.DeleteShapeCommand;
import main.PasteShapeCommand;
import main.RedoCommand;
import main.UndoCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    ShapeList master_shapelist;
    ShapeList selected_shapelist;
    ShapeList clipboard_shapelist;
    PaintCanvas canvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList master_shapelist, ShapeList selected_shapelist, ShapeList clipboard_shapelist, PaintCanvas canvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.master_shapelist = master_shapelist;
        this.selected_shapelist = selected_shapelist;
        this.clipboard_shapelist = clipboard_shapelist;
        this.canvas = canvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(master_shapelist, selected_shapelist).run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand(master_shapelist, selected_shapelist, clipboard_shapelist).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand(canvas, master_shapelist, selected_shapelist, clipboard_shapelist).run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
    }
}
