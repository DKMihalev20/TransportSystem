package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;
import utils.connection.DBConnection;

import java.util.Scanner;

public class StartMenu {
    public static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();

        System.out.println();
        System.out.println("   Welcome to Koncord Transport Inc.");
        System.out.println();
        System.out.println("+-----------------------------------+");
        System.out.println("|           1. Login                |");
        System.out.println("|                                   |");
        System.out.println("|           2. Register             |");
        System.out.println("|                                   |");
        System.out.println("|           3. Exit                 |");
        System.out.println("+-----------------------------------+");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                accountController.getLogin();
                break;
            }

            case 2 -> {
                accountController.getRegister();
                break;
            }

            case 3 -> {
                System.out.println();
                System.out.println("Thank you for cooperating with us. Have a great day!");
                System.exit(0);
                DBConnection.disconnect();
                break;
            }

            default -> {
                System.out.println("Incorrect input. Please try again with your choice.");
                break;
            }
        }
    }
}