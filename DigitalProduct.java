package Products;
import UserAccounts.*;

public class DigitalProduct extends Product
{
    private int memoryCapacity;
    private int RAMcapacity;
    private String operatingSystem;
    private double weight;
    private String dimensions;
    //--------------------------------------------------------------------
    DigitalProduct(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
                   int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setMemoryCapacity(memoryCapacity);
        setRAMcapacity(RAMcapacity);
        setOperatingSystem(operatingSystem);
        setWeight(weight);
        setDimensions(dimensions);
    }
    //-------------------------------------------------------------------------
    public int getMemoryCapacity() {
        return memoryCapacity;
    }
    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public int getRAMcapacity() {
        return RAMcapacity;
    }
    public void setRAMcapacity(int RAMcapacity) {
        this.RAMcapacity = RAMcapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    //---------------------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/memory:"+memoryCapacity+
                "/RAM:"+RAMcapacity+
                "/os:"+operatingSystem+
                "/weight:"+weight+
                "/dimension:"+dimensions;
    }
}
