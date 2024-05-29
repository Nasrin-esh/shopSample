package UserAccounts;

public class AdminManager
{
    void removeUser(String userName)
    {
        for (int i = 0; i< SellerManager.getSellers().size(); i++)
            if (userName.equals(SellerManager.getSellers().get(i).getUserName()))
                SellerManager.getSellers().remove(SellerManager.getSellers().get(i));

        for (int i = 0; i< CustomerManager.getCustomers().size(); i++)
            if (userName.equals(CustomerManager.getCustomers().get(i).getUserName()))
                CustomerManager.getCustomers().remove(CustomerManager.getCustomers().get(i));
    }
}
