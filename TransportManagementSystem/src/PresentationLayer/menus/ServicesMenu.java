package PresentationLayer.menus;

import PresentationLayer.controller.AccountController;
import PresentationLayer.controller.CityController;
import PresentationLayer.controller.TicketController;

import java.util.Scanner;

public class ServicesMenu {
    public static void servicesMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();
        CityController cityController = new CityController();
        TicketController ticketController = new TicketController();

        System.out.println();
        System.out.println("1. View all possible cities");
        System.out.println("2. Tickets");
        System.out.println("3. Back");

        System.out.print("Enter a choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                cityController.viewAllCities();
            }

            case 2 -> {
                cityController.getTicketMenu();
            }

            case 3 -> {
                accountController.getMain();
            }
        }

    }

}