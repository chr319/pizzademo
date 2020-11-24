package com.ccccccc.pizzademo.domain;

import lombok.*;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        //饼底，蛋白-肉，蔬菜，奶酪，酱料
        CRUST, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
