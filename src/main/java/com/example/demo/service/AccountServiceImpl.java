package com.example.demo.service;

import com.example.demo.exception.NoAccountFoundException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public List<Account> getAllUsers() {
        return accountRepository.findAllByEnabledTrue();
    }
}
