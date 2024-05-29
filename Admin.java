package UserAccounts;
import Comment.*;
import Products.*;


import java.util.ArrayList;

public class Admin extends UserAccount
{
    private static Admin admin;
    private static ArrayList<Comment> commentRequests = new ArrayList<>();
    private static ArrayList<Seller> sellerRequests = new ArrayList<>();
    private static ArrayList<EditRequest> editRequests = new ArrayList<>();
    private static ArrayList<Product> addRequest = new ArrayList<>();
    private static ArrayList<Product> removeRequest = new ArrayList<>();
    //--------------------------------
    private Admin(String firstName, String lastName, String email, int phoneNumber)
    {
        super("admin", firstName, lastName, email, phoneNumber, "admin", "admin");
    }
    //------------------------------
    public static Admin getAdmin(String firstName, String lastName, String email, int phoneNumber)
    {
        if (admin == null)
            admin = new Admin(firstName,lastName,email,phoneNumber);
        return admin;
    }

    public static ArrayList<Seller> getWaitingSellers() {
        return sellerRequests;
    }
    public static ArrayList<Product> getAddRequest() {
        return addRequest;
    }
    public static ArrayList<EditRequest> getEditRequest() {
        return editRequests;
    }
    public static ArrayList<Product> getRemoveRequest() {
        return removeRequest;
    }
    public static ArrayList<Comment> getCommentRequests() {
        return commentRequests;
    }
}
