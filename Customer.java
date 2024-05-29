package UserAccounts;
import Products.*;

import java.nio.Buffer;
import java.util.ArrayList;

public class Customer extends UserAccount
{
    private ArrayList<Product> cart;//سبد خرید
    private ArrayList<Invoive.BuyInvoice> buyHistory;//سابقه خرید
    private double credit;
    //----------------------
    Customer(String userName, String firstName, String lastName, String email, int phoneNumber, String password,String role,
             double credit)
    {
        super(userName, firstName, lastName, email, phoneNumber, password, "customer");
        setCredit(credit);
        cart =new ArrayList<>();
        buyHistory = new ArrayList<>();
    }

    //-------------------------
    @Override
    public String toString()
    {
        return super.toString() +
                "/credit:" + credit;
    }
    //------------------------
    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }
    public void setCart(Product product) {
        this.cart.add(product);
    }

    public ArrayList<Invoive.BuyInvoice> getBuyHistory() {
        return buyHistory;
    }
    public void setBuyHistory(Invoive.BuyInvoice buyInvoive) {
        this.buyHistory.add(buyInvoive) ;
    }
}
