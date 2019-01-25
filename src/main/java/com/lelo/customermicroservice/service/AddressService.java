package com.lelo.customermicroservice.service;

import com.lelo.customermicroservice.entity.Address;
import com.lelo.customermicroservice.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    Address add(Address address);
    List<Address> getAllAddress(Customer customer);
    void delete(String addressId);
}
