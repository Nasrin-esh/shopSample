import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlineShop {

    public static void main(String[] args) throws IOException {

        Files.createFolders();

        Interface menu =new Interface();
        menu.showMainMenu();
        System.out.println("GOOD LUCK");
    }
}

//----------------------------********  part a  *******-----------------------------
abstract class UserAccount
{
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;

    static String regex_email = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+[.]+com";
    static Pattern pattern_email = Pattern.compile(regex_email);

    static String regex_phoneNumber = "^([+][9][8][_])\\d{10}$";
    static Pattern pattern_phoneNumber = Pattern.compile(regex_phoneNumber);

    //---------------------------constructor-----------------
    UserAccount(String userName,String firstName,String lastName,String email,String phoneNumber,String password, String role) throws InvalidInput
    {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);

        Matcher matcher1 = pattern_email.matcher(email);
        if ( !matcher1.matches())
            throw new InvalidEmail();
        else
            setEmail(email);

        Matcher matcher2 = pattern_phoneNumber.matcher(phoneNumber);
        if ( !matcher2.matches())
            throw new InvalidPhoneNumber();
        else
            setPhoneNumber(phoneNumber);

        setPassword(password);
        setRole(role);

    }

    @Override
    public String toString()
    {
        return "username:"+userName+
                "/first name:"+firstName+
                "/last name:"+lastName+
                "/email:"+email+
                "/phone number:"+phoneNumber+
                "/password:"+password+
                "/role:"+role;
    }
    //------------------------setter & getter----------------------
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
class BuyInvoive
{
    private int invoiveId;
    private String buyDate;
    private double paidMoney;
    private ArrayList<Product> purchasedProducts;
    private String sellerName;
    private boolean isDelivered;
    //----------------------------------------------
    BuyInvoive(int invoiveId, String buyDate, double paidMoney, String sellerName, boolean isDelivered)
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
class SellInvoive
{
    private int invoiveId;
    private String sellDate;
    private double receivedMoney;
    private ArrayList<Product> soldProduct;
    private String customer;
    private boolean isSend;
    //------------------------------
    SellInvoive(int invoiveId, String sellDate, double receivedMoney, String customer, boolean isSend)
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
abstract class Category
{
    private String name;
    private String specialProperty;
    static private ArrayList<Product> products = new ArrayList<>();
    //----------------------------------
    Category(String name, String specialProperty)
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
        Category.products = products;
    }

    static void sort()
    {
        for (int i=0;i<products.size()-1;i++)
            for (int j=0;j<products.size()-1-i;j++)
                if(products.get(j).compareTo(products.get(j+1)) < 0)
                {
                    Product temp=(Product) products.get(j);
                    products.remove(j);
                    products.add(j+1,temp);
                }
    }
    //-------------------------------------
}
abstract class Product implements Comparable
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
    Product( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain)
    {
        productId +=1;
        setProductName(productName);
        setProductCompany(productCompany);
        setPrice(price);
        setSeller(seller);
        setNumberOfProduct(numberOfProduct);
        setExplain(explain);
        comments = new ArrayList<>();
        Category.getProducts().add(this);
        Category.sort();
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

    @Override
    public int compareTo(Object o) {
        Product product = (Product) o;

        if (this.getProductName().compareTo( product.getProductName()) > 0)
            return -1;
        else if (this.getProductName().compareTo( product.getProductName()) < 0)
            return 1;
        else
        {
            if (this.getAverageRate() < product.getAverageRate())
                return -1;
            else if (this.getAverageRate() > product.getAverageRate())
                return 1;
            else
            {
                if (this.getPrice() < product.getPrice())
                    return -1;
                else if (this.getPrice() > product.getPrice())
                    return 1;
                else
                {
                    if (this.numberOfProduct < product.numberOfProduct)
                        return -1;
                    else if (this.numberOfProduct > product.numberOfProduct)
                        return 1;
                    else
                        return 0;
                }
            }
        }
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
abstract class DigitalProduct extends Product
{
    private int memoryCapacity;
    private int RAMcapacity;
    private String operatingSystem;
    private double weight;
    private String dimensions;
    //--------------------------------------------------------------------
    DigitalProduct( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
                    int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setMemoryCapacity(memoryCapacity);
        setRAMcapacity(RAMcapacity);
        setOperatingSystem(operatingSystem);
        setWeight(weight);
        setDimensions(dimensions);
    }
    //-------------------------------------------------------------------------
    public int getMemoryCapacity() {
        return memoryCapacity;
    }
    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public int getRAMcapacity() {
        return RAMcapacity;
    }
    public void setRAMcapacity(int RAMcapacity) {
        this.RAMcapacity = RAMcapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    //---------------------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/memory:"+memoryCapacity+
                "/RAM:"+RAMcapacity+
                "/os:"+operatingSystem+
                "/weight:"+weight+
                "/dimension:"+dimensions;
    }
}
class Mobile extends DigitalProduct
{
    private int numberOfSIM;
    private int cameraQuality;
    //-------------------------------------------------
    Mobile( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions,
            int numberOfSIM,int cameraQuality)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, memoryCapacity, RAMcapacity, operatingSystem, weight, dimensions);
        setNumberOfSIM(numberOfSIM);
        setCameraQuality(cameraQuality);
    }
    //-------------------------------------------------------
    public int getNumberOfSIM() {
        return numberOfSIM;
    }
    public void setNumberOfSIM(int numberOfSIM) {
        this.numberOfSIM = numberOfSIM;
    }

    public int getCameraQuality() {
        return cameraQuality;
    }
    public void setCameraQuality(int cameraQuality) {
        this.cameraQuality = cameraQuality;
    }
    //--------------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/number of SIM:"+numberOfSIM+
                "/camera quality:"+cameraQuality;
    }
}
class Laptop extends DigitalProduct
{
    private String CPUmodel;
    private boolean isGaming;
    //----------------------------------------------
    Laptop( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, int memoryCapacity, int RAMcapacity, String operatingSystem, double weight, String dimensions,
            String CPUmodel, boolean isGaming)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, memoryCapacity, RAMcapacity, operatingSystem, weight, dimensions);
        setCPUmodel(CPUmodel);
        setGaming(isGaming);
    }
    //--------------------------------------------
    public String getCPUmodel() {
        return CPUmodel;
    }
    public void setCPUmodel(String CPUmodel) {
        this.CPUmodel = CPUmodel;
    }

    public boolean isGaming() {
        return isGaming;
    }
    public void setGaming(boolean gaming) {
        isGaming = gaming;
    }
    //---------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/CPU model:"+CPUmodel+
                "/gaming:"+isGaming;
    }
}
abstract class Wearing extends Product
{
    private String producerCountry;
    private String material;
    //----------------------------------------------
    Wearing( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
             String producerCountry,String material)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setProducerCountry(producerCountry);
        setMaterial(material);
    }
    //-----------------------------------------------------
    public String getProducerCountry() {
        return producerCountry;
    }
    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    //--------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/made in:"+producerCountry+
                "/materila:"+material;
    }
}
class Clothing extends Wearing
{
    private String size;
    enum EN
    {
        TSHIRT,PANTS,SWEATSHIRT,BLAZER;
    }
    private EN kindsOfClothes;
    //-----------------------------------
    Clothing( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String producerCountry, String material,
              String size,EN kindsOfClothes)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, producerCountry, material);
        setSize(size);
        setKindsOfClothes(kindsOfClothes);
    }
    //------------------------------
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public EN getKindsOfClothes() {
        return kindsOfClothes;
    }
    public void setKindsOfClothes(EN kindsOfClothes) {
        this.kindsOfClothes = kindsOfClothes;
    }
    //---------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/size:"+size+
                "/type:"+kindsOfClothes;
    }
}
class Shoes extends Wearing
{
    private int size;
    enum EN
    {
        BOOT,SPORT,FLAT,HIGHHEELS;
    }
    private EN kindsOfShoes;
    //-----------------------------
    Shoes( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String producerCountry, String material,
           int size,EN kindsOfShoes)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, producerCountry, material);
        setSize(size);
        setKindsOfShoes(kindsOfShoes);
    }
