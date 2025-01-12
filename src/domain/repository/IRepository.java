package domain.repository;

import domain.model.OrderEntity;
import domain.model.RaportEntity;
import domain.model.UserEntity;

import java.util.List;

public interface IRepository {
    UserEntity getLoggedUser();
    List<UserEntity> getAllUsers();
    List<RaportEntity> getAllRaports();
    List<OrderEntity> getAllOrders();
    UserEntity getUserById(int id);
    RaportEntity getRaportById(int id);
    OrderEntity getOrderById(int id);
    void addUser(UserEntity user);
    void deleteUser(int id);
    void updateUser(UserEntity user);
    void addRaport(RaportEntity raport);
    void deleteRaport(int id);
    void updateRaport(RaportEntity raport);
    void addOrder(OrderEntity order);
    void deleteOrder(int id);
    void updateOrder(OrderEntity order);
    OrderEntity getLocationByBarcode();
}
