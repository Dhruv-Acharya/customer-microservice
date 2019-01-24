package com.lelo.customermicroservice.service;

import com.lelo.customermicroservice.entity.Address;

import java.util.List;

public interface AddressService {

    Address add(Address address);
    List<Address> getAllAddress(String customerId);
    void delete(String addressId);
}
