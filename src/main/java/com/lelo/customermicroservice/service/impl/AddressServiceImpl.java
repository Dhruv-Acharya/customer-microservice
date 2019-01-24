package com.lelo.customermicroservice.service.impl;

import com.lelo.customermicroservice.entity.Address;
import com.lelo.customermicroservice.repository.AddressRepository;
import com.lelo.customermicroservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress(String customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    @Override
    public void delete(String addressId) {
        Address address=addressRepository.findOne(addressId);
        addressRepository.delete(address);
    }


}
