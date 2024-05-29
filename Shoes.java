package Products;
import UserAccounts.*;

public class Shoes extends Wearing
{
    private int size;
    enum EN
    {
        BOOT,SPORT,FLAT,HIGHHEELS;
    }
    private EN kindsOfShoes;
    //-----------------------------
    Shoes(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String producerCountry, String material,
          int size, EN kindsOfShoes)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, producerCountry, material);
        setSize(size);
        setKindsOfShoes(kindsOfShoes);
    }
//-----------------------------

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;

    }

    public EN getKindsOfShoes() {
        return kindsOfShoes;
    }
    public void setKindsOfShoes(EN kindsOfShoes) {
        this.kindsOfShoes = kindsOfShoes;
    }
    //----------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/size:"+size+
                "/type:"+kindsOfShoes;
    }
}
