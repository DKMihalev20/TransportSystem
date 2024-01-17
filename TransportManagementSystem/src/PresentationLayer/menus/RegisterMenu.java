package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;
import java.util.Scanner;

public class RegisterMenu {
    public static void registerMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();

        System.out.print("Enter your first name: ");
        String firstName;
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName;
        lastName = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email;
        email = scanner.nextLine();

        System.out.print("Enter your username: ");
        String username;
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password;
        password = scanner.nextLine();

        accountController.registerUser(firstName, lastName, email, username, password);
    }
}
