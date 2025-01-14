package presentation.inventory;

import domain.model.OrderEntity;
import domain.model.UserEntity;

import java.util.List;

public class InventoryViewState {
    public UserEntity currentUser;
    public List<OrderEntity> currentOrder;

    private boolean orderSucceeded = false;

    public InventoryViewState(UserEntity currentUser, List<OrderEntity> currentOrder) {
        this.currentUser = currentUser;
        this.currentOrder = currentOrder;
    }

    public void setOrderSucceeded(boolean orderSucceeded) {
        this.orderSucceeded = orderSucceeded;
    }

    public boolean getOrderSucceeded()  {
        return this.orderSucceeded;
    }
}
