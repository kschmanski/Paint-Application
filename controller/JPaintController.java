package controller;

import main.DeleteShapeCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    ShapeList my_shapelist;
    ShapeList selected_shapelist;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList my_shapelist, ShapeList selected_shapelist) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.my_shapelist = my_shapelist;
        this.selected_shapelist = selected_shapelist;
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
    }
}
