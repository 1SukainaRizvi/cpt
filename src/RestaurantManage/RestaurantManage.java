package RestaurantManage;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        int orderCounter = 1;

        // Important menu items
        restaurant.addMenuItem(new MenuItem("Coffee", 2.50, "Beverage"));
        restaurant.addMenuItem(new MenuItem("Burger", 5.00, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Salad", 3.50, "Appetizer"));

        while (true) {
            System.out.println("Welcome to the Restaurant! Please choose an action:");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Manage Inventory");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    restaurant.displayMenu();
                    break;
                case 2:
                    Order order = new Order(orderCounter++);
                    while (true) {
                        System.out.println("Enter the name of the item to add to the order (or type 'done' to finish):");
                        String itemName = scanner.nextLine();
                        if (itemName.equalsIgnoreCase("done")) {
                            break;
                        }

                        MenuItem menuItem = null;
                        for (MenuItem item : restaurant.getMenu()) {
                            if (item.getName().equalsIgnoreCase(itemName)) {
                                menuItem = item;
                                break;
                            }
                        }

                        if (menuItem != null) {
                            order.addItem(menuItem);
                            System.out.println(menuItem.getName() + " added to the order.");
                        } else {
                            System.out.println("Item not found in the menu.");
                        }
                    }
                    restaurant.placeOrder(order);
                    System.out.println("Order placed successfully.");
                    break;
                case 3:
                    restaurant.viewOrders();
                    break;
                case 4:
                    System.out.println("1. Add Menu Item");
                    System.out.println("2. Remove Menu Item");
                    int manageChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (manageChoice == 1) {
                        System.out.println("Enter item name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter item price:");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter item category:");
                        String category = scanner.nextLine();
                        restaurant.addMenuItem(new MenuItem(name, price, category));
                        System.out.println("Item added to the menu.");
                    } else if (manageChoice == 2) {
                        System.out.println("Enter the name of the item to remove:");
                        String name = scanner.nextLine();
                        MenuItem menuItemToRemove = null;
                        for (MenuItem item : restaurant.getMenu()) {
                            if (item.getName().equalsIgnoreCase(name)) {
                                menuItemToRemove = item;
                                break;
                            }
                        }
                        if (menuItemToRemove != null) {
                            restaurant.getMenu().remove(menuItemToRemove);
                            System.out.println("Item removed from the menu.");
                        } else {
                            System.out.println("Item not found in the menu.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Restaurant System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
   