package com.epam.controller;

import com.epam.creditcard.BadCoin;
import com.epam.creditcard.Mshm;
import com.epam.creditcard.PayFriend;
import com.epam.domain.Creditcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private Mshm mshm;

    @Autowired
    private BadCoin badCoin;

    @Autowired
    private PayFriend payFriend;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello!";
    }

    @RequestMapping(value = "/mshm", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> payMshm(@RequestBody Creditcard creditcard) {
        return mshm.pay(creditcard);
    }

    @RequestMapping(value = "/badcoin", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> payBadCoin(@RequestBody Creditcard creditcard) {
        return badCoin.pay(creditcard);
    }

    @RequestMapping(value = "/payfriend", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> payPayFriend(@RequestBody Creditcard creditcard) {
        return payFriend.pay(creditcard);
    }
}
