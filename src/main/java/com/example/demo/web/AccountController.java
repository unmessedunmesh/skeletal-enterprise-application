package com.example.demo.web;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AccountController {


    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/api/accounts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Account>> getAccounts() {
        logger.info("> getAccount");

        final Collection<Account> greetings = accountService.getAllUsers();

        logger.info("< getAccount");
        return new ResponseEntity<Collection<Account>>(greetings, HttpStatus.OK);
    }
}
