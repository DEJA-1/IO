package presentation.admin;

import domain.controllers.AdminController;

public class AdminView {
    public AdminViewState state;
    public AdminController controller;

    public AdminView(AdminViewState state, AdminController controller) {
        this.state = state;
        this.controller = controller;
    }

    public void sendEvent(AdminViewEvent event) {
        controller.handleEvent(event);
    }

    public void displayGUI(AdminViewState state) {

    }
}
