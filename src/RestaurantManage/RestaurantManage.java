package RestaurantManage;

import java.util.ArrayList;

public class RestaurantManage {
}

     class Order {
        private int orderID;
        private ArrayList<MenuItem> items;
        private double totalPrice;

        public Order(int orderID) {
            this.orderID = orderID;
            this.items = new ArrayList<>();
        }

        public void removeItem(MenuItem item) {
            items.add(item);
        }

        public double calculateTotal() {
            totalPrice = 0;
            for (MenuItem item : items) {
                totalPrice += item.getPrice();
            }
            return totalPrice;
        }
    }

     class Restaurant {
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
                // Logic to desplay orders
            }
        }
    }

