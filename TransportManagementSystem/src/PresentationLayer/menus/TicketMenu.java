package PresentationLayer.menus;

import PresentationLayer.controller.CityController;
import PresentationLayer.controller.PriceController;
import PresentationLayer.controller.TicketController;

import java.util.Scanner;

public class TicketMenu {
    public static void ticketMenu() {
        Scanner scanner = new Scanner(System.in);
        CityController cityController = new CityController();
        TicketController ticketController = new TicketController();
        PriceController priceController = new PriceController();

        System.out.println();
        System.out.println("1. View all booked tickets");
        System.out.println("2. Book a ticket");
        System.out.println("3. Back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                ticketController.viewAllTickets();
            }

            case 2 -> {
                priceController.getBookTicketMenu();
            }

            case 3 -> {
                cityController.getServicesMenu();
            }
        }
    }
}