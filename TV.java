package Products;
import UserAccounts.*;

public class TV extends HomeAppliances
{
    private String visionQuality;
    private int screenSize;
    //---------------------------
    TV(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
       String visionQuality, int screenSize)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setVisionQuality(visionQuality);
        setScreenSize(screenSize);
    }
    //-------------------------------
    public String getVisionQuality() {
        return visionQuality;
    }
    public void setVisionQuality(String visionQuality) {
        this.visionQuality = visionQuality;
    }

    public int getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/vision quality:"+visionQuality+
                "/screen size:"+screenSize;
    }
}
