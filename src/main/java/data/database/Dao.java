package data.database;

import domain.model.OrderEntity;
import domain.model.RaportEntity;
import domain.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class Dao implements  IDao {
    private List<UserEntity> users = new ArrayList<>();
    private List<RaportEntity> raports = new ArrayList<>();
    private List<List<OrderEntity>> orders = new ArrayList<>();
    private List<List<OrderEntity>> badOrders = new ArrayList<>();

    @Override
    public List<UserEntity> getAllUsers() {
        return users;
    }

    @Override
    public List<RaportEntity> getAllRaports() {
        return raports;
    }

    @Override
    public List<List<OrderEntity>> getAllOrders() {
        return orders;
    }

    @Override
    public UserEntity getUserById(int id) {
        return users.stream()
//                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public RaportEntity getRaportById(int id) {
        return raports.stream()
//                .filter(raport -> raport.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<OrderEntity> getOrder() {
        if (orders.isEmpty()) {return null;}
        return orders.get(0);
    }

    @Override
    public void addUser(UserEntity user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {
//        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void updateUser(UserEntity user) {
//        deleteUser(user.getId());
        users.add(user);
    }

    @Override
    public void addRaport(RaportEntity raport) {
        raports.add(raport);
    }

    @Override
    public void deleteRaport(int id) {
//        raports.removeIf(raport -> raport.getId() == id);
    }

    @Override
    public void updateRaport(RaportEntity raport) {
//        deleteRaport(raport.getId());
        raports.add(raport);
    }

    @Override
    public void addOrder(List<OrderEntity> order) {
        orders.add(order);
    }

    @Override
    public void deleteOrder() {
       orders.remove(0);
    }

    @Override
    public void addBadOrder(List<OrderEntity> orderList) {
        badOrders.add(orderList);
        orders.remove(0);
    }

    @Override
    public List<List<OrderEntity>> getBadOrders() {
        return badOrders;
    }

    @Override
    public void updateOrder(List<OrderEntity> order) {
        deleteOrder();
        orders.add(order);
    }

    @Override
    public OrderEntity getLocationByBarcode() {
        // Placeholder implementation
        return null;
    }
}