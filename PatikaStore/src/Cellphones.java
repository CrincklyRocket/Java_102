import java.util.HashMap;
public class Cellphones extends Products {
    private String color;
    private final int battery;
    public static HashMap<Integer, Cellphones> cellphones = new HashMap<>();
    public Cellphones(int productID, int price, int discountRate, int stock, String productName, Brands brand, int storage, double screenSize, int battery, int ram, String color) {
        super(productID, price, discountRate, stock, productName, brand, storage, screenSize, ram);
        this.color = color;
        this.battery = battery;

        cellphones.put(this.getProductID(),this);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;

    }
}