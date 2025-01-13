package presentation.inventory;

import domain.controllers.AdminController;
import domain.controllers.InventoryController;
import presentation.admin.AdminViewEvent;
import presentation.admin.AdminViewState;

import java.util.Map;

public class InventoryView {
    public InventoryViewState state;
    public InventoryController controller;

    public InventoryView(InventoryViewState state, InventoryController controller) {
        this.state = state;
        this.controller = controller;
    }

    public void sendEvent(InventoryViewEvent event) {
        controller.handleEvent(event);
    }

    public void displayGUI(InventoryViewState state) {

    }

    public void displayLocation(Map<Integer, Integer> location) {

    }

    public void displayConfirmationRequest() {

    }
}
