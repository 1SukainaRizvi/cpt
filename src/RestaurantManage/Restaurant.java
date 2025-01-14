package RestaurantManage;

import java.util.ArrayList;

public class Restaurant {
    public static final String displayMenu = null;
    private ArrayList<Order> orders;
    private ArrayList<MenuItem> menu;

        public Restaurant() {
            this.orders = new ArrayList<>();
            this.menu = new ArrayList<>();
        }

        public void addMenuItem (MenuItem item) {
            // Logic to add a menu item
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
            return this.menu;
        }
    
        public void displayMenu() {
                    for (MenuItem item : this.menu) {
                System.out.println(item.getName() + " (" + item.getCategory() + "): $" + item.getPrice());
            }
        }
    }
