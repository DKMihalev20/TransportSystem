package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;
import PresentationLayer.controller.CityController;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() {
        Scanner scanner =  new Scanner(System.in);
        AccountController accountController = new AccountController();
        CityController cityController = new CityController();

        System.out.println();
        System.out.println("               Main menu             ");
        System.out.println("+-----------------------------------+");
        System.out.println("|           1. Services             |");
        System.out.println("|                                   |");
        System.out.println("|           2. Delete account       |");
        System.out.println("|                                   |");
        System.out.println("|           3. Change Account       |");
        System.out.println("|                                   |");
        System.out.println("|           4. Log out              |");
        System.out.println("+-----------------------------------+");

        System.out.print("Enter a choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                cityController.getServicesMenu();
            }

            case 2 -> {
                accountController.getDeleteMenu();
                break;
            }

            case 3 -> {
                accountController.getChangeAccountMenu();
                break;
            }

            case 4 -> {
                accountController.getStart();
                break;
            }
        }
    }
}