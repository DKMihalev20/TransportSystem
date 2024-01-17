package utils.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public DBConnection() {

    }

    public static Connection getConnection() {
        try {
            String connectionURL = "jdbc:sqlserver://transportsystem.database.windows.net:1433;database=TransportSystemDB;user=DKMihalev20@transportsystem;password=Qug60912;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(connectionURL);

            return connection;
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}