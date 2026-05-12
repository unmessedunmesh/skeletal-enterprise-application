package com.example.demo.web;

import com.example.demo.model.Account;
import com.example.demo.model.RFP;
import com.example.demo.service.AccountService;
import com.example.demo.service.RFPServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class AccountController {


    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


    private final AccountService accountService;

    private final RFPServiceImpl rfpService;

    public AccountController(AccountService accountService, RFPServiceImpl rfpService) {
        this.accountService = accountService;
        this.rfpService = rfpService;
    }


    @RequestMapping(value = "/api/accounts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Account>> getAccounts() {
        logger.info("> getAccount");

        final Collection<Account> greetings = accountService.getAllUsers();

        logger.info("< getAccount");
        return new ResponseEntity<Collection<Account>>(greetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/rfp",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<RFP>> getRFPs() {
        logger.info("> getAccount");

        final Collection<RFP> greetings = rfpService.findAll();

        logger.info("< getAccount");
        return new ResponseEntity<Collection<RFP>>(greetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/rfp",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Collection<RFP>> saveRFPs(@RequestBody List<RFP> rfp) {
        logger.info("> getAccount");

        final Collection<RFP> greetings = rfpService.saveAll(rfp);

        logger.info("< getAccount");
        return new ResponseEntity<Collection<RFP>>(greetings, HttpStatus.OK);
    }
}
