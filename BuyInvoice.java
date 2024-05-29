package Invoive;
import Products.* ;

import java.util.ArrayList;

public class BuyInvoice
{
    private int invoiveId;
    private String buyDate;
    private double paidMoney;
    private ArrayList<Product> purchasedProducts;
    private String sellerName;
    private boolean isDelivered;
    //----------------------------------------------
    BuyInvoice(int invoiveId, String buyDate, double paidMoney, String sellerName, boolean isDelivered)
    {
        setInvoiveId(invoiveId);
        setBuyDate(buyDate);
        setPaidMoney(paidMoney);
        setSellerName(sellerName);
        setIsDelivered(isDelivered);
        purchasedProducts = new ArrayList<>();
    }
//----------------------------------------------

    public int getInvoiveId() {
        return invoiveId;
    }
    public void setInvoiveId(int invoiveId) {
        this.invoiveId = invoiveId;
    }

    public String getBuyDate() {
        return buyDate;
    }
    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public double getPaidMoney() {
        return paidMoney;
    }
    public void setPaidMoney(double paidMoney) {
        this.paidMoney = paidMoney;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
    public void setPurchasedProducts(Product product) {
        this.purchasedProducts.add(product) ;
    }

    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isDelivered() {
        return isDelivered;
    }
    public void setIsDelivered(boolean delivered) {
        isDelivered = delivered;
    }
    //-----------------------------------------------
    @Override
    public String toString()
    {
        return "invoive id:"+invoiveId+
                "/buy date:"+buyDate+
                "/paid money:"+paidMoney+
                "/seller:"+sellerName;
    }
}
