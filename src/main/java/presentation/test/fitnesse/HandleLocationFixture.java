//package presentation.test.fitnesse;
//
//import domain.model.OrderEntity;
//import fit.Fixture;
//import presentation.inventory.InventoryView;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class HandleLocationFixture extends Fixture {
//    private OrderEntity currentOrder;
//    private InventoryView inventoryView;
//    private Scanner scanner;
//
//    private final Map<Integer, Integer> testLocation1 = new HashMap<>();
//    private final Map<Integer, Integer> testLocation2 = new HashMap<>();
//    private final List<OrderEntity> orders = new ArrayList<>();
//
//    public HandleLocationFixture() {
//        System.out.println("HandleLocationFixture loaded");
//        this.testLocation1.put(10, 10);
//        this.testLocation2.put(20, 20);
//        this.orders.add(new OrderEntity(1, "book_3", LocalDate.now(), this.testLocation1, 4));
//        this.orders.add(new OrderEntity(2, "toilet", LocalDate.now().plusDays(1L), this.testLocation2, 9));
//        this.orders.add(new OrderEntity(3, "book_34", LocalDate.now(), this.testLocation1, 10));
//        this.orders.add(new OrderEntity(4, "toilet_2", LocalDate.now().plusDays(1L), this.testLocation2, 3));
//    }
//
//
//    public void setScannerInput(String input) {
//        if ("null".equalsIgnoreCase(input)) {
//            this.scanner = null;
//        } else {
//            this.scanner = new Scanner(input);
//        }
//    }
//
//    public void setOrderById(int orderId) {
//        this.currentOrder = orders.stream()
//                .filter(order -> order.getTransactionId() == orderId)
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void setInventoryView(InventoryView inventoryView) {
//        this.inventoryView = inventoryView;
//    }
//
//    public boolean handleLocation() {
//        return presentation.orderControl.handleLocation(currentOrder, inventoryView, scanner);
//    }
//}
