package com.lelo.customermicroservice.service.impl;

import com.lelo.customermicroservice.dto.CustomerResponseDTO;
import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.repository.CustomerRepository;
import com.lelo.customermicroservice.service.CustomerService;
import com.lelo.customermicroservice.utilities.HashingPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {

    HashingPassword hashingPassword=new HashingPassword();
    @Autowired
    CustomerRepository customerRepository;
    @Override
    @Transactional(readOnly = false)
    public Customer add(Customer customer) {
        String password=hashingPassword.encrypt(customer.getPassword());
        customer.setPassword(password);
        return customerRepository.save(customer);

    }

    @Override
    public CustomerResponseDTO login(String email, String password) {
        Customer customer=customerRepository.findByEmail(email);
        if(customer != null && customer.getPassword().compareTo(hashingPassword.encrypt(password))==0){
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            customerResponseDTO.setCustomerId(customer.getCustomerId());
            customerResponseDTO.setName(customer.getName());
            return customerResponseDTO;
        }
        else
            return null;

    }

    @Override
    public String getCustomerName(String customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        return customer.getName();
    }

    @Override
    public String getEmail(String customerId) {
        Customer customer = customerRepository.findEmailByCustomerId(customerId);
        return customer.getEmail();
    }

    @Override
    public Customer findOne(String customerId) {
        return customerRepository.findOne(customerId);
    }
}
