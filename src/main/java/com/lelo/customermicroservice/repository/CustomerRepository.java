package com.lelo.customermicroservice.repository;


import com.lelo.customermicroservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

//    @Query(value = "SELECT * FROM CUSTOMER WHERE EMAIL=?")
    Customer findByEmail(String email);
    Customer findEmailByCustomerId(String customerId);


    Customer findByCustomerId(String customerId);
}
