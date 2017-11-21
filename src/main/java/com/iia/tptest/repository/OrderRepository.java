package com.iia.tptest.repository;

import com.iia.tptest.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
