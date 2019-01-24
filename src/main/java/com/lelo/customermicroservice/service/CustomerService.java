package com.lelo.customermicroservice.service;

import com.lelo.customermicroservice.dto.CustomerResponseDTO;
import com.lelo.customermicroservice.entity.Customer;

public interface CustomerService {

    Customer add(Customer customer);
    CustomerResponseDTO login(String email, String password);

    String getCustomerName(String customerId);

    String getEmail(String customerId);
}
