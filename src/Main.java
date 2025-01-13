import data.database.Dao;
import data.database.IDao;
import data.repository.Repository;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import domain.model.UserEntity;
import domain.repository.IRepository;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewEvent;
import presentation.inventory.InventoryViewState;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IDao dao = new Dao();
        IRepository repository = new Repository(dao);

        UserEntity testUser = new UserEntity(1, "testUser", "testPassword");

        Map<Integer, Integer> testLocation1 = new HashMap<>();
        testLocation1.put(10, 10);

        Map<Integer, Integer> testLocation2 = new HashMap<>();
        testLocation2.put(20, 20);

        OrderEntity testOrder1 = new OrderEntity(1, "standard", LocalDate.now(), testLocation1);
        OrderEntity testOrder2 = new OrderEntity(2, "express", LocalDate.now().plusDays(1), testLocation2);
        List<OrderEntity> orders = new ArrayList<>();
        orders.add(testOrder1);
        orders.add(testOrder2);


        InventoryViewState inventoryViewState = new InventoryViewState(
                testUser,
                orders
        );
        InventoryController inventoryController = new InventoryController(repository, inventoryViewState);
        InventoryView inventoryView = new InventoryView(inventoryViewState, inventoryController);

        System.out.println("Trwa wydawanie towaru.");
        List<OrderEntity> currentOrder = inventoryController.getCurrentOrder();
        inventoryViewState.currentOrder = currentOrder;

        inventoryView.displayAmountPrompt();
        int amount = Integer.parseInt(scanner.nextLine());

        if (amount < currentOrder.size()) {
            inventoryView.displayError("Za malo rzeczy w magazynie.");
        } else {
            proceedWithOrder(scanner, inventoryView, inventoryController, currentOrder, inventoryViewState);
        }

    }

    private static void proceedWithOrder(Scanner scanner, InventoryView inventoryView, InventoryController controller, List<OrderEntity> currentOrder, InventoryViewState state) {
        for (OrderEntity order : currentOrder) {
            inventoryView.displayLocation(order.location);
        }
        inventoryView.displayInputPrompt("Czy jest wystarczajaca ilosc rzeczy w magazynie? (0/1)");
        boolean sufficientAmount = Integer.parseInt(scanner.nextLine()) == 1;

        if (sufficientAmount) {
            controller.handleEvent(InventoryViewEvent.BarcodeScan);
            if (state.getOrderSucceeded()) {
                inventoryView.displaySuccess("Zamowienie zostalo wyslane");
            } else {
                inventoryView.displayError("Nie udalo sie wysłac towaru.");
            }
        } else {
            inventoryView.displayError("Ilość towarów nie zgadza się.");
        }
    }
}