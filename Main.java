import java.util.ArrayList;
import java.util.Scanner;

// MenuItem class
class MenuItem {
    private String name;
    private double price;
    private String category;

    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

// Order class
class Order {
    private int orderID;
    private ArrayList<MenuItem> items;
    private double totalPrice;

    public Order(int orderID) {
        this.orderID = orderID;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public double calculateTotal() {
        totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

// Restaurant class
class Restaurant {
    private ArrayList<MenuItem> menu;
    private ArrayList<Order> orders;

    public Restaurant() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void viewOrders() {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderID());
            for (MenuItem item : order.getItems()) {
                System.out.println("- " + item.getName() + " (" + item.getCategory() + "): $" + item.getPrice());
            }
            System.out.println("Total: $" + order.calculateTotal());
            System.out.println();
        }
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void displayMenu() {
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " (" + item.getCategory() + "): $" + item.getPrice());
        }
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        int orderCounter = 1;

        // Adding some initial menu items
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

