package DataAccessLayer.repositories;

import utils.connection.DBConnection;
import java.sql.*;

public class PriceRepository {

    public PriceRepository() {

    }

    // Method to create a new price
    public void createPrice(double price) {
        String query = "INSERT INTO Prices (Price) " +
                       "VALUES (?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, price);

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static double getPriceById(int priceId) {
        if (priceId <= 0) {
            // Handle the case where PriceId is not valid
            throw new IllegalArgumentException("Invalid PriceId");
        }

        String query = "SELECT Price " +
                       "FROM Prices " +
                       "WHERE PriceId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, priceId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(1);
                }
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        throw new RuntimeException("Price with ID " + priceId + " not found");
    }

    // Method to delete a price for a ticket
    public void deletePrice(int priceId) {
        String query = "DELETE FROM Prices " +
                       "WHERE PriceId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, priceId);

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}