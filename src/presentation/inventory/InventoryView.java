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

    public void displayInputPrompt(String prompt) {
        System.out.println(prompt);
    }

    public void displayAmountPrompt() {
        System.out.println("Podaj ilość towaru dostępnego w magazynie:");
    }

    public void displayLocationPrompt() {
        System.out.println("Podaj lokalizacje towaru w magazynie:");
    }

    public void displayError(String error) {
        System.out.println(error);
    }

    public void displayLocation(Map<Integer, Integer> location) {
        for (Map.Entry<Integer, Integer> entry : location.entrySet()) {
            System.out.println("Współrzędne: " + entry.getKey()+ ", " + entry.getValue());
        }
    }

    public void displayConfirmationRequest() {

    }
}
