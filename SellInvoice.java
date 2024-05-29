package Invoive;
import Products.* ;

import java.util.ArrayList;

public class SellInvoice
{
    private int invoiveId;
    private String sellDate;
    private double receivedMoney;
    private ArrayList<Product> soldProduct;
    private String customer;
    private boolean isSend;
    //------------------------------
    SellInvoice(int invoiveId, String sellDate, double receivedMoney, String customer, boolean isSend)
    {
        setInvoiveId(invoiveId);
        setSellDate(sellDate);
        setReceivedMoney(receivedMoney);
        setCustomer(customer);
        setIsSend(isSend);
        soldProduct = new ArrayList<>();
    }
//--------------------------------

    public int getInvoiveId() {
        return invoiveId;
    }
    public void setInvoiveId(int invoiveId) {
        this.invoiveId = invoiveId;
    }

    public String getSellDate() {
        return sellDate;
    }
    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public double getReceivedMoney() {
        return receivedMoney;
    }
    public void setReceivedMoney(double receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public ArrayList<Product> getSoldProduct() {
        return soldProduct;
    }
    public void setSoldProduct(Product product) {
        this.soldProduct.add(product) ;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public boolean isSend() {
        return isSend;
    }
    public void setIsSend(boolean send) {
        isSend = send;
    }
}
