package domain.controllers;
import java.util.List;
import domain.model.OrderEntity;
import domain.repository.IRepository;
import presentation.inventory.InventoryViewEvent;
import presentation.inventory.InventoryViewState;


public class InventoryController {
    private IRepository repository;
    private InventoryViewState state;
    private int orderID;
    private OrderEntity currentOrder;

    public InventoryController(IRepository repository, InventoryViewState state) {
        this.repository = repository;
        this.state = state;
    }

    public OrderEntity getCurrentOrder() {
        return currentOrder;
    }

    public void getInventory() {
        List<OrderEntity> inventory = repository.getAllOrders();
        // Update the state with inventory data
//        state.setInventory(inventory);
    }

    public void handleEvent(InventoryViewEvent event) {
        // Handle the event, depending on the type
    }

    public void updateState(InventoryViewState newState) {
        this.state = newState;
    }

    public void handleCloseClick() {
        // Handle closing the inventory view
    }

    public void handleFinishClick() {
        // Handle finishing an operation
    }

    public void handleUpdateClick() {
        // Handle updating the inventory
    }

    public void handleBarcodeScan() {
        // Handle scanning a barcode
    }

    public boolean isBarcodeValid() {
        // Logic to check if a barcode is valid
        return true; // Placeholder implementation
    }
}
