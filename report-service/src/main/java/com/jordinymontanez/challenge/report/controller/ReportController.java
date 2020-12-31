package com.jordinymontanez.challenge.report.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    @GetMapping(value="")
    public  String param(){
        return "Hello World - Reports";
    }



}
