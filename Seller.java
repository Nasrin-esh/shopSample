package UserAccounts;
import Products.* ;
import java.util.ArrayList;

public class Seller extends UserAccount
{
    private String companyName;
    private double credit;
    private ArrayList<Invoive.SellInvoice> sellHistory;
    private ArrayList<Product> productsOnSale;
    //------------------------------------constructors---------------------------
    Seller(String userName, String firstName, String lastName, String email, int phoneNumber, String password, String role,
           String companyName, double credit)
    {
        super(userName, firstName, lastName, email, phoneNumber, password, "seller");
        setCompanyName(companyName);
        setCredit(credit);
        sellHistory = new ArrayList<>();
        productsOnSale = new ArrayList<>();
    }
    //----------------------------------setters & getter---------------------------
    @Override
    public String toString()
    {
        return super.toString() +
                "/companyname:" + companyName +
                "/credit:" + credit;
    }
    //-----------------------------------
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Invoive.SellInvoice> getSellHistory() {
        return sellHistory;
    }
    public void setSellHistory(Invoive.SellInvoice sellInvoive) {
        this.sellHistory.add(sellInvoive);
    }

    public ArrayList<Product> getProductsOnSale() {
        return productsOnSale;
    }
    public void setProductsOnSale(ArrayList<Product> productsOnSale) {
        this.productsOnSale = productsOnSale;
    }
}
