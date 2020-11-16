package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.domain.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}
