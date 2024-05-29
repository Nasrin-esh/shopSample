package Products;
import UserAccounts.*;

public class Mobile extends DigitalProduct
{
    private int numberOfSIM;
    private int cameraQuality;
    //-------------------------------------------------
    Mobile(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions,
           int numberOfSIM, int cameraQuality)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, memoryCapacity, RAMcapacity, operatingSystem, weight, dimensions);
        setNumberOfSIM(numberOfSIM);
        setCameraQuality(cameraQuality);
    }
    //-------------------------------------------------------
    public int getNumberOfSIM() {
        return numberOfSIM;
    }
    public void setNumberOfSIM(int numberOfSIM) {
        this.numberOfSIM = numberOfSIM;
    }

    public int getCameraQuality() {
        return cameraQuality;
    }
    public void setCameraQuality(int cameraQuality) {
        this.cameraQuality = cameraQuality;
    }
    //--------------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/number of SIM:"+numberOfSIM+
                "/camera quality:"+cameraQuality;
    }
}
