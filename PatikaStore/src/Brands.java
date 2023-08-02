import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Brands {
    private final String brandName;
    private int brandID;
    private static int id = 1;
    public static List<Brands> ourBrands = new ArrayList<>();
    //Creating list of brands

    static //Setting default brands
    {
        ourBrands.add(new Brands("Samsung"));
        ourBrands.add(new Brands("Lenovo"));
        ourBrands.add(new Brands("Apple"));
        ourBrands.add(new Brands("Huawei"));
        ourBrands.add(new Brands("Casper"));
        ourBrands.add(new Brands("Asus"));
        ourBrands.add(new Brands("HP"));
        ourBrands.add(new Brands("Xiaomi"));
        ourBrands.add(new Brands("Monster"));
        ourBrands.sort(Comparator.comparing(Brands::getBrandName));
    }
    Brands(String brandName){
        this.brandName = brandName;
        setBrandID(id++);
    }//Constructor
    private void setBrandID(int id) {
        this.brandID = id;
    }
    public String getBrandName() {
        return brandName;
    }
    public int getBrandID() {
        return brandID;
    }

}
