package domain.controllers;
import java.util.List;
import domain.model.OrderEntity;
import domain.model.UserEntity;
import domain.repository.IRepository;
import presentation.inventory.InventoryViewEvent;
import presentation.inventory.InventoryViewState;


public class InventoryController {
    private IRepository repository;
    private InventoryViewState state;
    private int orderID;
    private List<OrderEntity> currentOrder;

    private String barcode = "2137";

    public InventoryController(IRepository repository, InventoryViewState state) {
        this.repository = repository;
        this.state = state;
    }

    public List<OrderEntity> getCurrentOrder() {
        return state.currentOrder;
    }

    public void getInventory() {
        List<OrderEntity> inventory = repository.getAllOrders();
    }

    public void handleEvent(InventoryViewEvent event) {
        switch (event) {
            case CloseClick -> handleCloseClick();
            case BarcodeScan -> handleBarcodeScan();
            case FinishClick -> handleFinishClick();
            case UpdateClick -> handleUpdateClick();
            case PromptScanAgain -> handlePromptScanAgain();
        }
    }

    public void updateState(InventoryViewState newState) {
        this.state = newState;
    }

    private void handleCloseClick() {
    }

    private void handlePromptScanAgain() {
    }

    private void handleFinishClick() {
    }

    private void handleUpdateClick() {
    }

    private void handleBarcodeScan() {
        for (int i = 0; i < 3; i++) {
            boolean isValid = isBarcodeValid(barcode);
            if (isValid) {
                // zmiana statusu i wyswietlenie że wysłane
                break;
            } else {
                // print ze nieprawidlowy kod
            }
        }
    }

    private boolean isBarcodeValid(String barcode) {
        return barcode.length() == 3;
    }
}
