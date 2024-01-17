package BusinessLayer.services;

import DataAccessLayer.models.Account;
import DataAccessLayer.repositories.AccountRepository;
import java.util.List;
import java.util.Objects;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();

    public void createAccount(String firstName, String lastName, String email, String username, String password) {
        Account account = new Account(firstName, lastName, email, username, password);

        accountRepository.addAccount(account);
    }

    public Account getAccountByFirstNameAndLastName(String firstName, String lastName) {
        return accountRepository.getAccountByFirstNameAndLastName(firstName, lastName);
    }

    public List<Account> getAllAccountsByUsernameAndPassword() {
        return accountRepository.getAccountByUsernameAndPassword();
    }

    public void updateUsername(String newUsername, String password) {
        accountRepository.updateUsername(newUsername, password);
    }

    public void updatePassword(String newPassword, String username) {
        accountRepository.updatePassword(newPassword, username);
    }

    public void deleteAccount(String username, String password) {
        accountRepository.deleteAccount(username, password);
    }

    public boolean verifyLoggedAccount(String username, String password){
        List<Account> accountList = getAllAccountsByUsernameAndPassword();

        for (Account account : accountList) {
            if(Objects.equals(account.getUsername(), username) &&
                    Objects.equals(account.getPassword(), password)) {
                return true;
            }
        }
        return false;
    }
}