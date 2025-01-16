package RestaurantManage;

/**
 * author: Sukaina Rizvi
 * 01/16/2025
 * Restaurant Mangement System
 */

import java.util.Scanner;

public class RestaurantManage {
    /** 
     * The main method to run the restaurant management system. 
     * @param args the command line arguments */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        int orderCounter = 1;

        // Important menu items
        /**
         * Adds initial menu items to the restaurant
         */
        restaurant.addMenuItem(new MenuItem("Coffee", 2.50, "Beverage"));
        restaurant.addMenuItem(new MenuItem("Burger", 5.00, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Salad", 3.50, "Appetizer"));

        /**
         * Provides a loop for users to interact with. Such as view menu, place order, view orders, customize menu.
         */
        while (true) {
            System.out.println("Welcome to the Restaurant! Please choose an action:");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Customize Menu");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Displays the menu to the user
                    restaurant.displayMenu();
                    break;
                case 2:
                    // Allows users to place an order
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

                        if (!menuItem.equals(null)) {
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
                    // Allows users to customize the menu by adding or removing items
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
                    // Closes scanner
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}