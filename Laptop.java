package Products;
import UserAccounts.*;

public class Laptop extends DigitalProduct
{
    private String CPUmodel;
    private boolean isGaming;
    //----------------------------------------------
    Laptop(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions,
           String CPUmodel, boolean isGaming)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, memoryCapacity, RAMcapacity, operatingSystem, weight, dimensions);
        setCPUmodel(CPUmodel);
        setGaming(isGaming);
    }
    //--------------------------------------------
    public String getCPUmodel() {
        return CPUmodel;
    }
    public void setCPUmodel(String CPUmodel) {
        this.CPUmodel = CPUmodel;
    }

    public boolean isGaming() {
        return isGaming;
    }
    public void setGaming(boolean gaming) {
        isGaming = gaming;
    }
    //---------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/CPU model:"+CPUmodel+
                "/gaming:"+isGaming;
    }
}
