import java.util.HashMap;
public class Laptop extends Products{

    public static HashMap<Integer, Laptop> laptops = new HashMap<>();
    public Laptop(int productID, int price, int discountRate, int stock, String productName, Brands brand, int storage, double screenSize, int ram) {
        super(productID, price, discountRate, stock, productName, brand, storage, screenSize, ram);

        laptops.put(this.getProductID(),this);
    }


}
