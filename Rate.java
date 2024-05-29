package Comment;
import Products.* ;

public class Rate
{
    private int rate;
    private Product product;
    //-------------------
    Rate( int rate, Product product)
    {
        setProduct(product);
        setRate(rate);
    }
    //--------------------
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
