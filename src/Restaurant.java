package RestaurantManage;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Order> orders;

        public Restaurant() {
            this.orders = new ArrayList<>();
        }

        public void addMenuItem (MenuItem item) {
            // Logic to add a menu item
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
