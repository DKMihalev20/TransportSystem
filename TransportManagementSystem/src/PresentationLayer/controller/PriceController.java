package PresentationLayer.controller;

import BusinessLayer.services.PriceService;
import PresentationLayer.menus.BookTicketMenu;
import java.util.Scanner;

public class PriceController {
    private final PriceService priceService = new PriceService();

    public PriceController() {

    }

    public void getBookTicketMenu() {
        BookTicketMenu.bookTicketMenu();
    }

    public double createPriceMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price: ");

        // Validate if the input is a valid double
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid double for the price.");
            scanner.next();  // Consume the invalid input
        }

        double price = scanner.nextDouble();
        return price;
    }

    public void deletePriceMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the PriceId to delete: ");
        int priceId = scanner.nextInt();

        priceService.deletePrice(priceId);

        System.out.println("Price deleted successfully");
    }
}