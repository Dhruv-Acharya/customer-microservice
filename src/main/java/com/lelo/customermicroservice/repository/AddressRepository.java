package com.lelo.customermicroservice.repository;

import com.lelo.customermicroservice.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, String> {

    List<Address> findByCustomerId(String customerId);

}
