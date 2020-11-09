package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private JdbcTemplate jdbc;

    public JdbcOrderRepository(JdbcTemplate jdbc)
    {this.jdbc=jdbc;}

    @Override
    public Order save(Order order) {
        return null;
    }
}
