package Model;

public class User {
    public String username;
    public String password;
    public String phoneNumber;
    public String address;
    public boolean isAdmin;

    public User(String username, String password, String phoneNumber, String address, boolean isAdmin){
        this.username=username;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.isAdmin=isAdmin;
    }
}
