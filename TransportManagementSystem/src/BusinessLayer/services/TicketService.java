package BusinessLayer.services;

import DataAccessLayer.models.Ticket;
import DataAccessLayer.repositories.PriceRepository;
import DataAccessLayer.repositories.TicketRepository;
import PresentationLayer.menus.TicketMenu;

import java.util.List;

public class TicketService {
    private final TicketRepository ticketRepository = new TicketRepository();

    public void getTicketMenu() {
        TicketMenu.ticketMenu();
    }

    public TicketService() {

    }

    public int createTicket(String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId, int accountId, int priceId) {
        return ticketRepository.createTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId, accountId, priceId);
    }

    public int getCityIdByName(String cityName) {
        return ticketRepository.getCityIdByName(cityName);
    }

    public int getPriceIdByPrice(double price) {
        return ticketRepository.getPriceIdByPrice(price);
    }

    public void deleteTicket(String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId) {
        ticketRepository.deleteTicket(passengerFirstName, passengerLastName, arrivalCityId, departureCityId);
    }

    public void viewAllTickets() {
        List<Ticket> ticketList = ticketRepository.getTickets();

        if (ticketList.isEmpty()) {
            System.out.println("No available tickets.");
        }
        else {
            for (Ticket ticket : ticketList) {
                System.out.println("\n| Number of ticket: " + ticket.getTicketId());
                System.out.println("| Passenger's first name: " + ticket.getPassengerFirstName());
                System.out.println("| Passenger's last name: " + ticket.getPassengerLastName());
                System.out.println("| Arrival city: " + CityService.getCityById(ticket.getArrivalCityId()));
                System.out.println("| Departure city: " + CityService.getCityById(ticket.getDepartureCityId()));
                System.out.println("| Price: " + PriceRepository.getPriceById(ticket.getPriceId()));
            }
        }

        System.out.println();
        getTicketMenu();
    }
}