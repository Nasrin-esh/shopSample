package UserAccounts;
import Products.*;

public class EditRequest
{
    Product product;
    String field;
    String previousAmount;
    String newAmount;

    EditRequest(Product product, String field, String previousField, String newAmount)
    {
        this.product = product;
        this.field = field;
        this.previousAmount = previousField;
        this.newAmount = newAmount;
    }

    @Override
    public String toString()
    {
        return "field to edit" + field +
                "/previous amount of this field" + previousAmount +
                "/new amount of this field" + newAmount ;
    }

}
