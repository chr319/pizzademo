package com.ccccccc.pizzademo.data;


import com.ccccccc.pizzademo.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {


}
