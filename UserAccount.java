package UserAccounts;

public class UserAccount
{
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String password;
    private String role;
    //---------------------------constructor-----------------
    UserAccount(String userName,String firstName,String lastName,String email,int phoneNumber,String password, String role)
    {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
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

    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
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


