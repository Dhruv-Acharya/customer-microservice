package com.lelo.customermicroservice.Repository;


import com.lelo.customermicroservice.entity.Customer;
import com.lelo.customermicroservice.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestCustomerRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void testFindByEmail(){
        Customer customer=new Customer();
        customer.setCustomerId("djbjwsjdbj");
        customer.setName("haritha");
        customer.setEmail("haritha.kishore2@gmail.com");
        customer.setPassword("rhkhsF");
//        customer.setPhone("75982476");
        customerRepository.save(customer);
        Assert.assertNotNull(customerRepository.findByEmail("haritha.kishore2@gmail.com"));

    }


    @Test
    @Transactional
    @Rollback(true)
    public void testFindByCustomerId(){
        Customer customer=new Customer();
        customer.setCustomerId("djbjwsjdbjbbbb");
       customer.setName("hari");
        customer.setEmail("haritha2@gmail.com");
        customer.setPassword("rhkhsF");
//        customer.setPhone("75982476");
        customerRepository.save(customer);
        Assert.assertNull(customerRepository.findOne(customer.getCustomerId()));

    }


    @Test
    @Transactional
    @Rollback(true)
    public void testFindEmailByCustomerId(){
        Customer customer=new Customer();
        customer.setCustomerId("djbjwsj");
        customer.setName("haritha");
        customer.setEmail("haritha.kishore2@gmail.com");
        customer.setPassword("rhkhsF");
//        customer.setPhone("75982476");
        customerRepository.save(customer);
        Assert.assertNull(customerRepository.findEmailByCustomerId("djbjwsj"));

    }




}
