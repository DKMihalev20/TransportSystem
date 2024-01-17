package PresentationLayer.controller;

import BusinessLayer.services.AccountService;
import PresentationLayer.menus.*;

import java.util.Scanner;

public class AccountController {

    public AccountController() {

    }
    private final AccountService accountService = new AccountService();

    public void getLogin() {
        LoginMenu.loginMenu();
    }

    public void getRegister() {
        RegisterMenu.registerMenu();
    }

    public void getStart() {
        StartMenu.startMenu();
    }

    public void getMain() {
        MainMenu.mainMenu();
    }

    public void getDeleteMenu() {
        DeleteAccountMenu.deleteMenu();
    }

    public void getChangeAccountMenu() {
        ChangeAccountMenu.changeMenu();
    }

    public void loginUserAccount(String username, String password) {
        if(accountService.verifyLoggedAccount(username, password)) {
            System.out.println();
            System.out.println("You have successfully logged in");
            System.out.println();

            getMain();
        }
        else {
            System.out.println("Incorrect username/password. Please try again!");
            getLogin();
        }
    }

    public void registerUser(String firstName, String lastName, String email, String username, String password) {
        accountService.createAccount(firstName, lastName, email, username, password);

        System.out.println();
        System.out.println("You have successfully registered!");
        System.out.println();

        getStart();
    }

    public void changeAccountUsername() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your new username: ");
        String newUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        accountService.updateUsername(newUsername, password);

        System.out.println("Your new account now has a username: " + newUsername);
    }

    public void changeAccountPassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        accountService.updatePassword(newPassword, username);

        System.out.println("Your new account now has a password: " + newPassword);

        getStart();
    }

    public void deleteAccount(String username, String password) {
        accountService.deleteAccount(username, password);

        System.out.println("You have successfully deleted your account.");
        System.out.println();

        getStart();
    }
}