//-----------------------------

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;

    }

    public EN getKindsOfShoes() {
        return kindsOfShoes;
    }
    public void setKindsOfShoes(EN kindsOfShoes) {
        this.kindsOfShoes = kindsOfShoes;
    }
    //----------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/size:"+size+
                "/type:"+kindsOfShoes;
    }
}
abstract class HomeAppliances extends Product
{
    private String energyConsumption;
    private boolean isGuaranteed;
    //-------------------------
    HomeAppliances(String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
                   String energyConsumption,boolean isGuaranteed)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain);
        setEnergyConsumption(energyConsumption);
        setGuaranteed(isGuaranteed);
    }
    //-----------------------------
    public String getEnergyConsumption() {
        return energyConsumption;
    }
    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public boolean isGuaranteed() {
        return isGuaranteed;
    }
    public void setGuaranteed(boolean guaranteed) {
        isGuaranteed = guaranteed;
    }
    //----------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/energy consumption:"+energyConsumption+
                "/guaranteed:"+isGuaranteed;
    }
}
class TV extends HomeAppliances
{
    private String visionQuality;
    private int screenSize;
    //---------------------------
    TV( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
        String visionQuality, int screenSize)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setVisionQuality(visionQuality);
        setScreenSize(screenSize);
    }
    //-------------------------------
    public String getVisionQuality() {
        return visionQuality;
    }
    public void setVisionQuality(String visionQuality) {
        this.visionQuality = visionQuality;
    }

    public int getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/vision quality:"+visionQuality+
                "/screen size:"+screenSize;
    }
}
class Refrigerator extends HomeAppliances
{
    private int capacity;
    private String kind;
    private boolean hasFreezer;
    //-------------------------------
    Refrigerator( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
                  int capacity, String kind, boolean hasFreezer)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setCapacity(capacity);
        setKind(kind);
        setHasFreezer(hasFreezer);
    }
