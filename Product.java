package Products;
import UserAccounts.*;
import Comment.*;

import java.util.ArrayList;

public class Product
{
    static private int productId=0;
    private String productName;
    private String productCompany;
    private double price;
    private Seller seller;
    private int numberOfProduct=0;
    private String explain;
    private double averageRate=0;
    private ArrayList<Rate> rates;
    private ArrayList<Comment> comments;
    //----------------------------------------------
    Product(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain)
    {
        productId +=1;
        setProductName(productName);
        setProductCompany(productCompany);
        setPrice(price);
        setSeller(seller);
        setNumberOfProduct(numberOfProduct);
        setExplain(explain);
        comments = new ArrayList<>();
    }
    //---------------------------------------------
    @Override
    public String toString()
    {
        return "id:"+productId+
                "/name:"+productName+
                "/company:"+productCompany+
                "/price:"+price+
                "---->"+explain;
    }
    //--------------------------------------
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }
    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }
    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public String getExplain() {
        return explain;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }

    public double getAverageRate() {
        return averageRate;
    }
    public void setAverageRate()
    {
        this.averageRate = 0;
        for (int i=0 ; i<this.getRates().size() ; i++)
            this.averageRate += this.getRates().get(i).getRate();

        this.averageRate /= this.getRates().size();
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }
    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
    public void setComments(Comment comment) {
        this.comments.add(comment);
    }
}
