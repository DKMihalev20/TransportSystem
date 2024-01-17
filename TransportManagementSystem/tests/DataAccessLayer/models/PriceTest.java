package DataAccessLayer.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {
    @Test
    public void testGettersAndSetters() {
        Price price = new Price();

        price.setPriceId(1);
        assertEquals(1, price.getPriceId());

        price.setPrice(10.01);

        // Using delta for double comparison
        assertEquals(10.01, price.getPrice(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        Price price = new Price(49.99);

        assertEquals(0, price.getPriceId());

        // Using delta for double comparison
        assertEquals(49.99, price.getPrice(), 0.001);
    }

    @Test
    public void testParameterizedConstructorWithId() {
        Price price = new Price(2, 69.96);

        assertEquals(2, price.getPriceId());

        // Using delta for double comparison
        assertEquals(69.96, price.getPrice(), 0.001);
    }
}