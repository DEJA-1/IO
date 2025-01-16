//package presentation.test.fitnesse;
//
//import domain.controllers.InventoryController;
//import domain.model.OrderEntity;
//import fit.Fixture;
//import presentation.inventory.InventoryView;
//import presentation.inventory.InventoryViewState;
//
//public class HandleOrderFeedbackFixture extends Fixture {
//    private InventoryView inventoryView;
//    private InventoryController inventoryController;
//    private InventoryViewState inventoryViewState;
//    private OrderEntity currentOrder;
//    private boolean isValid;
//
//    public void setInventoryView(InventoryView inventoryView) {
//        this.inventoryView = inventoryView;
//    }
//
//    public void setInventoryController(InventoryController inventoryController) {
//        this.inventoryController = inventoryController;
//    }
//
//    public void setInventoryViewState(InventoryViewState inventoryViewState) {
//        this.inventoryViewState = inventoryViewState;
//    }
//
//    public void setOrder(OrderEntity order) {
//        this.currentOrder = order;
//    }
//
//    public void setIsValid(boolean isValid) {
//        this.isValid = isValid;
//    }
//
//    public boolean handleOrderFeedback() {
//        return presentation.orderControl.handleOrderFeedback(currentOrder, isValid, inventoryView, inventoryController, inventoryViewState);
//    }
//}
