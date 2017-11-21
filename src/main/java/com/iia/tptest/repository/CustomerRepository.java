package com.iia.tptest.repository;


import org.springframework.data.repository.CrudRepository;
import com.iia.tptest.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

	}


