package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.User;
import com.ccccccc.pizzademo.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //    List<Order> findByDeliveryZip(String deliveryZip);
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
