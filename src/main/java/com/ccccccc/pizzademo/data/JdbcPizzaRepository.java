package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.domain.Ingredient;
import com.ccccccc.pizzademo.domain.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.util.Date;

public class JdbcPizzaRepository implements PizzaRepository{

    private JdbcTemplate jdbc;

    public JdbcPizzaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Pizza save(Pizza pizza) {

        long pizzaId=savePizzaInfo(pizza);
        pizza.setId(pizzaId);
        for (Ingredient ingredient : pizza.getIngredients()){
            saveIngredientToPizza(ingredient,pizzaId);
        }

        return pizza;
    }

    private long savePizzaInfo(Pizza pizza){
        pizza.setCreatedAt(new Date());
        PreparedStatementCreator psc=

    }

}
