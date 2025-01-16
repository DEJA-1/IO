package presentation.test.local;

import data.database.IDao;
import data.repository.Repository;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static presentation.OrderControl.handleLocation;

@SpringBootTest
public class HandleLocationTest {
    IDao dao;
    Repository repository;
    InventoryView inventoryView;
    Scanner scanner;
    OrderEntity currentOrder;
    InventoryViewState inventoryViewState;
    InventoryController inventoryController;

    @BeforeEach
    public void setup() {
        dao = Mockito.mock(IDao.class);
        repository = Mockito.mock(Repository.class);
        inventoryView = Mockito.mock(InventoryView.class);
        scanner = Mockito.mock(Scanner.class);
        currentOrder = Mockito.mock(OrderEntity.class);
        inventoryViewState = Mockito.mock(InventoryViewState.class);
        inventoryController = Mockito.mock(InventoryController.class);
    }

    @Test
    public void orderIsNull(){
        Assertions.assertFalse(handleLocation(null, inventoryView, scanner));
    }

    @Test
    public void inventoryCountNotValid() {
        Mockito.when(scanner.nextLine()).thenReturn("4");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("133");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("111");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("11");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("10 01");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("p");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
    }
    @Test
    public void inventoryCountValid() {
        Mockito.when(scanner.nextLine()).thenReturn("1");
        Assertions.assertTrue(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("001");
        Assertions.assertTrue(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn("00001");
        Assertions.assertTrue(handleLocation(currentOrder, inventoryView, scanner));
        Mockito.when(scanner.nextLine()).thenReturn(" 1");
        Assertions.assertFalse(handleLocation(currentOrder, inventoryView, scanner));
    }
}