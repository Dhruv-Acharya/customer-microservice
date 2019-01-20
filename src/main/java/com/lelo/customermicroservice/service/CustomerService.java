package com.lelo.customermicroservice.service;

import com.lelo.customermicroservice.entity.Customer;

public interface CustomerService {

    Customer add(Customer customer);
    String login(String email, String password);
}
