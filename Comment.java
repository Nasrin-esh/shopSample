package Comment;
import UserAccounts.* ;
import Products.* ;

public class Comment
{
    private Customer customerWhoCommenting;
    private Product productWhichCommented;
    private String commentText;
    enum EN
    {
        WAITING,CONFIRMED,NOTCONFIRMED;
    }
    private EN isComfirmed;
    private boolean hasBought;
    //----------------------------------------
    Comment(Customer customer, Product product, String commentText, boolean hasBought)
    {
        setCustomerWhoCommenting(customer);
        setProductWhichCommented(product);
        setCommentText(commentText);
        setHasBought(hasBought);
    }
    //---------------------------------
    public Customer getCustomerWhoCommenting() {
        return customerWhoCommenting;
    }
    public void setCustomerWhoCommenting(Customer customerWhoCommenting) {
        this.customerWhoCommenting = customerWhoCommenting;
    }

    public Product getProductWhichCommented() {
        return productWhichCommented;
    }
    public void setProductWhichCommented(Product productWhichCommented) {
        this.productWhichCommented = productWhichCommented;
    }

    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public EN getIsComfirmed() {
        return isComfirmed;
    }
    public void setIsComfirmed(EN isComfirmed) {
        this.isComfirmed = isComfirmed;
    }

    public boolean isHasBought() {
        return hasBought;
    }
    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }
    //----------------------------------------
    @Override
    public String toString()
    {
        return "/customerWhoCommenting:"+this.customerWhoCommenting.toString()+
                "/product:"+productWhichCommented.toString()+
                "/comment text:" + commentText+
                "/has customer bought the product?" + hasBought;
    }
}
