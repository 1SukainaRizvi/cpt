package RestaurantManage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    public void testGetName() {
        // Arrange
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");

        // Act
        String name = item.getName();

        // Assert
        assertEquals("Burger", name);
    }

    @Test
    public void testGetPrice() {
        // Arrange
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");

        // Act
        double price = item.getPrice();

        // Assert
        assertEquals(9.99, price);
    }

    @Test
    public void testGetCategory() {
        // Arrange
        MenuItem item = new MenuItem("Burger", 9.99, "Main Course");

        // Act
        String category = item.getCategory();

        // Assert
        assertEquals("Main Course", category);
    }
}
