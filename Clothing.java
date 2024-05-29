package Products;
import UserAccounts.* ;

public class Clothing extends Wearing
{
    private String size;
    enum EN
    {
        TSHIRT,PANTS,SWEATSHIRT,BLAZER;
    }
    private EN kindsOfClothes;
    //-----------------------------------
    Clothing(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String producerCountry, String material,
             String size, EN kindsOfClothes)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, producerCountry, material);
        setSize(size);
        setKindsOfClothes(kindsOfClothes);
    }
    //------------------------------
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public EN getKindsOfClothes() {
        return kindsOfClothes;
    }
    public void setKindsOfClothes(EN kindsOfClothes) {
        this.kindsOfClothes = kindsOfClothes;
    }
    //---------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/size:"+size+
                "/type:"+kindsOfClothes;
    }
}
