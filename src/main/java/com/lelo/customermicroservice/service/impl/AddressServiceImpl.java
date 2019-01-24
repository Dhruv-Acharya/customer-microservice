package com.lelo.customermicroservice.service.impl;

import com.lelo.customermicroservice.entity.Address;
import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.repository.AddressRepository;
import com.lelo.customermicroservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress(Customer customer) {
        return addressRepository.findByCustomer(customer);
    }

    @Override
    public void delete(String addressId) {
        Address address=addressRepository.findOne(addressId);
        addressRepository.delete(address);
    }


}
