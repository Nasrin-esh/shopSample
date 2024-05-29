package Products;
import UserAccounts.*;

public class Wearing extends Product
{
    private String producerCountry;
    private String material;
    //----------------------------------------------
    Wearing(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
            String producerCountry, String material)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setProducerCountry(producerCountry);
        setMaterial(material);
    }
    //-----------------------------------------------------
    public String getProducerCountry() {
        return producerCountry;
    }
    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    //--------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/made in:"+producerCountry+
                "/materila:"+material;
    }
}
