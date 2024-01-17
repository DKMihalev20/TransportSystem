package PresentationLayer.main;

import PresentationLayer.controller.AccountController;
import utils.connection.DBConnection;
import java.sql.Connection;

public class Main extends Thread {

    private Connection connection;

    public Main() {
        this.connection = DBConnection.getConnection();
    }

    public void dbConnection() {
        if (connection != null) {
            System.out.println("Database connection successful!");
        }
        else {
            System.out.println("Failed to connect to the database.");
        }
    }

    @Override
    public void run() {
        dbConnection();
    }

    public static void main(String[] args) {
        // Establish the database connection
        Main main = new Main();
        main.start();

        try {
            main.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AccountController accountController = new AccountController();
        accountController.getStart();
    }
}