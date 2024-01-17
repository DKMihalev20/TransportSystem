package DataAccessLayer.repositories;

import DataAccessLayer.models.Account;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryTest {
    @Test
    public void testAddAccount() {
        AccountRepository accountRepository = new AccountRepository();

        // Create a test account
        Account testAccount = new Account("Daniel", "Mihalev", "dkmihalev@example.com", "dkmihalev", "password123");

        // Add the account to the repository
        accountRepository.addAccount(testAccount);

        // Now try to retrieve the account from the repository
        List<Account> accounts = accountRepository.getAccountByUsernameAndPassword();

        // Assert that the account is present in the repository
        assertTrue(accounts.contains(testAccount));
    }

    @Test
    public void testUpdateUsername() {
        AccountRepository accountRepository = new AccountRepository();

        // Create a test account
        Account testAccount = new Account("Jane", "Smith", "jane.smith@example.com", "janesmith", "password");

        // Add the account to the repository
        accountRepository.addAccount(testAccount);

        // Update the username for the test account
        accountRepository.updateUsername("newUsername", "password");

        // Now try to retrieve the updated account from the repository
        List<Account> accounts = accountRepository.getAccountByUsernameAndPassword();

        // Assert that the account with the new username is present in the repository
        assertTrue(accounts.stream().anyMatch(account -> account.getUsername().equals("newUsername")));
    }

    @Test
    public void testUpdatePassword() {
        AccountRepository accountRepository = new AccountRepository();

        // Create a test account
        Account testAccount = new Account("Bob", "Johnson", "bob.johnson@example.com", "bobjohnson", "oldPassword");

        // Add the account to the repository
        accountRepository.addAccount(testAccount);

        // Update the password for the test account
        accountRepository.updatePassword("newPassword", "bobjohnson");

        // Now try to retrieve the updated account from the repository
        List<Account> accounts = accountRepository.getAccountByUsernameAndPassword();

        // Assert that the account with the new password is present in the repository
        assertTrue(accounts.stream().anyMatch(account -> account.getPassword().equals("newPassword")));
    }

    @Test
    public void testDeleteAccount() {
        AccountRepository accountRepository = new AccountRepository();

        // Create a test account
        Account testAccount = new Account("Alice", "Johnson", "alice.johnson@example.com", "alicejohnson", "password");

        // Add the account to the repository
        accountRepository.addAccount(testAccount);

        // Delete the account from the repository
        accountRepository.deleteAccount("alicejohnson", "password");

        // Now try to retrieve the deleted account from the repository
        List<Account> accounts = accountRepository.getAccountByUsernameAndPassword();

        // Assert that the account is no longer present in the repository
        assertFalse(accounts.contains(testAccount));
    }
}