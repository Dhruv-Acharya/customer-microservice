package com.lelo.customer.customermicroservice.controller;


import com.lelo.customer.customermicroservice.dto.CustomerDTO;
import com.lelo.customer.customermicroservice.entity.Customer;
import com.lelo.customer.customermicroservice.service.CustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customerDTO)
    {
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        Customer customerCreated=customerService.add(customer);
        String id=customerCreated.getCustomerId();
        String name=customerCreated.getName();
        return new ResponseEntity<String>(id,HttpStatus.CREATED);
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginCustomer(@RequestParam String email, String password){
        return customerService.login(email, password);
    }

}
