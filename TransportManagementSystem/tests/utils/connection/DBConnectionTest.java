package utils.connection;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    @Test
    public void testGetConnection() {
        Connection connection = DBConnection.getConnection();

        assertNotNull("Connection should not be null", connection);

        try {
            assertFalse("Connection should be open", connection.isClosed());
        }
        catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }

        DBConnection.disconnect();
    }

    @Test
    public void testDisconnect() {
        Connection connection = DBConnection.getConnection();

        try {
            assertFalse("Connection should be open before disconnect", connection.isClosed());
        }
        catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }

        DBConnection.disconnect();

        try {
            assertTrue("Connection should be closed after disconnect", connection.isClosed());
        }
        catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }
    }
}