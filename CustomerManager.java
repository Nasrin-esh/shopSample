package UserAccounts;

import java.util.ArrayList;

public class CustomerManager
{
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    //-------------------------------
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    public static void setCustomers(ArrayList<Customer> customers) {
        CustomerManager.customers = customers;}
    //----------------------------------
    static void registerCustomer(Customer customer)
    {
        customers.add(customer);
    }

}
