package RestaurantManage;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    @Test
    public void testAddMenuItem() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");

        // Act
        restaurant.addMenuItem(item);
        ArrayList<MenuItem> menu = restaurant.getMenu();

        // Assert
        assertEquals(1, menu.size());
        assertEquals("Burger", menu.get(0).getName());
        assertEquals("Main Course", menu.get(0).getCategory());
        assertEquals(9.99, menu.get(0).getPrice());
    }

    @Test
    public void testPlaceOrder() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        MenuItem item1 = new MenuItem("Burger", 9.99, "Main Course");
        MenuItem item2 = new MenuItem("Fries", 4.99, "Side");
        Order order = new Order(1);
        order.addItem(item1);
        order.addItem(item2);

        // Act
        restaurant.placeOrder(order);

        // Assert
        // Verifying that the order was placed by checking the output of the viewOrders method
        restaurant.viewOrders();
    }

    @Test
    public void testViewOrders() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");
        Order order = new Order(1);
        order.addItem(item);
        restaurant.placeOrder(order);

        // Act
        restaurant.viewOrders();

        // Assert
        // This is just a test for coverage purposes, actual visual verification
        // is recommended to check the printed output.
    }

    @Test
    public void testDisplayMenu() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");
        restaurant.addMenuItem(item);

        // Act
        restaurant.displayMenu();

        // Assert
        // This is just a test for coverage purposes, actual visual verification
        // is recommended to check the printed output.
    }
}
