import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class StoreManagement {
    Scanner inp = new Scanner(System.in);

   public void run() {
        boolean status = true;
        while (status) {
            System.out.println("""
                    Lütfen yapmak istediğiniz işlemi seçiniz:
                    1-Ürün ekleme
                    2-Ürün silme
                    3-Ürün listeleme
                    4-Filtreleme ile ürün listeleme
                    0-Çıkış yapma""");

            int choose = inp.nextInt();

            switch (choose) {
                case 1 -> addProduct();
                case 2 -> deleteProduct();
                case 3 -> listCellphoneProduct(Cellphones.cellphones);
                case 4 -> searchByFilter();
                case 0 -> status = false;
                default -> System.out.println("Lütfen geçerli bir işlem giriniz..");
            }
        }
   }
    public void addProduct() {
        System.out.println("Eklemek istediğiniz ürün grubunu giriniz.");
        System.out.println(" Telefon için: 1");
        System.out.println("Notebook için: 2");


        int productType = inp.nextInt();
        inp.nextLine();

        if (productType==1){
            System.out.println("Telefon özelliklerini sırasıyla giriniz.");

            System.out.println("Ürün Adı:");
            String productName = inp.nextLine();
            System.out.println("Ürün Fiyatı: ");
            int price = inp.nextInt();
            inp.nextLine();

            System.out.println("Seçeceğiniz markayı yazınız. ");
            System.out.println("-----------------------------------------");

            listBrands();

            String brand = inp.nextLine();
            String firstLatter;
            firstLatter = brand.substring(0,1).toUpperCase();

            brand = firstLatter+brand.substring(1);

            while (!Brands.ourBrands.contains(new Brands(brand))){

                System.out.println("Geçersiz marka ismi. Lütfen tekrar deneyiniz.");
                brand = inp.nextLine();
                firstLatter = brand.substring(0,1).toUpperCase();

                brand = firstLatter+brand.substring(1);


            }
        }
        Brands ourBrand = null;
        boolean status = true;

        while (status) {
            for (Brands brand : Brands.ourBrands) {
                System.out.println(brand.getBrandName() );

            }
            System.out.print("Lütfen (sistemde kayıtlı ürünlerden) ürünün markasını giriniz: ");
            String brandOfProduct = inp.nextLine();
            for (Brands brand : Brands.ourBrands) {
                if (brand.getBrandName().equals(brandOfProduct)) {
                    ourBrand = brand;
                   status = false;
                }
            }
        }
   }

    public void listCellphoneProduct(HashMap<Integer, Cellphones> ourProductList) {
        String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Fiyat                  | Marka | Depolama      |  Ekran Boyutu     | RAM Kapasitesi   |Batarya        |    Renk           | Stok             | İndirim Oranı          |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
        for (Map.Entry<Integer, Cellphones> cellphone : ourProductList.entrySet()) {
            System.out.format(format, cellphone.getValue().getProductID(), cellphone.getValue().getProductName(), cellphone.getValue().getPrice(), cellphone.getValue().getBrand().getBrandName(), cellphone.getValue().getStorage(), cellphone.getValue().getScreenSize(), cellphone.getValue().getRam(), cellphone.getValue().getBattery(), cellphone.getValue().getColor(), cellphone.getValue().getStock(), cellphone.getValue().getDiscountRate());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
        }
    }
    public  void listBrands(){
        System.out.println("Markalarımız");
        System.out.println("-----------------------------------");
        for (Brands b:Brands.ourBrands){
            System.out.println(b.getBrandName());
        }
    }
    public void deleteProduct() {
        System.out.print("Lütfen silmek istediğiniz ürünün id'sini giriniz ");
        int id = inp.nextInt();

        if (Laptop.laptops.containsKey(id) || Cellphones.cellphones.containsKey(id)) {
            System.out.println("Bu id değerine sahip ürün yoktur..");
        } else {
            System.out.println(id + " ID numaralı ürün silinmiştir..");
            Products.remove();
        }
    }



    public void searchByFilter() {
        System.out.println("Filtrele: "); inp.nextLine();
        String filter=inp.nextLine();

        if (filter.matches("\\d+"))
        {
            int  ourFilter=Integer.parseInt(filter);
            if (Laptop.laptops.containsKey(ourFilter))
            {
                Products product=Laptop.laptops.get(ourFilter);
                String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                System.out.format("| ID       | Ürün Adı                       | Fiyat                  | Marka | Depolama      |  Ekran Boyutu     | RAM Kapasitesi   |Batarya        |    Renk           | Stok             | İndirim Oranı          |\n");
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
               // System.out.format(format, product.getProductID(), product.getProductName(), product.getPrice(), product.getBrand().getBrandName(), product.getStorage(), product.getScreenSize(), product.getRam(), product.getBattery(), product.getColor(), product.getStock(), product.getDiscountRate());
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
            } else {
                System.out.println("Bu id numarasına sahip ürün bulunamadı");
            }

        }

    }
}
