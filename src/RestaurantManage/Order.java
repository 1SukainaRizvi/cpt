package RestaurantManage;

import java.util.ArrayList;

public class Order {
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
