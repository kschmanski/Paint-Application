package controller;

import main.CopyShapeCommand;
import main.DeleteShapeCommand;
import main.PasteShapeCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    ShapeList my_shapelist;
    ShapeList selected_shapelist;
    ShapeList clipboard_shapelist;
    PaintCanvas canvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList my_shapelist, ShapeList selected_shapelist, ShapeList clipboard_shapelist, PaintCanvas canvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.my_shapelist = my_shapelist;
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
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(my_shapelist, selected_shapelist).run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand(my_shapelist, selected_shapelist, clipboard_shapelist).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand(canvas, my_shapelist, selected_shapelist, clipboard_shapelist).run());
    }
}
