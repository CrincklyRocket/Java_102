public class Products {
    private final String productName;
    private final Brands brand;
    private final int ram;
    private final int productID;
    private final double price;
    private final double screenSize;
    private int discountRate;
    private final int stock;
    private final int storage;

    public Products(int productID, int price, int discountRate, int stock, String productName, Brands brand, int storage, double screenSize, int ram) {
        this.discountRate = discountRate;
        this.stock = stock;
        this.storage = storage;
        this.ram = ram;
        this.productID = productID;
        this.price = price;
        this.screenSize = screenSize;
        this.productName = productName;
        this.brand = brand;
    }

    public static void remove() {
    }

    public int getStock() {
        return stock;
    }
    public int getStorage() {
        return storage;
    }
    public int getRam() {
        return ram;
    }
    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }
    public double getScreenSize() {
        return screenSize;
    }
    public String getProductName() {
        return productName;
    }
    public Brands getBrand() {
        return brand;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}

