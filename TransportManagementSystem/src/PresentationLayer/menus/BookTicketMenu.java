package PresentationLayer.menus;

import java.util.Scanner;
import PresentationLayer.controller.TicketController;

public class BookTicketMenu {
    public static void bookTicketMenu() {
        Scanner scanner = new Scanner(System.in);
        TicketController ticketController = new TicketController();

        System.out.println("1. Book ticket");
        System.out.println("2. Delete ticket");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                ticketController.createTicketMenu();
            }

            case 2 -> {
                ticketController.deleteTicketMenu();
            }

            case 3 -> {
                ticketController.getTicketMenu();
            }
        }
    }
}