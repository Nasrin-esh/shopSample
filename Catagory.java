package Products;

import java.util.ArrayList;

public class Catagory
{
    private String name;
    private String specialProperty;
    static private ArrayList<Product> products = new ArrayList<>();
    //----------------------------------
    Catagory(String name, String specialProperty)
    {
        setName(name);
        setSpecialProperty(specialProperty);
    }
    //----------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialProperty() {
        return specialProperty;
    }
    public void setSpecialProperty(String specialProperty) {
        this.specialProperty = specialProperty;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
    public static void setProducts(ArrayList<Product> products) {
        Catagory.products = products;
    }
    //-------------------------------------
}
