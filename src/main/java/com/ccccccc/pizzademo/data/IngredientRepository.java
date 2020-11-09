package com.ccccccc.pizzademo.data;


import com.ccccccc.pizzademo.domain.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