//------------------------------------

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean HasFreezer() {
        return hasFreezer;
    }
    public void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/capacity:"+capacity+
                "/model:"+kind+
                "/freezer:"+hasFreezer;
    }
}
class Cooker extends HomeAppliances
{
    private int numberOfIngle;
    private String material;
    private boolean hasOven;
    //---------------------------------
    Cooker( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain, String energyConsumption, boolean isGuaranteed,
            int numberOfIngle, String material, boolean hasOven)
    {
        super( productName, productCompany, price, seller, numberOfProduct, explain, energyConsumption, isGuaranteed);
        setNumberOfIngle(numberOfIngle);
        setMaterial(material);
        setHasOven(hasOven);
    }
    //--------------------------------
    public int getNumberOfIngle() {
        return numberOfIngle;
    }
    public void setNumberOfIngle(int numberOfIngle) {
        this.numberOfIngle = numberOfIngle;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isHasOven() {
        return hasOven;
    }
    public void setHasOven(boolean hasOven) {
        this.hasOven = hasOven;
    }
    //------------------------------------
    @Override
    public String toString()
    {
        return super.toString()+
                "/numberOfIngle:"+numberOfIngle+
                "/material:"+material+
                "/oven:"+hasOven;
    }
}
class Food extends Product
{
    private String dateOfManufacture;
    private String expirationDate;
    //-------------------------------
    Food( String productName, String productCompany, double price, Seller seller, int numberOfProduct, String explain,
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
class Comment
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
    Comment(Customer customer,Product product,String commentText,boolean hasBought)
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
class Rate
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
//-----------------------------********  part b *******----------------------------------
class Customer extends UserAccount
{
    private double credit;
    private ArrayList<Product> cart;//سبد خرید
    private ArrayList<BuyInvoive> buyHistory;//سابقه خرید
    //-------------------------
    @Override
    public String toString()
    {
        return super.toString() +
                "/credit:" + credit;
    }
    //----------------------
    Customer(String userName, String firstName, String lastName, String email, String phoneNumber, String password,String role,
             double credit) throws InvalidInput {
        super(userName, firstName, lastName, email, phoneNumber, password, "customer");
        setCredit(credit);
        cart =new ArrayList<>();
        buyHistory = new ArrayList<>();
    }
    //-------------------------------
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

    public ArrayList<BuyInvoive> getBuyHistory() {
        return buyHistory;
    }
    public void setBuyHistory(BuyInvoive buyInvoive) {
        this.buyHistory.add(buyInvoive) ;
    }
    //----------------------------------------------
    void changePersonalInf(String field,String newfield) throws InvalidInput {
        if (field.equals("firstName"))
            setFirstName(newfield);

        else if (field.equals("lastName"))
            setLastName(newfield);

        else if (field.equals("email"))
        {
            Matcher matcher1 = pattern_email.matcher(newfield);
            if ( !matcher1.matches())
                throw new InvalidEmail();
            else
                setEmail(newfield);
        }


        else if (field.equals("phoneNumber"))
        {
            Matcher matcher2 = pattern_phoneNumber.matcher(newfield);
            if ( !matcher2.matches())
                throw new InvalidPhoneNumber();
            else
                setPhoneNumber(newfield);
        }


        else if (field.equals("password"))
            setPassword(newfield);
    }

    void watchAllProducts()
    {
        for (Product p:Category.getProducts() )
        {
            boolean isAvailable;
            if (p.getNumberOfProduct()>0)
                isAvailable=true;
            else
                isAvailable=false;

            System.out.print("id :" + p.getProductId() + "name :" + p.getProductName() +"company :"+ p.getProductCompany());
            System.out.print("price : " + p.getPrice() +"seller :" + p.getSeller()+ "Availability" +isAvailable);
            System.out.println("explain :"+p.getExplain()+"average rate:"+ p.getAverageRate()) ;
        }
    }

    void buy(int productId, int numberYouBuy) throws InvalidShopping
    {
        for (int i = 0; i < Category.getProducts().size(); i++)
        {
            if (Category.getProducts().get(i).getProductId() == productId)
            {
                if (this.credit >= Category.getProducts().get(i).getPrice())
                {
                    if (numberYouBuy >= Category.getProducts().get(i).getNumberOfProduct())
                    {
                        setCart(Category.getProducts().get(i));//اضافه کردن محصول به سبد خرید
                        this.credit -= Category.getProducts().get(i).getPrice();//کم کردن قیمت کالا از اعتبار خریدار
                        Category.getProducts().get(i).getSeller().setCredit(Category.getProducts().get(i).getSeller().getCredit() + Category.getProducts().get(i).getPrice());//اضافه کردن قیمت کالا به اعتبار فروشنده
                        Category.getProducts().get(i).setNumberOfProduct(Category.getProducts().get(i).getProductId() - numberYouBuy);//کم کردن موجودی کالا
                    }

                    else
                        throw new LackOfInventory();
                }

                else
                    throw new LackOfMoney();
            }
        }
    }
}
class CustomerManager
{
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    //-------------------------------
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    public static void setCustomers(ArrayList<Customer> customers) {CustomerManager.customers = customers;}
    //----------------------------------
    static void registerCustomer(Customer customer)
    {
        customers.add(customer);
    }
}
class Seller extends UserAccount
{
    private String companyName;
    private double credit;
    private ArrayList<SellInvoive> sellHistory;
    private ArrayList<Product> productsOnSale;
    //------------------------------------constructors---------------------------
    Seller(String userName, String firstName, String lastName, String email, String phoneNumber, String password, String role,
           String companyName, double credit) throws InvalidInput {
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

    public ArrayList<SellInvoive> getSellHistory() {
        return sellHistory;
    }
    public void setSellHistory(SellInvoive sellInvoive) {
        this.sellHistory.add(sellInvoive);
    }

    public ArrayList<Product> getProductsOnSale() {
        return productsOnSale;
    }
    public void setProductsOnSale(ArrayList<Product> productsOnSale) {
        this.productsOnSale = productsOnSale;
    }
    //---------------------------------------------
    void changePersonalInf(String field,String newfield)throws InvalidInput
    {
        if (field.equals("firstName"))
            setFirstName(newfield);

        else if (field.equals("lastName"))
            setLastName(newfield);

        else if (field.equals("email"))
        {
            Matcher matcher1 = pattern_email.matcher(newfield);
            if ( !matcher1.matches())
                throw new InvalidEmail();
            else
                setEmail(newfield);
        }


        else if (field.equals("phoneNumber"))
        {
            Matcher matcher2 = pattern_phoneNumber.matcher(newfield);
            if ( !matcher2.matches())
                throw new InvalidPhoneNumber();
            else
                setPhoneNumber(newfield);
        }

        else if (field.equals("password"))
            setPassword(newfield);
    }

}
class SellerManager
{
    private static ArrayList<Seller> sellers = new ArrayList<>();
    //-------------------------------
    public  static ArrayList<Seller> getSellers() {
        return sellers;
    }
    public static void setSellers(ArrayList<Seller> sellers) {
        sellers = sellers;
    }
    //----------------------------------
    static void registerSeller(Seller seller)
    {
        sellers.add(seller);
    }
}
class Admin extends UserAccount
{
    private static Admin admin;
    private static ArrayList<Comment> commentRequests = new ArrayList<>();
    private static ArrayList<Seller> sellerRequests = new ArrayList<>();
    private static ArrayList<EditRequest> editRequests = new ArrayList<>();
    private static ArrayList<Product> addRequest = new ArrayList<>();
    private static ArrayList<Product> removeRequest = new ArrayList<>();
    //--------------------------------
    private Admin(String firstName, String lastName, String email, String phoneNumber) throws InvalidInput {
        super("admin", firstName, lastName, email, phoneNumber, "admin", "admin");
    }
    //------------------------------
    public static Admin getAdmin(String firstName, String lastName, String email, String phoneNumber) throws InvalidInput {
        if (admin == null)
            admin = new Admin(firstName,lastName,email,phoneNumber);
        return admin;
    }

    public static ArrayList<Seller> getSellerRequests() {return sellerRequests;}
    public static ArrayList<Product> getAddRequest() {return addRequest;}
    public static ArrayList<EditRequest> getEditRequest() {return editRequests;}
    public static ArrayList<Product> getRemoveRequest() {return removeRequest;}
    public static ArrayList<Comment> getCommentRequests() {return commentRequests;}

    //-----------------------------------
    void changePersonalInf(String field,String newfield)throws InvalidInput
    {
        if (field.equals("firstName"))
            setFirstName(newfield);

        else if (field.equals("lastName"))
            setLastName(newfield);

        else if (field.equals("email"))
        {
            Matcher matcher1 = pattern_email.matcher(newfield);
            if ( !matcher1.matches())
                throw new InvalidEmail();
            else
                setEmail(newfield);
        }


        else if (field.equals("phoneNumber"))
        {
            Matcher matcher2 = pattern_phoneNumber.matcher(newfield);
            if ( !matcher2.matches())
                throw new InvalidPhoneNumber();
            else
                setPhoneNumber(newfield);
        }

        else if (field.equals("password"))
            setPassword(newfield);
    }

    void removeUser(String userName)
    {
        for (int i=0; i<SellerManager.getSellers().size(); i++)
            if (userName.equals(SellerManager.getSellers().get(i).getUserName()))
                SellerManager.getSellers().remove(SellerManager.getSellers().get(i));

        for (int i=0; i<CustomerManager.getCustomers().size(); i++)
            if (userName.equals(CustomerManager.getCustomers().get(i).getUserName()))
                CustomerManager.getCustomers().remove(CustomerManager.getCustomers().get(i));
    }

}
class EditRequest
{
    Product product;
    String field;
    String previousAmount;
    String newAmount;

    EditRequest(Product product,String field, String previousField,String newAmount)
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
//--------------menu------********  part c *******----------------------------------------
class Interface
{
    static Customer c;
    static Seller s;
    static Admin admin;

    static Scanner sc=new Scanner(System.in);

    static void showMainMenu()
    {
        System.out.println("***welcome***");
        System.out.println();
        System.out.println("1-user area");//ناحیه کاربری
        System.out.println("2-products");// محصولات
        System.out.println("3-exit");

        try {
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    showUserArea();
                    break;
                case 2:
                    ProductPanel.showProductsPage();
                    break;
                case 3:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("invalid input");
                    showMainMenu();
            }
        }
        catch (InputMismatchException IME)
        {

            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showMainMenu();
        }
    }

    static void showUserArea()
    {
        System.out.println("Are you a:");
        System.out.println("1-customer");
        System.out.println("2-seller");
        System.out.println("3-admin");

        try {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("have you sign in before?");
                    System.out.println("1-yes");
                    System.out.println("2-no");

                    int hasSignIn = sc.nextInt();

                    if (hasSignIn == 2)
                        CustomerPanel.showCustomerRegisterPage();

                    else if (hasSignIn == 1) {
                        System.out.println("enter your username");
                        String username = sc.next();
                        System.out.println("enter your password");
                        String password = sc.next();
                        boolean login = false;
                        for (int i = 0; i < CustomerManager.getCustomers().size(); i++) {
                            if (CustomerManager.getCustomers().get(i).getUserName().equals(username) &&     //مشتری قبلا ثبت نام کرده
                                    CustomerManager.getCustomers().get(i).getPassword().equals(password)) {
                                c = CustomerManager.getCustomers().get(i);
                                login = true;
                                System.out.println(CustomerManager.getCustomers().get(i).toString());
                                CustomerPanel.showCustomerAccess(c);
                                break;
                            }
                        }
                        if (login == false) {
                            System.out.println("you should register");
                            CustomerPanel.showCustomerRegisterPage();
                        }
                    }

                    break;

                case 2:
                    System.out.println("have you sign in before?");
                    System.out.println("1-yes");
                    System.out.println("2-no");


                    hasSignIn = sc.nextInt();

                    if (hasSignIn == 2)
                        SellerPanel.showSellerRegisterPage(s);

                    else if (hasSignIn == 1) {
                        System.out.println("enter your username");
                        String username = sc.next();
                        System.out.println("enter your password");
                        String password = sc.next();
                        boolean Login = false;
                        for (int i = 0; i < SellerManager.getSellers().size(); i++) {
                            if (SellerManager.getSellers().get(i).getUserName().equals(username) &&     //فروشنده قبلا ثبت نام کرده
                                    SellerManager.getSellers().get(i).getPassword().equals(password)) {
                                s = SellerManager.getSellers().get(i);
                                Login = true;
                                System.out.println(SellerManager.getSellers().get(i).toString());
                                SellerPanel.showSellerAccess(s);
                                break;
                            }
                        }
                        if (Login == false) {
                            System.out.println("you should register first");
                            SellerPanel.showSellerRegisterPage(s);
                        }

                    }

                    break;

                case 3:
                    System.out.println("enter your username");
                    String username = sc.next();
                    System.out.println("enter your password");
                    String password = sc.next();

                    if (username.equals("admin") && password.equals("admin"))
                        AdminPanel.showAdminAccess(admin);
                    break;

                default:
                    System.out.println("invalid input");
                    showUserArea();
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showUserArea();
        }

    }

    static void shippingPage()
    {
        System.out.println(c.toString());

        double totalPrice = 0;
        for (int i =0; i<c.getCart().size(); i++)
            totalPrice += c.getCart().get(i).getPrice();

        if (c.getCredit() >= totalPrice)
            System.out.println(" total price is: " + totalPrice );

        showMainMenu();
    }

    static void editProduct()
    {
        System.out.println("enter the product id");
        try {
            int id = sc.nextInt();

            int field;

            if(Category.getProducts().get(id) instanceof Mobile)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-memory capacity , 7-RAM , 8-operating system , 9-weight , 10-dimension");
                System.out.println("11-number of SIM , 12-camera quality");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();;
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for memory capacity");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "memory", Integer.toString(((Mobile) Category.getProducts().get(id)).getMemoryCapacity()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for RAM");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "RAM", Integer.toString(((Mobile) Category.getProducts().get(id)).getRAMcapacity()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for operating system");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "os", ((Mobile) Category.getProducts().get(id)).getOperatingSystem(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for weight");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "weight", Double.toString(((Mobile) Category.getProducts().get(id)).getWeight()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 10:
                        System.out.println("enter a new amount for dimension");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "dimension", ((Mobile) Category.getProducts().get(id)).getDimensions(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 11:
                        System.out.println("enter a new amount for number of SIM");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "SIM", Integer.toString(((Mobile) Category.getProducts().get(id)).getNumberOfSIM()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 12:
                        System.out.println("enter a new amount for camera quality");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "camera", Integer.toString(((Mobile) Category.getProducts().get(id)).getCameraQuality()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Laptop)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-memory capacity , 7-RAM , 8-operating system , 9-weight , 10-dimension");
                System.out.println("11-CPU model , 12-is it gaming?");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for memory");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "memory", Integer.toString(((Laptop) Category.getProducts().get(id)).getMemoryCapacity()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for RAM");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "RAM", Integer.toString(((Laptop) Category.getProducts().get(id)).getRAMcapacity()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for operating system");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "os", ((Laptop) Category.getProducts().get(id)).getOperatingSystem(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for weight");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "weight", Double.toString(((Laptop) Category.getProducts().get(id)).getWeight()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 10:
                        System.out.println("enter a new amount for dimension");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "dimension", ((Laptop) Category.getProducts().get(id)).getDimensions(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 11:
                        System.out.println("enter a new amount for CPU");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "CPU", ((Laptop) Category.getProducts().get(id)).getCPUmodel(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 12:
                        System.out.println("is it gaming?  (true/false)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "gaming", Boolean.toString(((Laptop) Category.getProducts().get(id)).isGaming()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Clothing)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-producer country , 7-material ");
                System.out.println("8-size , 9-type of clothing");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for country");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "country", ((Clothing) Category.getProducts().get(id)).getProducerCountry(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for material");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "material", ((Clothing) Category.getProducts().get(id)).getMaterial(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for size");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "size", ((Clothing) Category.getProducts().get(id)).getSize(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for kinf of cloth(TSHIRT,PANTS,SWEATSHIRT,BLAZER;)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "type", ((Clothing) Category.getProducts().get(id)).getKindsOfClothes().toString(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Shoes)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-producer country , 7-material ");
                System.out.println("8-size , 9-type of shoes");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for country");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "country", ((Shoes) Category.getProducts().get(id)).getProducerCountry(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for material");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "material", ((Shoes) Category.getProducts().get(id)).getMaterial(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for size");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "size", Integer.toString(((Shoes) Category.getProducts().get(id)).getSize()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for type");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "type", ((Shoes) Category.getProducts().get(id)).getKindsOfShoes().toString(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof TV)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-energy consumption , 7-is it guaranteed? ");
                System.out.println("8-vision quality , 9-screen size");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for energy");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "energy", ((TV) Category.getProducts().get(id)).getEnergyConsumption(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for guaranteed(true/false)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "guaranteed", Boolean.toString(((TV) Category.getProducts().get(id)).isGuaranteed()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for quality");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "quality", ((TV) Category.getProducts().get(id)).getVisionQuality(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for size");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "size", Integer.toString(((TV) Category.getProducts().get(id)).getScreenSize()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Refrigerator)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-energy consumption , 7-is it guaranteed? ");
                System.out.println("8-capacity , 9-type , 10-does it have freezer?");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for energy");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "energy", ((Refrigerator) Category.getProducts().get(id)).getEnergyConsumption(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for guaranteed(true/false)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "guaranteed", Boolean.toString(((Refrigerator) Category.getProducts().get(id)).isGuaranteed()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for capacity");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "capacity", Integer.toString(((Refrigerator) Category.getProducts().get(id)).getCapacity()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for kind of cloth");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "type", ((Refrigerator) Category.getProducts().get(id)).getKind(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 10:
                        System.out.println("enter a new amount for has freezer(true/false)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "freezer", Boolean.toString(((Refrigerator) Category.getProducts().get(id)).HasFreezer()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Cooker)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-energy consumption , 7-is it guaranteed? ");
                System.out.println("8-number of ingles , 9-material , 10-does it have oven?");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for energy");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "energy", ((Cooker) Category.getProducts().get(id)).getEnergyConsumption(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for guaranteed(true/false)");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "guaranteed", Boolean.toString(((Cooker) Category.getProducts().get(id)).isGuaranteed()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 8:
                        System.out.println("enter a new amount for Ingles Number");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "InglesNumber", Integer.toString(((Cooker) Category.getProducts().get(id)).getNumberOfIngle()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 9:
                        System.out.println("enter a new amount for material");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "material", ((Cooker) Category.getProducts().get(id)).getMaterial(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 10:
                        System.out.println("enter a new amount for has oven");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "oven", Boolean.toString(((Cooker) Category.getProducts().get(id)).isHasOven()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            else if(Category.getProducts().get(id) instanceof Food)
            {
                System.out.println("which field do you want to edit?   1-name , 2-company , 3-price , 4-number of product , 5-explain");
                System.out.println("6-date of produce , 7-date of expiration ");
                field = sc.nextInt();

                switch (field)
                {
                    case 1:
                        System.out.println("enter a new amount for name");
                        String newAmount = sc.next();
                        EditRequest editRequest = new EditRequest(Category.getProducts().get(id), "name", Category.getProducts().get(id).getProductName(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 2:
                        System.out.println("enter a new amount for company");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "company", Category.getProducts().get(id).getProductCompany(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 3:
                        System.out.println("enter a new amount for price");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "price", Double.toString(Category.getProducts().get(id).getPrice()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 4:
                        System.out.println("enter a new amount for number of product");
                        newAmount = sc.next();
                        sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "number", Integer.toString(Category.getProducts().get(id).getNumberOfProduct()), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 5:
                        System.out.println("enter a new amount for explain");
                        newAmount = sc.nextLine();
                        editRequest = new EditRequest(Category.getProducts().get(id), "explain", Category.getProducts().get(id).getExplain(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 6:
                        System.out.println("enter a new amount for date of prodution");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "pro", ((Food) Category.getProducts().get(id)).getDateOfManufacture(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;
                    case 7:
                        System.out.println("enter a new amount for date of expiration");
                        newAmount = sc.next();
                        editRequest = new EditRequest(Category.getProducts().get(id), "exp", ((Food) Category.getProducts().get(id)).getExpirationDate(), newAmount);
                        Admin.getEditRequest().add(editRequest);
                        break;

                    default:
                        System.out.println("invalid input");
                        editProduct();
                }
            }

            System.out.println("product editted");
            SellerPanel.showSellerAccess(s);
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            editProduct();
        }

    }
}

class CustomerPanel
{
    static Scanner sc =new Scanner(System.in);

    static void showCustomerAccess(Customer c)
    {
        System.out.println("1-edit personal information");
        System.out.println("2-watch products");
        System.out.println("3-search product");
        System.out.println("4-buy product");
        System.out.println("5-show cart");
        System.out.println("6-commenting");
        System.out.println("7-show buy history");
        System.out.println("8-back to menu");

        try {
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("enter the field you want to edit(exept your username):");
                    String field=sc.next();
                    System.out.println("enter the new amount of this field :");
                    String newField=sc.next();
                    try {
                        c.changePersonalInf(field,newField);
                        showCustomerAccess(c);
                    }
                    catch (InvalidInput II)
                    {
                        System.out.println(II.getMessage());
                        showCustomerAccess(c);
                    }

                    break;

                case 2:
                    ProductPanel.showProductsPage();
                    break;

                case 3:
                    ProductPanel.search();
                    break;
                case 4:
                    buyProduct(c);
                    break;
                case 5:
                    for(Product p: c.getCart())
                        System.out.println(p.toString());

                    System.out.println("do you confirm the list");
                    System.out.println("1-yes");
                    System.out.println("2-no");
                    int isConfirmed = sc.nextInt();
                    switch (isConfirmed)
                    {
                        case 1:
                            Interface.shippingPage();
                            break;
                        case 2:
                            showCustomerAccess(c);
                    }
                    break;

                case 6:
                    System.out.println("enter the product id");
                    int id = sc.nextInt();

                    System.out.println("write your comment(in one line)");
                    String text = sc.nextLine();

                    boolean hasBought = false;
                    for (int i=0 ; i<c.getBuyHistory().size() ; i++)
                        for (int j=0 ; j<c.getBuyHistory().get(i).getPurchasedProducts().size() ;j++)
                            if (c.getBuyHistory().get(i).getPurchasedProducts().get(j).getProductId() == id)
                                hasBought = true;

                    Comment comment = new Comment(c,Category.getProducts().get(id),text,hasBought);
                    comment.setIsComfirmed( Comment.EN.WAITING);
                    System.out.println("you may have to wait till the admin confirm your request");
                    Admin.getCommentRequests().add(comment);
                    System.out.println("back to menu");
                    Interface.showMainMenu();
                    break;

                case 7:
                    for (int i=0 ; i<c.getBuyHistory().size() ; i++)//show history
                    {
                        System.out.println("invoice number " + i);
                        System.out.println(c.getBuyHistory().get(i).toString());
                        System.out.println("products:");
                        for (int j=0 ; j<c.getBuyHistory().get(i).getPurchasedProducts().size() ; j++)
                            System.out.println(c.getBuyHistory().get(i).getPurchasedProducts().get(j).toString());
                    }

                    System.out.println("enter the product id you want to rate");
                    id = sc.nextInt();
                    hasBought = false;
                    for (int i=0 ; i<c.getBuyHistory().size() ; i++)//show history
                        for (int j=0 ; j<c.getBuyHistory().get(i).getPurchasedProducts().size() ; j++)
                            if(c.getBuyHistory().get(i).getPurchasedProducts().get(j).getProductId() == id);
                {
                    hasBought = true;
                    System.out.println("enetr the rate(from 1 to 10");
                    int rate = sc.nextInt();
                    Rate rate1 =new Rate(rate,Category.getProducts().get(id));//ساخت شی از کلاس امتیاز
                    Category.getProducts().get(id).getRates().add(rate1);//اد کردن امتیاز جدید به لیست امتیازات
                    Category.getProducts().get(id).setAverageRate();//محاسبه ی میانگین نمرات
                }
                break;

                case 8:
                    Interface.showMainMenu();

                default:
                    System.out.println("invalid input");
                    showCustomerAccess(c);
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showCustomerAccess(c);
        }
    }

    static void showCustomerRegisterPage()
    {
        try {
            System.out.println("username?");
            String username=sc.next();
            System.out.println("first name?");
            String firstName=sc.next();
            System.out.println("last name?");
            String lastName=sc.next();
            System.out.println("email");
            String email=sc.next();
            System.out.println("phone number?");
            String phoneNumber=sc.next();
            System.out.println("password?");
            String password=sc.next();
            System.out.println("credit?");
            double credit=sc.nextDouble();

            try {
                Customer customer=new Customer(username,firstName,lastName,email,phoneNumber,password,"customer",credit);
                CustomerManager.registerCustomer(customer);//ساخت مشتری جدید و اضافه کردن به لیست مشتری ها

                if ( Files.numberOfCustomers.length() != 0)//فایل خالی نبود
                {
                    int read =Files.fr_numberOFCustomers.read();
                    File customerFolder = new File("E:\\Project\\saved data\\users\\customers\\","customer"+(char)read);
                    customerFolder.mkdir();

                    File cart = new File(customerFolder,"cart");
                    cart.createNewFile();

                    File buyInvoiceList = new File(customerFolder,"list of buy invoice");
                    buyInvoiceList.createNewFile();

                    File information = new File(customerFolder,"information");
                    information.createNewFile();

                    read++;
                    Files.fw_numberOFCustomers.write(read);
                    Files.fw_numberOFCustomers.flush();
                }

                else
                {
                    File customerFolder = new File("E:\\Project\\saved data\\users\\customers\\customer1");
                    customerFolder.mkdir();
                    Files.fw_numberOFCustomers.write(49);
                    Files.fw_numberOFCustomers.flush();
                }
                showCustomerAccess(customer);
            }
            catch (InvalidInput II)
            {
                System.out.println(II.getMessage());
                showCustomerRegisterPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!  :  credit is not allowed to be string");
            sc=new Scanner(System.in);
            showCustomerRegisterPage();
        }
    }

    static void buyProduct(Customer c)
    {
        System.out.println("enter your username");
        String username=sc.next();
        System.out.println("enter your password");
        String password=sc.next();
        boolean login=false;
        for (int i=0; i<CustomerManager.getCustomers().size(); i++)
        {
            if (CustomerManager.getCustomers().get(i).getUserName().equals(username) &&     //مشتری قبلا ثبت نام کرده
                    CustomerManager.getCustomers().get(i).getPassword().equals(password) )
            {
                c=CustomerManager.getCustomers().get(i);
                login=true;
                System.out.println("enter the id of product you want to buy");
                int id = sc.nextInt();
                System.out.println("enter the number of product with id " + id +" you want to buy");
                int numberOfProduct = sc.nextInt();
                try
                {
                    c.buy(id,numberOfProduct);
                }
                catch (InvalidShopping IS)
                {
                    System.out.println(IS.getMessage());
                }
                Interface.showMainMenu();
                break;
            }
        }
        if (login == false)
        {
            System.out.println("you should register first");
            showCustomerRegisterPage();
        }

    }
}

class SellerPanel
{
    static Scanner sc =new Scanner(System.in);

    static void showSellerAccess(Seller s)
    {
        System.out.println("1-edit personal information");
        System.out.println("2-add product");
        System.out.println("3-edit product");
        System.out.println("4-remove product");
        System.out.println("5-back to main menu");

        try {
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("enter the field you want to edit(exept your username):");
                    String field = sc.next();
                    System.out.println("enter the new amount of this field :");
                    String newField = sc.next();
                    try {
                        s.changePersonalInf(field, newField);
                        System.out.println("edit information done");
                        showSellerAccess(s);
                    }
                    catch (InvalidInput II)
                    {
                        System.out.println(II.getMessage());
                        showSellerAccess(s);
                    }
                    break;

                case 2:
                    System.out.println("what is product category?");
                    System.out.println("mobile,laptop,clothing,shoes,tv,refrigerator,cooker,food");
                    String catagory = sc.next();
                    System.out.println("enter : name,company,price,number of product,explain");
                    String name = sc.next();
                    String company = sc.next();
                    double price = sc.nextDouble();
                    int number = sc.nextInt();
                    String explain = sc.next();

                    switch (catagory)
                    {
                        case "mobile":
                            System.out.println("enter : memory capacity,RAM capacity,operating system,weight,dimension,number of sim,camera quality");
                            int memory = sc.nextInt();
                            int RAM =sc.nextInt();
                            String os = sc.next();
                            double weight = sc.nextByte();
                            String dimension = sc.toString();
                            int sim = sc.nextInt();
                            int camera = sc.nextInt();
                            Mobile mobile = new Mobile(name,company, price, s, number,explain,memory,RAM,os,weight,dimension,sim,camera);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(mobile);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "laptop":
                            System.out.println("enter : memory capacity,RAM capacity,operating system,weight,dimension,CPU model,is it gaming?");
                            memory = sc.nextInt();
                            RAM =sc.nextInt();
                            os = sc.next();
                            weight = sc.nextByte();
                            dimension = sc.toString();
                            String CPU = sc.next();
                            boolean isGaming = sc.nextBoolean();
                            Laptop laptop = new Laptop(name,company, price, s, number,explain,memory,RAM,os,weight,dimension,CPU,isGaming);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(laptop);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "clothing":
                            System.out.println("enter : producer country,material,size,type of clothing(TSHIRT,PANTS,SWEATSHIRT,BLAZER)");
                            String country = sc.next();
                            String material =sc.next();
                            String size = sc.next();
                            String type = sc.next();
                            Clothing clothing = new Clothing(name,company,price,s,number,explain,country,material,size, Clothing.EN.valueOf(type));
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(clothing);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "shoes":
                            System.out.println("enter : producer country,material,size,type of shoes(BOOT,SPORT,FLAT,HIGHHEELS)");
                            country = sc.next();
                            material =sc.next();
                            int Size = sc.nextInt();
                            type = sc.next();
                            Shoes shoes = new Shoes(name,company,price,s,number,explain,country,material,Size, Shoes.EN.valueOf(type));
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(shoes);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "tv":
                            System.out.println("enter : energy consumption,is it guaranteed?, vision quality, screen size");
                            String energy = sc.next();
                            boolean isGuaranteed = sc.nextBoolean();
                            String quality =sc.next();
                            int screenSize = sc.nextInt();
                            TV tv = new TV(name,company,price,s,number,explain, energy,isGuaranteed,quality,screenSize);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(tv);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "refrigerator":
                            System.out.println("enter : energy consumption,is it guaranteed?, capacity, type of refrigerator,does it have freezer?");
                            energy = sc.next();
                            isGuaranteed = sc.nextBoolean();
                            int capacity =sc.nextInt();
                            String Type = sc.next();
                            boolean hasFreezer = sc.nextBoolean();
                            Refrigerator refrigerator = new Refrigerator(name,company,price,s,number,explain, energy,isGuaranteed,capacity,Type,hasFreezer);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(refrigerator);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "cooker":
                            System.out.println("enter : energy consumption,is it guaranteed?, number of ingles, material,does it have oven?");
                            energy = sc.next();
                            isGuaranteed = sc.nextBoolean();
                            number =sc.nextInt();
                            material = sc.next();
                            boolean hasOven = sc.nextBoolean();
                            Cooker cooker = new Cooker(name,company,price,s,number,explain, energy,isGuaranteed,number,material,hasOven);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(cooker);//اد کردن به لیست درخواست های مدیر
                            break;

                        case "food":
                            System.out.println("enter producing date: ");
                            String proDate = sc.next();
                            System.out.println("enter expiration date: ");
                            String expDate = sc.next();
                            Food food = new Food(name,company,price,s,number,explain,proDate,expDate);
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getAddRequest().add(food);//اد کردن به لیست درخواست های مدیر
                            break;
                    }
                    showSellerAccess(s);
                    break;

                case 3:
                    Interface.editProduct();
                    break;

                case 4:
                    System.out.println("enter the product id");
                    int id = sc.nextInt();

                    boolean hasProduct = false;
                    for (int i=0 ;i<s.getProductsOnSale().size(); i++)
                        if (id == s.getProductsOnSale().get(i).getProductId())
                        {
                            hasProduct = true;
                            System.out.println("you may have to wait till the admin confirm your request");
                            Admin.getRemoveRequest().add(s.getProductsOnSale().get(i));//اد کردن به لیست درخواست های مدیر
                            break;
                        }
                    if (hasProduct == false)
                        System.out.println("you dont have this product");

                    showSellerAccess(s);
                    break;

                case 5:
                    Interface.showMainMenu();

                default:
                    System.out.println("invalid input");
                    showSellerAccess(s);
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showSellerAccess(s);
        }
    }

    static void showSellerRegisterPage(Seller s)
    {
        try {
            System.out.println("username?");
            String userName=sc.next();
            System.out.println("first name?");
            String firstname=sc.next();
            System.out.println("last name?");
            String lastname=sc.next();
            System.out.println("email");
            String email=sc.next();
            System.out.println("phone number?");
            String phonenumber=sc.next();
            System.out.println("password?");
            String password=sc.next();
            System.out.println("company name?");
            String companyName=sc.next();
            System.out.println("credit?");
            double credit=sc.nextDouble();

            try {
                s=new Seller(userName,firstname,lastname,email,phonenumber,password,"seller",companyName,credit);//ساخت فروشنده منتظر جدید
                System.out.println("you may have to wait till the admin confirm your request");
                Admin.getSellerRequests().add(s);//اد کردن به لیست درخواست های مدیر
                System.out.println("back to menu ...");
                Interface.showMainMenu();
            }
            catch (InvalidInput II)
            {
                System.out.println(II.getMessage());
                showSellerRegisterPage(s);
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!  :  credit is not allowed to be string");
            sc=new Scanner(System.in);
            showSellerRegisterPage(s);
        }
    }
}

class AdminPanel
{
    static Scanner sc =new Scanner(System.in);

    static void showAdminAccess(Admin admin)
    {
        System.out.println("1-edit personal information");
        System.out.println("2-show seller registration request");
        System.out.println("3-show add product requests");
        System.out.println("4-show edit product requests");
        System.out.println("5-show remove product requests");
        System.out.println("6-show list of all users");
        System.out.println("7-remove a useer");
        System.out.println("8-catagory list");
        System.out.println("9-show comment requests");
        System.out.println("10-back to main menu");

        try {
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("enter the field you want to edit(exept your username):");
                    String field = sc.nextLine();
                    System.out.println("enter the new amount of this field :");
                    String newField = sc.nextLine();

                    try {
                        admin.changePersonalInf(field, newField);
                        System.out.println("edit information done");
                        showAdminAccess(admin);
                    }
                    catch (InvalidInput II)
                    {
                        System.out.println(II.getMessage());
                        showAdminAccess(admin);
                    }

                    break;

                case 2:
                    for (int i=0 ; i<Admin.getSellerRequests().size() ;i++)
                    {
                        Seller seller = Admin.getSellerRequests().get(i);
                        System.out.println(seller.toString());
                        System.out.println("do you allow this person to register as a seller?");
                        System.out.println("1-yes");
                        System.out.println("2-no");
                        choice = sc.nextInt();

                        if (choice == 1)
                        {
                            if ( Files.numberOfSellers.length() != 0)//فایل خالی نبود
                            {
                                int read =Files.fr_numberOFSellers.read();
                                SellerManager.registerSeller(seller);//اد کردن به فروشندگان
                                File sellerFolder = new File("E:\\Project\\saved data\\users\\sellers\\","seller"+(char)read);
                                sellerFolder.mkdir();
                                File listOfProducts = new File(sellerFolder,"list of products");
                                listOfProducts.mkdir();
                                File sellInvoiceList = new File(sellerFolder,"list of sell invoice");
                                sellInvoiceList.createNewFile();
                                File information = new File(sellerFolder,"information");
                                information.createNewFile();
                                read++;
                                Files.fw_numberOFSellers.write(read);
                                Files.fw_numberOFSellers.flush();
                            }

                            else
                            {
                                SellerManager.registerSeller(seller);//اد کردن به فروشندگان
                                File sellerFolder = new File("E:\\Project\\saved data\\users\\sellers\\seller1");
                                sellerFolder.mkdir();
                                Files.fw_numberOFSellers.write(49);
                                Files.fw_numberOFSellers.flush();
                            }
                            Admin.getSellerRequests().remove(seller);

                        }

                        else if (choice == 2)
                            Admin.getSellerRequests().remove(seller);//حذف از لیست درخواست ها
                    }
                    showAdminAccess(admin);
                    break;

                case 3:
                    for (Product product: Admin.getAddRequest())
                    {
                        System.out.println(product.toString());
                        System.out.println("do you allow the seller to add this product");
                        System.out.println("1-yes");
                        System.out.println("2-no");
                        choice = sc.nextInt();

                        if (choice == 1)
                        {
                            Category.getProducts().add(product);//اد کردن به لیست کل کالاها
                            product.getSeller().getProductsOnSale().add(product);//اد کردن به لیست کالاهای فروشنده
                            System.out.println("add product done");
                        }
                        else if (choice == 2)
                            Admin.getAddRequest().remove(product);//حذف از لیست درخواست ها
                    }
                    showAdminAccess(admin);
                    break;

                case 4:
                    for (EditRequest editRequest: Admin.getEditRequest())
                    {
                        System.out.println(editRequest.product.toString());//چاپ محصول
                        System.out.println(editRequest.toString());
                        System.out.println("do you allow the seller to edit this product");
                        System.out.println("1-yes");
                        System.out.println("2-no");
                        choice = sc.nextInt();

                        if (choice == 1)
                        {
                            if(editRequest.product instanceof Mobile)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "memory":
                                        ((Mobile) editRequest.product).setMemoryCapacity(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "RAM":
                                        ((Mobile) editRequest.product).setRAMcapacity(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "os":
                                        ((Mobile) editRequest.product).setOperatingSystem(editRequest.newAmount);
                                        break;
                                    case "weight":
                                        ((Mobile) editRequest.product).setWeight(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "dimension":
                                        ((Mobile) editRequest.product).setDimensions(editRequest.newAmount);
                                        break;
                                    case "SIM":
                                        ((Mobile) editRequest.product).setNumberOfSIM(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "camera":
                                        ((Mobile) editRequest.product).setCameraQuality(Integer.parseInt(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Laptop)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "memory":
                                        ((Laptop) editRequest.product).setMemoryCapacity(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "RAM":
                                        ((Laptop) editRequest.product).setRAMcapacity(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "os":
                                        ((Laptop) editRequest.product).setOperatingSystem(editRequest.newAmount);
                                        break;
                                    case "weight":
                                        ((Laptop) editRequest.product).setWeight(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "dimension":
                                        ((Laptop) editRequest.product).setDimensions(editRequest.newAmount);
                                        break;
                                    case "CPU":
                                        ((Laptop) editRequest.product).setCPUmodel(editRequest.newAmount);
                                        break;
                                    case "gaming":
                                        ((Laptop) editRequest.product).setGaming(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Clothing)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "country":
                                        ((Clothing) editRequest.product).setProducerCountry(editRequest.newAmount);
                                        break;
                                    case "material":
                                        ((Clothing) editRequest.product).setMaterial(editRequest.newAmount);
                                        break;
                                    case "size":
                                        ((Clothing) editRequest.product).setSize(editRequest.newAmount);
                                        break;
                                    case "type":
                                        ((Clothing) editRequest.product).setKindsOfClothes(Clothing.EN.valueOf(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Shoes)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "country":
                                        ((Shoes) editRequest.product).setProducerCountry(editRequest.newAmount);
                                        break;
                                    case "material":
                                        ((Shoes) editRequest.product).setMaterial(editRequest.newAmount);
                                        break;
                                    case "size":
                                        ((Shoes) editRequest.product).setSize(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "type":
                                        ((Shoes) editRequest.product).setKindsOfShoes(Shoes.EN.valueOf(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof TV)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "energy":
                                        ((TV) editRequest.product).setEnergyConsumption(editRequest.newAmount);
                                        break;
                                    case "guaranteed":
                                        ((TV) editRequest.product).setGuaranteed(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                    case "quality":
                                        ((TV) editRequest.product).setVisionQuality(editRequest.newAmount);
                                        break;
                                    case "size":
                                        ((TV) editRequest.product).setScreenSize(Integer.parseInt(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Refrigerator)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "energy":
                                        ((Refrigerator) editRequest.product).setEnergyConsumption(editRequest.newAmount);
                                        break;
                                    case "guaranteed":
                                        ((Refrigerator) editRequest.product).setGuaranteed(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                    case "capacity":
                                        ((Refrigerator) editRequest.product).setCapacity(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "type":
                                        ((Refrigerator) editRequest.product).setKind(editRequest.newAmount);
                                        break;
                                    case "freezer":
                                        ((Refrigerator) editRequest.product).setHasFreezer(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Cooker)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "energy":
                                        ((Cooker) editRequest.product).setEnergyConsumption(editRequest.newAmount);
                                        break;
                                    case "guaranteed":
                                        ((Cooker) editRequest.product).setGuaranteed(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                    case "InglesNumber":
                                        ((Cooker) editRequest.product).setNumberOfIngle(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "material":
                                        ((Cooker) editRequest.product).setMaterial(editRequest.newAmount);
                                        break;
                                    case "oven":
                                        ((Cooker) editRequest.product).setHasOven(Boolean.parseBoolean(editRequest.newAmount));
                                        break;
                                }
                            }

                            else if(editRequest.product instanceof Food)
                            {
                                switch (editRequest.field)
                                {
                                    case "name":
                                        editRequest.product.setProductName(editRequest.newAmount);
                                        break;
                                    case "company":
                                        editRequest.product.setProductCompany(editRequest.newAmount);
                                        break;
                                    case "price":
                                        editRequest.product.setPrice(Double.parseDouble(editRequest.newAmount));
                                        break;
                                    case "number":
                                        editRequest.product.setNumberOfProduct(Integer.parseInt(editRequest.newAmount));
                                        break;
                                    case "explain":
                                        editRequest.product.setExplain(editRequest.newAmount);
                                        break;
                                    case "pro":
                                        ((Food) editRequest.product).setDateOfManufacture(editRequest.newAmount);
                                        break;
                                    case "exp":
                                        ((Food) editRequest.product).setExpirationDate(editRequest.newAmount);
                                        break;
                                }
                            }
                        }

                        else if (choice == 2)
                            Admin.getEditRequest().remove(editRequest);//حذف از لیست درخواست ها
                    }
                    showAdminAccess(admin);
                    break;

                case 5:
                    for (Product product: Admin.getRemoveRequest())
                    {
                        System.out.println(product.toString());
                        System.out.println("do you allow the seller to remove this product");
                        System.out.println("1-yes");
                        System.out.println("2-no");
                        choice = sc.nextInt();

                        if (choice == 1)
                            product.getSeller().getProductsOnSale().remove(product);//حذف از لیست کالاهای فروشنده
                        else if (choice == 2)
                            Admin.getRemoveRequest().remove(product);//حذف از لیست درخواست ها
                    }
                    showAdminAccess(admin);
                    break;

                case 6:
                    System.out.println("sellers:");
                    for (int i=0; i<SellerManager.getSellers().size() ; i++)
                        System.out.println(SellerManager.getSellers().get(i).toString());
                    System.out.println("customers:");
                    for (int i=0; i<CustomerManager.getCustomers().size() ; i++)
                        System.out.println(CustomerManager.getCustomers().get(i).toString());
                    showAdminAccess(admin);
                    break;

                case 7:
                    System.out.println("enter username you want to remove");
                    String username = sc.next();
                    admin.removeUser(username);
                    showAdminAccess(admin);
                    break;

                case 8:
                    System.out.println("choose the catagory");
                    System.out.println("1-Digital Product");
                    System.out.println("2-Wearing");
                    System.out.println("3-Home Appliances");
                    System.out.println("4-Food");
                    int catagory = sc.nextInt();

                    switch (catagory)
                    {
                        case 1:
                            System.out.println("1-mobile");
                            System.out.println("2-laptop");
                            choice =sc.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Mobile)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                                case 2:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Laptop)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("1-clothing");
                            System.out.println("2-shoes");
                            choice = sc.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Clothing)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                                case 2:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Shoes)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("1-tv");
                            System.out.println("2-refrigerator");
                            System.out.println("3-cooker");
                            choice = sc.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof TV)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                                case 2:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Refrigerator)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                                case 3:
                                    for (int i=0; i<Category.getProducts().size(); i++)
                                        if (Category.getProducts().get(i) instanceof Cooker)
                                            System.out.println(Category.getProducts().get(i).toString());
                                    break;
                            }
                            break;
                        case 4:
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof Food)
                                    System.out.println(Category.getProducts().get(i).toString());
                            break;
                    }
                    showAdminAccess(admin);
                    break;

                case 9:
                    for (Comment comment: Admin.getCommentRequests())
                    {
                        System.out.println(comment.toString());
                        System.out.println("do you confirm this comment?");
                        System.out.println("1-yes");
                        System.out.println("2-no");
                        choice = sc.nextInt();

                        if (choice == 1)
                        {
                            comment.getProductWhichCommented().setComments(comment);//اد کردن به لیست نظرات محصول
                            comment.setIsComfirmed(Comment.EN.CONFIRMED);
                        }

                        else if (choice == 2)
                        {
                            Admin.getCommentRequests().remove(comment);//حذف از لیست درخواست ها
                            comment.setIsComfirmed(Comment.EN.NOTCONFIRMED);
                        }

                    }
                    showAdminAccess(admin);
                    break;

                case 10:
                    Interface.showMainMenu();

                default:
                    System.out.println("invalid input");
                    showAdminAccess(admin);
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showAdminAccess(admin);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ProductPanel
{
    static Scanner sc = new Scanner(System.in);

    static void showProductsPage()
    {
        System.out.println("choose the catagory");
        System.out.println("1-Digital Product");
        System.out.println("2-Wearing");
        System.out.println("3-Home Appliances");
        System.out.println("4-Food");
        System.out.println("5-back to menu");

        try {
            int catagory = sc.nextInt();

            switch (catagory)
            {
                case 1:
                    System.out.println("1-list of products");
                    System.out.println("2-search product");
                    int choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            for (int i = 0; i < Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof DigitalProduct)
                                    System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            search();
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            showProductsPage();
                    }
                    showProductsPage();
                    break;

                case 2:
                    System.out.println("1-list of products");
                    System.out.println("2-search product");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            for (int i = 0; i < Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof Wearing)
                                    System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            search();
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            showProductsPage();
                    }
                    showProductsPage();
                    break;

                case 3:
                    System.out.println("1-list of products");
                    System.out.println("2-search product");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            for (int i = 0; i < Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof HomeAppliances)
                                    System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            search();
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            showProductsPage();
                    }
                    showProductsPage();
                    break;

                case 4:
                    System.out.println("1-list of products");
                    System.out.println("2-search product");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            for (int i = 0; i < Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof Food)
                                    System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            search();
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            showProductsPage();
                    }
                    showProductsPage();
                    break;

                case 5:
                    Interface.showMainMenu();

                default:
                    System.out.println("invalid input");
                    showProductsPage();
            }
        }

        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            showProductsPage();
        }
    }

    static void search()
    {
        System.out.println("choose catagory;");
        System.out.println("1-DigitalProduct");
        System.out.println("2-Wearing");
        System.out.println("3-HomeAppliances");
        System.out.println("4-Food");
        System.out.println("5-back to main menu");

        try {
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1://DigitalProduct
                    System.out.println("apply filter on :");
                    System.out.println("1-company");
                    System.out.println("2-price");
                    int filterOn=sc.nextInt();

                    switch (filterOn)
                    {
                        case 1:
                            System.out.println("enter company name");
                            String company=sc.next();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof DigitalProduct)
                                    if (Category.getProducts().get(i).getProductCompany().equals(company))
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;
                        case 2:
                            System.out.println("from");
                            double from = sc.nextDouble();
                            System.out.println("to");
                            double to = sc.nextDouble();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof DigitalProduct)
                                    if (from<=Category.getProducts().get(i).getPrice() && Category.getProducts().get(i).getPrice()<=to)
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            search();
                    }
                    showProductsPage();
                    break;

                case 2://Wearing
                    System.out.println("apply filter on :");
                    System.out.println("1-producer country");
                    System.out.println("2-material");
                    filterOn = sc.nextInt();

                    switch (filterOn)
                    {
                        case 1:
                            System.out.println("enter name of country");
                            String country=sc.nextLine();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof Wearing)
                                    if (Category.getProducts().get(i).getProductCompany().equals(country))
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            System.out.println("material:");
                            String material=sc.nextLine();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof DigitalProduct)
                                    if (Category.getProducts().get(i).getProductCompany().equals(material))
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            search();
                    }
                    showProductsPage();
                    break;

                case 3://HomeAppliances
                    System.out.println("apply filter on :");
                    System.out.println("1-energy consumption");
                    System.out.println("2-price");
                    filterOn = sc.nextInt();

                    switch (filterOn)
                    {
                        case 1:
                            System.out.println("enter amount of using energy");
                            String energy=sc.nextLine();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof HomeAppliances)
                                    if (Category.getProducts().get(i).getProductCompany().equals(energy))
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            System.out.println("from");
                            double from = sc.nextDouble();
                            System.out.println("to");
                            double to = sc.nextDouble();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof DigitalProduct)
                                    if (from<=Category.getProducts().get(i).getPrice() && Category.getProducts().get(i).getPrice()<=to)
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            search();
                    }
                    showProductsPage();
                    break;

                case 4://Food
                    System.out.println("apply filter on :");
                    System.out.println("1-company");
                    System.out.println("2-rate");

                    filterOn=sc.nextInt();

                    switch (filterOn)
                    {
                        case 1:
                            System.out.println("enter company name");
                            String company=sc.nextLine();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof Food)
                                    if (Category.getProducts().get(i).getProductCompany().equals(company))
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        case 2:
                            System.out.println("enter rate you want");
                            double rate = sc.nextDouble();
                            for (int i=0; i<Category.getProducts().size(); i++)
                                if (Category.getProducts().get(i) instanceof HomeAppliances)
                                    if (Category.getProducts().get(i).getAverageRate() == rate)
                                        System.out.println(Category.getProducts().get(i).toString());
                            showProductsPage();
                            break;

                        default:
                            System.out.println("invalid input");
                            search();
                    }
                    showProductsPage();
                    break;

                case 5:
                    Interface.showMainMenu();

                default:
                    System.out.println("invalid input");
                    search();
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.println("!invalid input!");
            sc=new Scanner(System.in);
            search();
        }
    }
}

//-----------------------------********  phase 2 *******--------------------

class InvalidShopping extends Exception
{
    InvalidShopping(String message)
    {
        super("Invalid Shopping : " + message);
    }
}

class LackOfInventory extends InvalidShopping
{
    LackOfInventory()
    {
        super("this product is not available now");
    }
}

class LackOfMoney extends InvalidShopping
{
    LackOfMoney()
    {
        super("your money is not enough to buy this product");
    }
}

class InvalidInput extends Exception
{
    InvalidInput(String message)
    {
        super("Invalid Input : " + message);
    }
}

class InvalidEmail extends InvalidInput
{
    InvalidEmail()
    {
        super("invalid email format");
    }
}

class InvalidPhoneNumber extends InvalidInput
{
    InvalidPhoneNumber()
    {
        super("invalid phone number");
    }
}

class Files
{
    static FileWriter fw_numberOFSellers;
    static FileReader fr_numberOFSellers;
    static File numberOfSellers;

    static FileWriter fw_numberOFCustomers;
    static FileReader fr_numberOFCustomers;
    static File numberOfCustomers;


    static void createFolders() throws IOException {
        File savedData = new File("E:\\Project\\saved data");
        savedData.mkdir();
        File catagories = new File("E:\\Project\\saved data\\catagories");
        catagories.mkdir();
        File users = new File("E:\\Project\\saved data\\users");
        users.mkdir();
        File wearing = new File("E:\\Project\\saved data\\catagories\\wearing");
        wearing.mkdir();
        File shoes = new File("E:\\Project\\saved data\\catagories\\wearing\\shoes");
        shoes.mkdir();
        BufferedWriter shoesSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\wearing\\shoes\\special properties.txt"));
        File shoesList = new File("E:\\Project\\saved data\\catagories\\wearing\\shoes\\list of products");
        shoesList.mkdir();
        File clothing = new File("E:\\Project\\saved data\\catagories\\wearing\\clothing");
        clothing.mkdir();
        BufferedWriter clothinSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\wearing\\clothing\\special properties.txt"));
        File clothingList = new File("E:\\Project\\saved data\\catagories\\wearing\\clothing\\list of products");
        clothingList.mkdir();
        File food = new File("E:\\Project\\saved data\\catagories\\food");
        food.mkdir();
        BufferedWriter foodSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\food\\special properties.txt"));
        File foodList = new File("E:\\Project\\saved data\\catagories\\food\\list of products");
        foodList.mkdir();
        File digitalProduct = new File("E:\\Project\\saved data\\catagories\\digital product");
        digitalProduct.mkdir();
        File mobie = new File("E:\\Project\\saved data\\catagories\\digital product\\mobile");
        mobie.mkdir();
        BufferedWriter mobileSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\digital product\\mobile\\special properties.txt"));
        File mobieList = new File("E:\\Project\\saved data\\catagories\\digital product\\mobile\\list of products");
        mobieList.createNewFile();
        File laptop = new File("E:\\Project\\saved data\\catagories\\digital product\\laptop");
        laptop.mkdir();
        BufferedWriter laptopSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\digital product\\laptop\\special properties.txt"));
        File laptopList = new File("E:\\Project\\saved data\\catagories\\digital product\\laptop\\list of products");
        laptopList.mkdir();
        File homeAppliances = new File("E:\\Project\\saved data\\catagories\\home appliances");
        homeAppliances.mkdir();
        File refrigerator = new File("E:\\Project\\saved data\\catagories\\home appliances\\refrigerator");
        refrigerator.mkdir();
        BufferedWriter refrigeratorSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\home appliances\\refrigerator\\special properties.txt"));
        File refrigeratorList = new File("E:\\Project\\saved data\\catagories\\home appliances\\refrigerator\\list of products");
        refrigeratorList.mkdir();
        File cooker = new File("E:\\Project\\saved data\\catagories\\home appliances\\cooker");
        cooker.mkdir();
        BufferedWriter cookerSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\home appliances\\cooker\\special properties.txt"));
        File cookerList = new File("E:\\Project\\saved data\\catagories\\home appliances\\cooker\\list of products");
        cookerList.mkdir();
        File tv = new File("E:\\Project\\saved data\\catagories\\home appliances\\tv");
        tv.mkdir();
        BufferedWriter tvSpecialProperties = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\catagories\\home appliances\\tv\\special properties.txt"));
        File tvList = new File("E:\\Project\\saved data\\catagories\\home appliances\\tv\\list of products");
        tvList.mkdir();

        File admin = new File("E:\\Project\\saved data\\users\\admin");
        admin.mkdir();
        BufferedWriter adminInformation = new BufferedWriter(new FileWriter("E:\\Project\\saved data\\users\\admin\\information.txt"));
        File listOfRequests = new File("E:\\Project\\saved data\\users\\admin\\list of requests.txt");
        listOfRequests.createNewFile();

        File customers = new File("E:\\Project\\saved data\\users\\customers");
        customers.mkdir();
        numberOfCustomers= new File("E:\\Project\\saved data\\users\\customers\\number of customers.txt");
        numberOfCustomers.createNewFile();
        fw_numberOFCustomers =  new FileWriter (numberOfCustomers,true);
        fr_numberOFCustomers = new FileReader(numberOfCustomers);

        File sellers = new File("E:\\Project\\saved data\\users\\sellers");
        sellers.mkdir();
        numberOfSellers = new File("E:\\Project\\saved data\\users\\sellers\\number of sellers.txt");
        numberOfSellers.createNewFile();
        fw_numberOFSellers =  new FileWriter (numberOfSellers,true);
        fr_numberOFSellers = new FileReader(numberOfSellers);
    }

}
