package DataAccessLayer.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void testGettersAndSetters() {
        Ticket ticket = new Ticket();

        ticket.setTicketId(1);
        assertEquals(1, ticket.getTicketId());

        ticket.setPassengerFirstName("Daniel");
        assertEquals("Daniel", ticket.getPassengerFirstName());

        ticket.setPassengerLastName("Mihalev");
        assertEquals("Mihalev", ticket.getPassengerLastName());

        ticket.setArrivalCityId(2);
        assertEquals(2, ticket.getArrivalCityId());

        ticket.setDepartureCityId(3);
        assertEquals(3, ticket.getDepartureCityId());

        ticket.setAccountId(4);
        assertEquals(4, ticket.getAccountId());

        ticket.setPriceId(5);
        assertEquals(5, ticket.getPriceId());
    }

    @Test
    public void testParameterizedConstructor() {
        Ticket ticket = new Ticket("Daniel", "Mihalev", 6, 7, 8, 9);

        assertEquals(0, ticket.getTicketId());
        assertEquals("Daniel", ticket.getPassengerFirstName());
        assertEquals("Mihalev", ticket.getPassengerLastName());
        assertEquals(6, ticket.getArrivalCityId());
        assertEquals(7, ticket.getDepartureCityId());
        assertEquals(8, ticket.getAccountId());
        assertEquals(9, ticket.getPriceId());
    }

    @Test
    public void testParameterizedConstructorWithId() {
        Ticket ticket = new Ticket(10, "Daniel", "Mihalev", 11, 12, 13, 14);

        assertEquals(10, ticket.getTicketId());
        assertEquals("Daniel", ticket.getPassengerFirstName());
        assertEquals("Mihalev", ticket.getPassengerLastName());
        assertEquals(11, ticket.getArrivalCityId());
        assertEquals(12, ticket.getDepartureCityId());
        assertEquals(13, ticket.getAccountId());
        assertEquals(14, ticket.getPriceId());
    }
}