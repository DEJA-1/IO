import data.database.Dao;
import data.database.IDao;
import data.repository.Repository;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import domain.model.UserEntity;
import domain.repository.IRepository;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewState;

import java.time.LocalDate;
import java.util.*;

import static presentation.OrderControl.*;

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

        OrderEntity testOrder1 = new OrderEntity(1, "book_3", LocalDate.now(), testLocation1, 4);
        OrderEntity testOrder2 = new OrderEntity(2, "toilet", LocalDate.now().plusDays(1), testLocation2, 9);
        OrderEntity testOrder3 = new OrderEntity(3, "book_34", LocalDate.now(), testLocation1, 10);
        OrderEntity testOrder4 = new OrderEntity(4, "toilet_2", LocalDate.now().plusDays(1), testLocation2, 3);
        List<OrderEntity> orders1 = new ArrayList<>();
        orders1.add(testOrder1);
        orders1.add(testOrder2);

        List<OrderEntity> orders2 = new ArrayList<>();
        orders2.add(testOrder3);
        orders2.add(testOrder4);

        dao.addOrder(orders1);
        dao.addOrder(orders2);

        InventoryViewState inventoryViewState = new InventoryViewState(testUser, repository.getOrderById(1));
        InventoryController inventoryController = new InventoryController(repository, inventoryViewState);
        InventoryView inventoryView = new InventoryView(inventoryViewState, inventoryController);

        System.out.println("Trwa wydawanie towaru.");

        do {
            List<OrderEntity> orderList = inventoryController.getCurrentOrder();

            for (OrderEntity order : orderList) {
                boolean isValid = handleLocation(order, inventoryView, scanner);
                boolean isOrderTaken = handleOrderFeedback(order, isValid, inventoryView, inventoryController, inventoryViewState);

                if (!isOrderTaken) {
                    dao.addBadOrder(orderList);
                    break;
                }

                if (handleActualState(inventoryView, scanner, order)) {
                    dao.addBadOrder(orderList);
                    break;
                }
            }

        } while (dao.getOrder() != null);

        printBadOrders(dao);
    }
}
