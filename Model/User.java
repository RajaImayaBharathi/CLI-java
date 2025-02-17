package Model;

public class User {
    String username;
    String password;
    String phoneNumber;
    String address;
    boolean isAdmin;

    User(String username, String password, String phoneNumber, String address, boolean isAdmin){
        this.username=username;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.isAdmin=isAdmin;
    }
}
