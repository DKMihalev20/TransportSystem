package DataAccessLayer.repositories;

import DataAccessLayer.models.Account;
import utils.connection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.connection.DBConnection.getConnection;

public class AccountRepository {

    public AccountRepository() {

    }

    // Method to create a new account in the database
    public void addAccount(Account account) {
        // SQL query to insert a new account
        String query = "INSERT INTO Accounts " +
                       "(FirstName, LastName, Email, Username, Password) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getUsername());
            preparedStatement.setString(5, account.getPassword());

            // Execute the query
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            // Handle SQL exceptions by wrapping and rethrowing as a runtime exception
            throw new RuntimeException(sqlException);
        }
    }

    public List<Account> getAccountByUsernameAndPassword() {
        List<Account> accounts = new ArrayList<>();

        String query = "SELECT Username, Password " +
                       "FROM Accounts";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the ResultSet to populate Account objects and add them to the list
            while (resultSet.next()) {
                Account account = new Account();

                // Set only the Username and Password properties from the ResultSet
                account.setUsername(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));

                // Add the populated Account instance to the list
                accounts.add(account);
            }
        } catch (SQLException sqlException) {
            // Handle SQL exceptions by wrapping and rethrowing as a runtime exception
            throw new RuntimeException(sqlException);
        }
        return accounts;
    }

    public void updateUsername(String newUsername, String password) {
        String query = "UPDATE Accounts " +
                       "SET Username = ? " +
                       "WHERE Password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, password);

            // Execute the query
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public void updatePassword(String newPassword, String username) {
        String query = "UPDATE Accounts " +
                       "SET Password = ? " +
                       "WHERE Username = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            // Execute the query
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }


    // Method to delete an account from the database
    public void deleteAccount(String username, String password) {
        // SQL query to delete an account by username and password
        String query = "DELETE FROM Accounts " +
                       "WHERE Username = ? " +
                       "AND Password = ?";


        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameter for the PreparedStatement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the query
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            // Handle SQL exceptions by wrapping and rethrowing as a runtime exception
            throw new RuntimeException(sqlException);
        }
    }
}