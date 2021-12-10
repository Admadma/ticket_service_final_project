package com.epam.training.ticketservice.services.accounts;

import com.epam.training.ticketservice.services.accounts.Account;
import com.epam.training.ticketservice.services.accounts.AccountRepository;
import com.epam.training.ticketservice.services.accounts.AccountServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountServiceInterface{

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addUser(String username, String password, boolean privileged) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setPrivileged(privileged);
        accountRepository.save(account);
    }

    @Override
    public Account signIn(String username, String password) {
        Account account = findAccountByUsername(username);
        if (password.equals(account.getPassword()))
            return account;
        else return null;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
