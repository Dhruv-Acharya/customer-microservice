package com.lelo.customermicroservice.controller;


import com.lelo.customermicroservice.dto.CustomerDTO;
import com.lelo.customermicroservice.dto.CustomerResponseDTO;
import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.service.impl.CustomerServiceImpl;
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
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ResponseEntity<CustomerResponseDTO> loginCustomer(@RequestBody CustomerDTO customerDTO){
        String email = customerDTO.getEmail();
        String password = customerDTO.getPassword();
        if(customerService.login(email, password) == null) {
            return new ResponseEntity<>(new CustomerResponseDTO(),HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<CustomerResponseDTO>(customerService.login(email, password),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getCustomerName/{customerId}", method = RequestMethod.GET)
        public ResponseEntity<String> getCustomerName(@PathVariable String customerId){
            return new ResponseEntity<String>(customerService.getCustomerName(customerId), HttpStatus.OK);
        }

    @RequestMapping(value = "/get/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable String customerId) {
        return new ResponseEntity<String>(customerService.getEmail(customerId), HttpStatus.OK);
    }


}
