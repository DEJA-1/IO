package data.database;

import domain.model.OrderEntity;
import domain.model.RaportEntity;
import domain.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class Dao implements  IDao {
    private List<UserEntity> users = new ArrayList<>();
    private List<RaportEntity> raports = new ArrayList<>();
    private List<OrderEntity> orders = new ArrayList<>();

    @Override
    public List<UserEntity> getAllUsers() {
        return users;
    }

    @Override
    public List<RaportEntity> getAllRaports() {
        return raports;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
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
    public OrderEntity getOrderById(int id) {
        return orders.stream()
//                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
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
    public void addOrder(OrderEntity order) {
        orders.add(order);
    }

    @Override
    public void deleteOrder(int id) {
//        orders.removeIf(order -> order.getId() == id);
    }

    @Override
    public void updateOrder(OrderEntity order) {
//        deleteOrder(order.getId());
        orders.add(order);
    }

    @Override
    public OrderEntity getLocationByBarcode() {
        // Placeholder implementation
        return null;
    }
}