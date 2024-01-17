package DataAccessLayer.repositories;

import DataAccessLayer.models.Ticket;
import utils.connection.DBConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    public TicketRepository() {

    }

    // Method to create a new ticket and get the generated ticketId
    public int createTicket(String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId, int accountId, int priceId) {
        String query = "INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, passengerFirstName);
            preparedStatement.setString(2, passengerLastName);
            preparedStatement.setInt(3, arrivalCityId);
            preparedStatement.setInt(4, departureCityId);
            preparedStatement.setInt(5, accountId);
            preparedStatement.setInt(6, priceId);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating ticket failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated ticketId
                } else {
                    throw new SQLException("Creating ticket failed, no ID obtained.");
                }
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();

        String query = "SELECT * FROM Tickets";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketId(resultSet.getInt(1));
                ticket.setPassengerFirstName(resultSet.getString(2));
                ticket.setPassengerLastName(resultSet.getString(3));
                ticket.setArrivalCityId(resultSet.getInt(4));
                ticket.setDepartureCityId(resultSet.getInt(5));
                ticket.setAccountId(resultSet.getInt(6));
                ticket.setPriceId(resultSet.getInt(7));

                tickets.add(ticket);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

        return tickets;
    }

    // Method to get the city ID by name
    public int getCityIdByName(String cityName) {
        String query = "SELECT CityId " +
                       "FROM Cities " +
                       "WHERE CityName = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cityName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        throw new RuntimeException("CityId not found");
    }

    public int getPriceIdByPrice(double price) {
        String query = "SELECT PriceId " +
                       "FROM Prices " +
                       "WHERE Price = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, price);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                else {
                    // Handle the case where no PriceId is found
                    return -1;
                }
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    // Method to delete a ticket
    public void deleteTicket(String passengerFirstName, String passengerLastName, int arrivalCityId, int departureCityId) {
        String query = "DELETE FROM Tickets " +
                       "WHERE PassengerFirstName = ? " +
                       "AND PassengerLastName = ? " +
                       "AND ArrivalCityId = ? " +
                       "AND DepartureCityId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, passengerFirstName);
            preparedStatement.setString(2, passengerLastName);
            preparedStatement.setInt(3, arrivalCityId);
            preparedStatement.setInt(4, departureCityId);

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}