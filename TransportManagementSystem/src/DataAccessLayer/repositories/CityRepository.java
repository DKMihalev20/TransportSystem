package DataAccessLayer.repositories;

import DataAccessLayer.models.City;
import utils.connection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    public CityRepository() {

    }

    // Method to retrieve all cities from the database
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();

        String query = "SELECT * FROM Cities";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the ResultSet to populate City objects and add them to the list
            while (resultSet.next()) {
                City city = new City();

                // Set City properties from the ResultSet
                city.setCityId(resultSet.getInt(1));
                city.setCityName(resultSet.getString(2));

                // Add the populated City instance to the list
                cities.add(city);
            }
        } catch (SQLException sqlException) {
            // Handle SQL exceptions by wrapping and rethrowing as a runtime exception
            throw new RuntimeException(sqlException);
        }
        return cities;
    }

    public static City getCityById(int cityId) {
        City city = null;
        String query = "SELECT * " +
                       "FROM Cities " +
                       "WHERE CityId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameter for the PreparedStatement
            preparedStatement.setInt(1, cityId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if a city with the given ID exists
                if (resultSet.next()) {
                    city = new City();
                    // Set City properties from the ResultSet
                    city.setCityId(resultSet.getInt(1));
                    city.setCityName(resultSet.getString(2));
                }
            }

        } catch (SQLException sqlException) {
            // Handle SQL exceptions by wrapping and rethrowing as a runtime exception
            throw new RuntimeException(sqlException);
        }
        return city;
    }
}