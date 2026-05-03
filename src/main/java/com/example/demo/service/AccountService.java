package com.example.demo.service;


import com.example.demo.model.Account;

import java.util.List;

public interface AccountService {


    /**
     * Find an Account by the username attribute value.
     *
     * @param username A String username to query the repository.
     * @return An Account instance or <code>null</code> if none found.
     */
    Account findByUsername(String username);

    List<Account> getAllUsers();
}
