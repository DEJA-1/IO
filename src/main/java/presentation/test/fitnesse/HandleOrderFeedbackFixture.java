package presentation.test.fitnesse;

import fit.ColumnFixture;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import domain.repository.IRepository;
import data.database.Dao;
import data.repository.Repository;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleOrderFeedbackFixture extends ColumnFixture {
    public boolean isValid;
    public int orderId;

    private InventoryView inventoryView;
    private InventoryController inventoryController;
    private InventoryViewState inventoryViewState;
    private OrderEntity currentOrder;

    public boolean handleOrderFeedback() {
        Dao dao = new Dao();

        Map<Integer, Integer> testLocation1 = new HashMap<>();
        testLocation1.put(10, 10);

        Map<Integer, Integer> testLocation2 = new HashMap<>();
        testLocation2.put(20, 20);

        OrderEntity testOrder1 = new OrderEntity(1, "book_3", null, testLocation1, 4);
        OrderEntity testOrder2 = new OrderEntity(2, "toilet", null, testLocation2, 9);

        List<OrderEntity> orders = new ArrayList<>();
        orders.add(testOrder1);
        orders.add(testOrder2);
        dao.addOrder(orders);

        IRepository repository = new Repository(dao);

        this.inventoryViewState = new InventoryViewState(null, null);

        this.inventoryView = new InventoryView(inventoryViewState, null);

        this.inventoryController = new InventoryController(repository, inventoryViewState);

        if (orderId == 1) {
            currentOrder = testOrder1;
        } else if (orderId == 2) {
            currentOrder = testOrder2;
        } else {
            currentOrder = null;
        }

        return presentation.OrderControl.handleOrderFeedback(currentOrder, isValid, inventoryView, inventoryController, inventoryViewState);
    }

    public String getLastMessage() {
        return inventoryView.getLastMessage();
    }
}
