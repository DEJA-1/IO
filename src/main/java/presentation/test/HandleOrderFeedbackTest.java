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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static presentation.orderControl.handleOrderFeedback;

public class HandleOrderFeedbackTest {
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
    public void orderIsNullTest(){
        assertFalse(handleOrderFeedback(null, true, inventoryView, inventoryController, inventoryViewState));
    }

    @Test
    public void orderIsNotValidTest(){
        assertFalse(handleOrderFeedback(currentOrder, false, inventoryView, inventoryController, inventoryViewState));
        verify(inventoryView).displayError("Ilość towarów nie zgadza się.");
    }

    @Test
    public void orderIsValidButNotSuccededTest(){
        when(inventoryViewState.getOrderSucceeded()).thenReturn(false);

        assertFalse(handleOrderFeedback(currentOrder, true, inventoryView, inventoryController, inventoryViewState));
        verify(inventoryView).displayError("Nie udalo sie wysłac towaru.");
    }

    @Test
    public void orderIsValidAndSuccededTest(){
        when(inventoryViewState.getOrderSucceeded()).thenReturn(true);

        assertTrue(handleOrderFeedback(currentOrder, true, inventoryView, inventoryController, inventoryViewState));
        verify(inventoryView).displaySuccess("Zamowienie zostalo wyslane");
    }
}
