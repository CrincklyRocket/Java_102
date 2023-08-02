import java.util.Scanner;

public class Store {
    Scanner inp = new Scanner(System.in);
    StoreManagement storeManagement = new StoreManagement();
    boolean isWork = true;
    public String operate = ("1 - Notebook İşlemleri\n"+
                             "2 - Cep Telefonu İşlemleri\n"+
                             "3 - Marka Listele\n"+
                             "0 - Çıkış Yap");
    public void run(){

        while(isWork){
            System.out.println("PatikaStore Ürün Yönetim Sistemi");
            System.out.println(operate);
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            int selection = inp.nextInt();
    
            switch (selection){
                case 0:
                    isWork = false;
                    break;

                case 1:
                    storeManagement.run();
                    break;
                case 2:
                    storeManagement.run();
                    break;

                case 3:
                    brandsToList();
                    break;
            }
        }
    }
    public void brandsToList()
    {
        for (Brands brand:Brands.ourBrands)
        {
            System.out.println("Marka adı: "+ brand.getBrandName()+"Marka Id'si: "+ brand.getBrandID());
            System.out.println("*----------------------*");
        }
    }

}
