package com.jordinymontanez.challenge.customer.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.jordinymontanez.challenge.customer.common.util.DesviacionEstandarUtils;
import com.jordinymontanez.challenge.customer.dto.CustomerDto;
import com.jordinymontanez.challenge.customer.dto.CustomerKpiDto;
import com.jordinymontanez.challenge.customer.dto.mapper.CustomerMapper;
import com.jordinymontanez.challenge.customer.dto.response.Response;
import com.jordinymontanez.challenge.customer.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    public static final String COLLECTION_NAME="Customer";

    //@Autowired
    private final FirebaseInitializer db;

    @Override
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

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer= CustomerMapper.toCustomer(customerDto);
        CollectionReference customerCreate= db.getFirebase().collection(COLLECTION_NAME);
        customerCreate.document(String.valueOf(customer.getId())).set(customer);

        return CustomerMapper.toCustomerDto(customer);
    }

    @Override
    public CustomerKpiDto kpiCustomer() {
        List<CustomerDto> list=new ArrayList<>();
        try {
            list=getAllEmployees();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        CustomerKpiDto customerKpiDto=CustomerKpiDto.builder()
                .average(0.0)
                .standardDeviation(0.0)
                .build();
        if(!list.isEmpty()){
            customerKpiDto.setAverage(list.stream().mapToInt(i->i.getAge()).average().orElse(Double.NaN));
            customerKpiDto.setStandardDeviation(DesviacionEstandarUtils.calculate(list.stream().map(i->i.getAge()).toArray(Integer[]::new)));
        }

        return customerKpiDto;
    }
}
