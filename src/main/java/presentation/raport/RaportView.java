package presentation.raport;

import domain.controllers.AdminController;
import domain.controllers.RaportController;
import presentation.admin.AdminViewEvent;
import presentation.admin.AdminViewState;

public class RaportView {
    public RaportViewState state;
    public RaportController controller;

    public RaportView(RaportViewState state, RaportController controller) {
        this.state = state;
        this.controller = controller;
    }

    public void sendEvent(RaportViewEvent event) {
        controller.handleEvent(event);
    }

    public void displayGUI(RaportViewState state) {

    }
}
