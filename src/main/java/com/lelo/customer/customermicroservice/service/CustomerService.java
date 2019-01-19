package com.lelo.customer.customermicroservice.service;

import com.lelo.customer.customermicroservice.entity.Customer;

public interface CustomerService {

    Customer add(Customer customer);
    String login(String email, String password);
}
