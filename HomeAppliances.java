package Products;
import UserAccounts.*;

public class HomeAppliances extends Product
{
    private String energyConsumption;
    private boolean isGuaranteed;
    //-------------------------
    HomeAppliances(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
                   String energyConsumption, boolean isGuaranteed)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setEnergyConsumption(energyConsumption);
        setGuaranteed(isGuaranteed);
    }
    //-----------------------------
    public String getEnergyConsumption() {
        return energyConsumption;
    }
    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public boolean isGuaranteed() {
        return isGuaranteed;
    }
    public void setGuaranteed(boolean guaranteed) {
        isGuaranteed = guaranteed;
    }
    //----------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/energy consumption:"+energyConsumption+
                "/guaranteed:"+isGuaranteed;
    }
}
