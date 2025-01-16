package RestaurantManage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order(1);
    }

    @Test
    void testAddItem() {
        MenuItem item = new MenuItem("Coffee", 2.50, "Beverage");
        // Act
        order.addItem(item);
        // Arrange
        assertTrue(order.getItems().contains(item));
    }

    @Test
    void testRemoveItem() {
        MenuItem item = new MenuItem("Coffee", 2.50, "Beverage");
        order.addItem(item);
        order.removeItem(item);
        assertFalse(order.getItems().contains(item));
    }

    @Test
    void testCalculateTotal() {
        order.addItem(new MenuItem("Coffee", 2.50, "Beverage"));
        order.addItem(new MenuItem("Burger", 5.00, "Main Course"));
        assertEquals(7.50, order.calculateTotal());
    }

    @Test
    void testGetItems() {
        MenuItem item = new MenuItem("Coffee", 2.50, "Beverage");
        order.addItem(item);
        assertEquals(1, order.getItems().size());
        assertEquals(item, order.getItems().get(0));
    }

    @Test
    void testGetOrderID() {
        assertEquals(1, order.getOrderID());
    }

    @Test
    void testGetTotalPrice() {
        order.addItem(new MenuItem("Coffee", 2.50, "Beverage"));
        order.calculateTotal();
        assertEquals(2.50, order.getTotalPrice());
    }
}

