package com.ccccccc.pizzademo.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Pizza {

    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be more than 5 characters")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least one ingredient")
    private List<String> ingredients;
}
