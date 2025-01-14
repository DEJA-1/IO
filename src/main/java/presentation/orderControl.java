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
public class orderControl {

    public static void printBadOrders(IDao dao) {
        if (dao.getBadOrders().isEmpty()) {
            return;
        }

        System.out.println("Wypisywanie zlych zamowien");

        for (List<OrderEntity> orderList : dao.getBadOrders()) {
            for (OrderEntity order : orderList) {
                System.out.println(order);
            }
        }
    }

    public static boolean handleActualState(InventoryView inventoryView, Scanner scanner, OrderEntity currentOrder) {
        if(currentOrder == null) {return false;}

        inventoryView.displayAmountPrompt();
        int amount = Integer.parseInt(scanner.nextLine());

        if (amount <= 0){
            return false;
        }

        if (amount < currentOrder.count) {
            inventoryView.displayError("Za malo rzeczy w magazynie.");
            return false;
        }

        return true;
    }
    public static boolean handleLocation(OrderEntity order, InventoryView view, Scanner scan) {
        if (order == null) { return false; }

        view.displayLocation(order.location);

        view.displayInputPrompt("Czy jest wystarczajaca ilosc rzeczy w magazynie? (0/1)");
        boolean ret = false;

        try {
            ret = Integer.parseInt(scan.nextLine()) == 1;
        } catch (NumberFormatException e) {
            ret = false;
        }

        return ret;
    }

    public static boolean handleOrderFeedback(OrderEntity order, boolean isValid, InventoryView view, InventoryController controller, InventoryViewState state) {
        if (order == null) { return false; }

        if (isValid) {
            controller.handleEvent(InventoryViewEvent.BarcodeScan);

            if (state.getOrderSucceeded()) {
                view.displaySuccess("Zamowienie zostalo wyslane");
                return true;
            }

            view.displayError("Nie udalo sie wysłac towaru.");
            return false;
        }

        view.displayError("Ilość towarów nie zgadza się.");
        return false;
    }
}
