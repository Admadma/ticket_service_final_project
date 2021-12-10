package com.epam.training.ticketservice.services.accounts;

public interface AccountServiceInterface {

    void addUser(String username, String password, boolean privileged);

    Account signIn(String username, String password);

    Account findAccountByUsername(String username);
}
