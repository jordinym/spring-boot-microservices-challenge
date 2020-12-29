package com.jordinymontanez.challenge.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @GetMapping(value="")
    public  String param(){
        return "Hello World";
    }

}
