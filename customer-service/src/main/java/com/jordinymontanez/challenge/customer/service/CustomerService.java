package com.jordinymontanez.challenge.customer.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.jordinymontanez.challenge.customer.dto.CustomerDto;
import com.jordinymontanez.challenge.customer.dto.mapper.CustomerMapper;
import com.jordinymontanez.challenge.customer.dto.response.Response;
import com.jordinymontanez.challenge.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerService {
    public static final String COLLECTION_NAME="Customer";

    @Autowired
    FirebaseInitializer db;

    public List<CustomerDto>  getAllEmployees() throws InterruptedException, ExecutionException {
        List<CustomerDto> customerList = new ArrayList<>();
        CollectionReference customer= db.getFirebase().collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> querySnapshot= customer.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Customer c = doc.toObject(Customer.class);
            customerList.add(CustomerMapper.toCustomerDto(c));
        }
        return customerList;
    }

    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer= CustomerMapper.toCustomer(customerDto);
        CollectionReference customerCreate= db.getFirebase().collection(COLLECTION_NAME);
        customerCreate.document(String.valueOf(customer.getId())).set(customer);

        return CustomerMapper.toCustomerDto(customer);
    }
}
