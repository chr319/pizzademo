package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
