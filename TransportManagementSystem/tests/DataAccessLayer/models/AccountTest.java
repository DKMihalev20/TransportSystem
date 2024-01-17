package DataAccessLayer.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testGettersAndSetters() {
        Account account = new Account();

        account.setId(1);
        assertEquals(1, account.getId());

        account.setFirstName("Daniel");
        assertEquals("Daniel", account.getFirstName());

        account.setLastName("Mihalev");
        assertEquals("Mihalev", account.getLastName());

        account.setEmail("DMihalev@example.com");
        assertEquals("DMihalev@example.com", account.getEmail());

        account.setUsername("DanielMihalev");
        assertEquals("DanielMihalev", account.getUsername());

        account.setPassword("password123");
        assertEquals("password123", account.getPassword());
    }

    @Test
    public void testParameterizedConstructor() {
        Account account = new Account("Daniel", "Mihalev", "DMihalev@example.com", "DanielMihalev", "password123");

        assertEquals("Daniel", account.getFirstName());
        assertEquals("Mihalev", account.getLastName());
        assertEquals("DMihalev@example.com", account.getEmail());
        assertEquals("DanielMihalev", account.getUsername());
        assertEquals("password123", account.getPassword());
    }

    @Test
    public void testParameterizedConstructorWithId() {
        Account account = new Account(1, "Daniel", "Mihalev", "DMihalev@example.com", "DanielMihalev", "password123");

        assertEquals(1, account.getId());
        assertEquals("Daniel", account.getFirstName());
        assertEquals("Mihalev", account.getLastName());
        assertEquals("DMihalev@example.com", account.getEmail());
        assertEquals("DanielMihalev", account.getUsername());
        assertEquals("password123", account.getPassword());
    }
}