package UserAccounts;

import java.util.ArrayList;

public class SellerManager
{
    private static ArrayList<Seller> sellers = new ArrayList<>();
    //-------------------------------
    public  static ArrayList<Seller> getSellers() {
        return sellers;
    }
    public static void setSellers(ArrayList<Seller> sellers) {
        sellers = sellers;
    }
    //----------------------------------
    static void registerSeller(Seller seller)
    {
        sellers.add(seller);
    }

}