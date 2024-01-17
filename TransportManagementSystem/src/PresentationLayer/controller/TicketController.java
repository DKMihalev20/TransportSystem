package PresentationLayer.controller;

import BusinessLayer.services.TicketService;
import PresentationLayer.menus.TicketMenu;
import java.util.Scanner;

public class TicketController {
    private final TicketService ticketService = new TicketService();
    private final PriceController priceController = new PriceController();

    public TicketController() {

    }

    public void getTicketMenu() {
        TicketMenu.ticketMenu();
    }
    public void createTicketMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter passenger's first name: ");
        String passengerFirstName = scanner.nextLine();

        System.out.print("Enter passenger's last name: ");
        String passengerLastName = scanner.nextLine();

        System.out.print("Enter arrival city name: ");
        String arrivalCityName = scanner.nextLine();
        int arrivalCityId = ticketService.getCityIdByName(arrivalCityName);

        System.out.print("Enter departure city name: ");
        String departureCityName = scanner.nextLine();
        int departureCityId = ticketService.getCityIdByName(departureCityName);

        // Invoke the createPriceMenu from the priceController to get the price
        double price = priceController.createPriceMenu();

        // Get the priceId based on the entered price
        int priceId = ticketService.getPriceIdByPrice(price);

        int ticketId = ticketService.createTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId, priceId);

        System.out.println("Ticket created successfully with ID: " + ticketId);
    }


    public void deleteTicketMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter passenger's first name: ");
        String passengerFirstName = scanner.nextLine();

        System.out.print("Enter passenger's last name: ");
        String passengerLastName = scanner.nextLine();

        System.out.print("Enter arrival city name: ");
        String arrivalCityName = scanner.nextLine();
        int arrivalCityId = ticketService.getCityIdByName(arrivalCityName);

        System.out.print("Enter departure city name: ");
        String departureCityName = scanner.nextLine();
        int departureCityId = ticketService.getCityIdByName(departureCityName);

        priceController.deletePriceMenu();

        ticketService.deleteTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId);

        System.out.println("Ticket deleted successfully");
    }

    public void viewAllAvailableTickets() {
        ticketService.viewAllAvailableTickets();
    }
}