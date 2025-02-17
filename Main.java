import View.*;
import Controller.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        UserController userController = new UserController(userView);

        while (true) {
            userView.displayMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            scanner.close();

            switch (option) {
                case 1:
                    userController.login();
                    break;
                case 2:
                    userController.register();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    userView.displayInvalidOption();
            }
        }
        
    }
}
