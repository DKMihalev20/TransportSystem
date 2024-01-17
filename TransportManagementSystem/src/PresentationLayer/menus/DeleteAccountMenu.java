package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;

import java.util.Scanner;

public class DeleteAccountMenu {
    public static void deleteMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();

        System.out.print("Enter your username: ");
        String username;
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password;
        password = scanner.nextLine();

        accountController.deleteAccount(username, password);
    }
}
