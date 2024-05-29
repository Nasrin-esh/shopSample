package Products;
import UserAccounts.*;

public class Food extends Product
{
    private String dateOfManufacture;
    private String expirationDate;
    //-------------------------------
    Food(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
         String dateOfManufacture, String expirationDate)
    {
        super(productName, productCompany, price, seller, numberOfProduct, explain);
        setDateOfManufacture(dateOfManufacture);
        setExpirationDate(expirationDate);
    }
    //----------------------------
    public String getDateOfManufacture() {
        return dateOfManufacture;
    }
    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/production date:"+dateOfManufacture+
                "/expiration date:"+expirationDate;
    }
}
