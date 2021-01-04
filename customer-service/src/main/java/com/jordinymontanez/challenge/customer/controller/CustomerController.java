package com.jordinymontanez.challenge.customer.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.jordinymontanez.challenge.customer.dto.CustomerDto;
import com.jordinymontanez.challenge.customer.dto.mapper.CustomerMapper;
import com.jordinymontanez.challenge.customer.dto.response.Response;
import com.jordinymontanez.challenge.customer.model.Customer;
import com.jordinymontanez.challenge.customer.service.CustomerService;
import com.jordinymontanez.challenge.customer.service.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value="")
    public  String param(){
        return "Hello World";
    }

    @GetMapping("/getAllCustomers")
    public Response getAllEmployees() throws InterruptedException, ExecutionException {

        return Response
                .ok()
                .setPayload(customerService.getAllEmployees());
    }

    @PostMapping("/createCustomer")
    public Response createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return Response
                .ok()
                .setPayload(customerService.createCustomer(customerDto));
    }

    @GetMapping("/kpiCustomer")
    public Response kpiCustomer() {
        return Response
                .ok()
                .setPayload(customerService.kpiCustomer());
    }

}
