package presentation.test.fitnesse;

import fit.ColumnFixture;
import domain.model.OrderEntity;
import presentation.OrderControl;
import presentation.inventory.InventoryView;
import java.util.Scanner;

public class HandleActualStateFixture extends ColumnFixture {
    public String scannerInput;
    public int currentOrderCount;

    private InventoryView inventoryView;
    private OrderEntity currentOrder;

    public boolean handleActualState() {
        this.inventoryView = new InventoryView(null, null);
        Scanner scanner = new Scanner(scannerInput);
        this.currentOrder = new OrderEntity(1, "test", null, null, currentOrderCount);

        return OrderControl.handleActualState(inventoryView, scanner, currentOrder);
    }

    public String getLastMessage() {
        return inventoryView.getLastMessage();
    }
}
