package Products;
import UserAccounts.*;

public class Cooker extends HomeAppliances
{
    private int numberOfIngle;
    private String material;
    private boolean hasOven;
    //---------------------------------
    Cooker(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
           int numberOfIngle, String material, boolean hasOven)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setNumberOfIngle(numberOfIngle);
        setMaterial(material);
        setHasOven(hasOven);
    }
    //--------------------------------
    public int getNumberOfIngle() {
        return numberOfIngle;
    }
    public void setNumberOfIngle(int numberOfIngle) {
        this.numberOfIngle = numberOfIngle;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isHasOven() {
        return hasOven;
    }
    public void setHasOven(boolean hasOven) {
        this.hasOven = hasOven;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/numberOfIngle:"+numberOfIngle+
                "/material:"+material+
                "/oven:"+hasOven;
    }
}
