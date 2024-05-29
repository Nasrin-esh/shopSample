package Products;
import UserAccounts.*;

public class Refrigerator extends HomeAppliances
{
    private int capacity;
    private String kind;
    private boolean hasFreezer;
    //-------------------------------
    Refrigerator(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
                 int capacity, String kind, boolean hasFreezer)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setCapacity(capacity);
        setKind(kind);
        setHasFreezer(hasFreezer);
    }
//------------------------------------

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean HasFreezer() {
        return hasFreezer;
    }
    public void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/capacity:"+capacity+
                "/model:"+kind+
                "/freezer:"+hasFreezer;
    }
}
