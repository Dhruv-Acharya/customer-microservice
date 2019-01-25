package com.lelo.customermicroservice.Service;

import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.repository.CustomerRepository;
import com.lelo.customermicroservice.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerService {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    public void TestAdd(){

        Customer customer=new Customer();
        customer.setCustomerId("afghkjafgh");
        customer.setName("haritha");
        customer.setEmail("haritha.kishore2@gmail.com");
        customer.setPassword("rhkhsF");

        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);
        Customer customer1=customerService.add(customer);
        Assert.assertNotNull(customer1);

        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
    }


    @Test(expected = NullPointerException.class)
    public void TestLogin_without_email_throw_exception(){


    }

}
