package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;

import java.util.Scanner;

public class ChangeAccountMenu {
    public static void changeMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();

        System.out.println("1. Change your username");
        System.out.println("2. Change your password");

        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                accountController.changeAccountUsername();
            }

            case 2 -> {
                accountController.changeAccountPassword();
            }
        }
    }
}