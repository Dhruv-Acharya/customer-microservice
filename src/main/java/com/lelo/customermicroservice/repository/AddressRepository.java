package com.lelo.customermicroservice.repository;

import com.lelo.customermicroservice.entity.Address;
import com.lelo.customermicroservice.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, String> {

    List<Address> findByCustomer(Customer customer);

}
