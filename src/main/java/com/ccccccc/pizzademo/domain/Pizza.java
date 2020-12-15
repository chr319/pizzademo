package com.ccccccc.pizzademo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be more than 5 characters")
    private String name;

    @NotEmpty(message = "Must choose your ingredient!")
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "Pizza_Ingredients",joinColumns = @JoinColumn(name = "pizza"),inverseJoinColumns = @JoinColumn(name="ingredient"))
    @Size(min = 2, message = "You must choose at least two ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
