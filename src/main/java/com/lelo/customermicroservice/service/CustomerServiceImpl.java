package com.lelo.customermicroservice.service;

import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.repository.CustomerRepository;
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
        String password=hashingPassword.encryptThisString(customer.getPassword());
        customer.setPassword(password);
        return customerRepository.save(customer);

    }

    @Override
    public String login(String email, String password) {
        Customer pass=customerRepository.findByEmail(email);
        if(pass.getPassword().compareTo(hashingPassword.encryptThisString(password))==0)
            return "Success";
        else
            return "Failure";

    }
}
