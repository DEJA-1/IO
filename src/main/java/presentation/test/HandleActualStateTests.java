package presentation.test;

import data.database.IDao;
import data.repository.Repository;
import domain.controllers.InventoryController;
import domain.model.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presentation.inventory.InventoryView;
import presentation.inventory.InventoryViewState;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static presentation.orderControl.handleActualState;

public class HandleActualStateTests {
    IDao dao;
    Repository repository;
    InventoryView inventoryView;
    Scanner scanner;
    OrderEntity currentOrder;
    InventoryViewState inventoryViewState;
    InventoryController inventoryController;

    @BeforeEach
    public void setup() {
        dao = mock(IDao.class);
        repository = mock(Repository.class);
        inventoryView = mock(InventoryView.class);
        scanner = mock(Scanner.class);
        currentOrder = mock(OrderEntity.class);
        inventoryViewState = mock(InventoryViewState.class);
        inventoryController = mock(InventoryController.class);
    }

    @Test
    public void testOrderIsNull() {
        assertFalse(handleActualState(inventoryView, scanner, null));
    }

    @Test
    public void testAmountIsTooSmall() {
        when(scanner.nextLine()).thenReturn("20");
        currentOrder.count = 21;
        assertFalse(handleActualState(inventoryView, scanner, currentOrder));

        when(scanner.nextLine()).thenReturn("2");
        currentOrder.count = 3;
        assertFalse(handleActualState(inventoryView, scanner, currentOrder));

        when(scanner.nextLine()).thenReturn("21");
        currentOrder.count = 22143;
        assertFalse(handleActualState(inventoryView, scanner, currentOrder));
    }

    @Test
    public void testAmountIsNegative() {
        when(scanner.nextLine()).thenReturn("-100");
        currentOrder.count = -01;

        when(scanner.nextLine()).thenReturn("0");
        currentOrder.count = -1;

        when(scanner.nextLine()).thenReturn("-201");
        currentOrder.count = -100;
    }
}
