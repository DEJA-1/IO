package presentation.test.fitnesse;

import fit.ColumnFixture;
import domain.model.OrderEntity;
import presentation.OrderControl;
import presentation.inventory.InventoryView;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HandleLocationFixture extends ColumnFixture {
    public String scannerInput;
    public int currentOrderId;

    private InventoryView inventoryView;
    private OrderEntity currentOrder;

    public boolean handleLocation() {
        this.inventoryView = new InventoryView(null, null);
        Scanner scanner = new Scanner(scannerInput);

        // Wyszukaj zamówienie na podstawie ID
        Map<Integer, Integer> testLocation1 = new HashMap<>();
        testLocation1.put(10, 10);

        Map<Integer, Integer> testLocation2 = new HashMap<>();
        testLocation2.put(20, 20);

        if (currentOrderId == 1) {
            currentOrder = new OrderEntity(1, "book_3", null, testLocation1, 4);
        } else if (currentOrderId == 2) {
            currentOrder = new OrderEntity(2, "toilet", null, testLocation2, 9);
        } else {
            currentOrder = null;
        }

        return OrderControl.handleLocation(currentOrder, inventoryView, scanner);
    }

    public String getLastMessage() {
        return inventoryView.getLastMessage();
    }
}
