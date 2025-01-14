package data.repository;

import data.database.IDao;
import domain.model.OrderEntity;
import domain.model.RaportEntity;
import domain.model.UserEntity;
import domain.repository.IRepository;

import java.util.List;

public class Repository implements IRepository {
    private IDao dao;

    public Repository(IDao dao) {
        this.dao = dao;
    }

    @Override
    public UserEntity getLoggedUser() {
        return dao.getAllUsers().stream()
//                .filter(UserEntity::isLoggedIn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public List<RaportEntity> getAllRaports() {
        return dao.getAllRaports();
    }

    @Override
    public List<List<OrderEntity>> getAllOrders() {
        return dao.getAllOrders();
    }

    @Override
    public UserEntity getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public RaportEntity getRaportById(int id) {
        return dao.getRaportById(id);
    }

    @Override
    public List<OrderEntity> getOrderById(int id) { return dao.getOrder();}

    @Override
    public void addUser(UserEntity user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public void updateUser(UserEntity user) {
        dao.updateUser(user);
    }

    @Override
    public void addRaport(RaportEntity raport) {
        dao.addRaport(raport);
    }

    @Override
    public void deleteRaport(int id) {
        dao.deleteRaport(id);
    }

    @Override
    public void updateRaport(RaportEntity raport) {
        dao.updateRaport(raport);
    }

    @Override
    public void addOrder(List<OrderEntity> order) {
        dao.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        dao.deleteOrder();
    }

    @Override
    public void updateOrder(List<OrderEntity> order) {
        dao.updateOrder(order);
    }

    @Override
    public OrderEntity getLocationByBarcode() {
        return dao.getLocationByBarcode();
    }
}