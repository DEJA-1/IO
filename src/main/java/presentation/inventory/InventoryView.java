package presentation.inventory;

import domain.controllers.AdminController;
import domain.controllers.InventoryController;
import presentation.admin.AdminViewEvent;
import presentation.admin.AdminViewState;

import java.util.Map;

public class InventoryView {
    private String lastMessage;

    public InventoryViewState state;
    public InventoryController controller;

    public InventoryView(InventoryViewState state, InventoryController controller) {
        this.state = state;
        this.controller = controller;
    }

    public void sendEvent(InventoryViewEvent event) {
        if (controller != null) {
            controller.handleEvent(event);
        }
    }

    public void displayAmountPrompt() {
        lastMessage = "Podaj ilość towaru dostępnego w magazynie:";
        System.out.println(lastMessage);
    }

    public void displayInputPrompt(String prompt) {
        lastMessage = prompt;
        System.out.println(prompt);
    }

    public void displayError(String error) {
        lastMessage = error;
        System.out.println(error);
    }

    public void displaySuccess(String message) {
        lastMessage = message;
        System.out.println(message);
    }

    public void displayLocation(Map<Integer, Integer> location) {
        StringBuilder locationMessage = new StringBuilder("Lokalizacja: ");
        for (Map.Entry<Integer, Integer> entry : location.entrySet()) {
            locationMessage.append("[").append(entry.getKey()).append(", ").append(entry.getValue()).append("] ");
            System.out.println(locationMessage);
        }
        lastMessage = locationMessage.toString();

    }

    public String getLastMessage() {
        return lastMessage;
    }
}