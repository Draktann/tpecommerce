package com.iia.tptest.repository;
import org.springframework.data.repository.CrudRepository;
import com.iia.tptest.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
		
	}


