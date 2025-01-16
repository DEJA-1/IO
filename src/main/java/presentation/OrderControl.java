package presentation;

import data.database.IDao;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import org.springframework.boot.SpringBootConfiguration;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewEvent;
import presentation.inventory.InventoryViewState;

import java.util.List;
import java.util.Scanner;

@SpringBootConfiguration
public class OrderControl {

    public static void printBadOrders(IDao dao) {
        if (dao.getBadOrders().isEmpty()) {
            return;
        }

        System.out.println("Wypisywanie złych zamówień");

        for (List<OrderEntity> orderList : dao.getBadOrders()) {
            for (OrderEntity order : orderList) {
                System.out.println(order);
            }
        }
    }

    public static boolean handleActualState(InventoryView inventoryView, Scanner scanner, OrderEntity currentOrder) {
        if (currentOrder == null) {
            inventoryView.displayError("Brak aktualnego zamówienia.");
            return false;
        }

        inventoryView.displayAmountPrompt();
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            inventoryView.displayError("Nieprawidłowa ilość.");
            return false;
        }

        if (amount <= 0) {
            inventoryView.displayError("Ilość nie może być mniejsza lub równa zero.");
            return false;
        }

        if (amount < currentOrder.getCount()) {
            inventoryView.displayError("Za mało rzeczy w magazynie.");
            return false;
        }

        inventoryView.displaySuccess("Ilość jest poprawna.");
        return true;
    }

    public static boolean handleLocation(OrderEntity order, InventoryView view, Scanner scan) {
        if (order == null) {
            view.displayError("Brak zamówienia.");
            return false;
        }

        view.displayLocation(order.getLocation());
        view.displayInputPrompt("Czy jest wystarczająca ilość rzeczy w magazynie? (0/1)");

        try {
            return Integer.parseInt(scan.nextLine()) == 1;
        } catch (NumberFormatException e) {
            view.displayError("Nieprawidłowa odpowiedź.");
            return false;
        }
    }

    public static boolean handleOrderFeedback(OrderEntity order, boolean isValid, InventoryView view, InventoryController controller, InventoryViewState state) {
        if (order == null) {
            view.displayError("Brak zamówienia do przetworzenia.");
            return false;
        }

        if (isValid) {
            controller.handleEvent(InventoryViewEvent.BarcodeScan);

            if (state.getOrderSucceeded()) {
                view.displaySuccess("Zamówienie zostało wysłane.");
                return true;
            }

            view.displayError("Nie udało się wysłać towaru.");
            return false;
        }

        view.displayError("Ilość towarów nie zgadza się.");
        return false;
    }
}
