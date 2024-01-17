package PresentationLayer.controller;

import BusinessLayer.services.AccountService;
import BusinessLayer.services.TicketService;
import DataAccessLayer.models.Account;
import PresentationLayer.menus.BookTicketMenu;
import PresentationLayer.menus.TicketMenu;
import java.util.Scanner;

public class TicketController {
    private final TicketService ticketService = new TicketService();
    private final PriceController priceController = new PriceController();
    private final AccountService accountService = new AccountService();

    public TicketController() {

    }

    public void getBookTicketMenu() {
        BookTicketMenu.bookTicketMenu();
    }

    public void getTicketMenu() {
        TicketMenu.ticketMenu();
    }

    public void viewAllTickets() {
        ticketService.viewAllTickets();
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

        Account account = accountService.getAccountByFirstNameAndLastName(passengerFirstName, passengerLastName);
        int accountId = account.getId();

        int ticketId = ticketService.createTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId, accountId, priceId);

        System.out.println();
        System.out.println("Ticket created successfully with ID: " + ticketId);

        System.out.println();
        getBookTicketMenu();
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

        ticketService.deleteTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId);

        System.out.println();
        System.out.println("Ticket deleted successfully");

        System.out.println();
        getBookTicketMenu();
    }
}