package RestaurantManage;

public class MenuItem {
    private String name;
    private double price;
    private String category; 

    public MenuItem (String name, String category, double price) {
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

    public String category() {
        return category;
    }
}