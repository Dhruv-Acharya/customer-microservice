package com.lelo.customermicroservice.controller;


import com.lelo.customermicroservice.dto.AddressDTO;
import com.lelo.customermicroservice.entity.Address;
import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.service.AddressService;
import com.lelo.customermicroservice.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO addressDTO){
        Address address=new Address();
        BeanUtils.copyProperties(addressDTO,address);
        Customer customer = customerService.findOne(addressDTO.getCustomerId());
        address.setCustomer(customer);
        Address addressCreated =addressService.add(address);
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);

    }

    @RequestMapping(value = "/getAllAddress/{customerId}",method = RequestMethod.GET)
    public ResponseEntity<List<Address>> getAllAddress(@PathVariable String customerId){
        Customer customer = customerService.findOne(customerId);
        return new ResponseEntity<>(addressService.getAllAddress(customer), HttpStatus.OK);

    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  ResponseEntity<String> deleteAddress(@RequestBody AddressDTO addressDTO){
        Address address=new Address();
        BeanUtils.copyProperties(addressDTO,address);
        addressService.delete(address.getAddressId());
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);

    }

}
