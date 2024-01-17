package DataAccessLayer.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    @Test
    public void testGettersAndSetters() {
        City city = new City();

        city.setCityId(1);
        assertEquals(1, city.getCityId());

        city.setCityName("New York");
        assertEquals("New York", city.getCityName());
    }

    @Test
    public void testParameterizedConstructor() {
        City city = new City("London");

        assertEquals(0, city.getCityId());
        assertEquals("London", city.getCityName());
    }

    @Test
    public void testParameterizedConstructorWithId() {
        City city = new City(1, "Paris");

        assertEquals(1, city.getCityId());
        assertEquals("Paris", city.getCityName());
    }
}
