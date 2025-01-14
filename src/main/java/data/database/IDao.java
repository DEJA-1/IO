package data.database;

import domain.model.OrderEntity;
import domain.model.RaportEntity;
import domain.model.UserEntity;

import java.util.List;

public interface IDao {
    List<UserEntity> getAllUsers();
    List<RaportEntity> getAllRaports();
    List<List<OrderEntity>> getAllOrders();
    UserEntity getUserById(int id);
    RaportEntity getRaportById(int id);
    List<OrderEntity> getOrder();
    void addUser(UserEntity user);
    void deleteUser(int id);
    void updateUser(UserEntity user);
    void addRaport(RaportEntity raport);
    void deleteRaport(int id);
    void updateRaport(RaportEntity raport);
    void addOrder(List<OrderEntity> order);
    void deleteOrder();

    void addBadOrder(List<OrderEntity> orderList);

    List<List<OrderEntity>> getBadOrders();

    void updateOrder(List<OrderEntity> order);
    OrderEntity getLocationByBarcode();
}
