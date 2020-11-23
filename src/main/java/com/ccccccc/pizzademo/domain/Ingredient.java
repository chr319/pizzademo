package com.ccccccc.pizzademo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    @NonNull
    private final Type type;

    public enum Type {
        //饼底，蛋白-肉，蔬菜，奶酪，酱料
        CRUST, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
