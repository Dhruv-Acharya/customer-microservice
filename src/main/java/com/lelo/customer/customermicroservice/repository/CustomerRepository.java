package com.lelo.customer.customermicroservice.repository;


import com.lelo.customer.customermicroservice.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

//    @Query(value = "SELECT * FROM CUSTOMER WHERE EMAIL=?")
    Customer findByEmail(String email);


}
