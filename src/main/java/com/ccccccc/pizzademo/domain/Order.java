package com.ccccccc.pizzademo.domain;

import com.ccccccc.pizzademo.User;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Pizza_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Name is required.")
    @Column(name = "deliveryName")
    private String deliveryName;

    @NotBlank(message = "Street is required.")
    @Column(name = "deliveryStreet")
    private String street;

    @NotBlank(message = "City is required.")
    @Column(name = "deliveryCity")
    private String city;

    @NotBlank(message = "State is required.")
    @Column(name = "deliveryState")
    private String state;

    @NotBlank(message = "Zip is required.")
    @Column(name = "deliveryZip")
    private String zip;

//    @CreditCardNumber(message = "Not a valid credit card number.")
    @NotBlank(message = "Card Number is required.")
    @Size(min=5, message = "not valid card no")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Not a valid CVV.")
    private String ccCVV;

    @ManyToMany(targetEntity = Pizza.class)
    @JoinTable(name = "Pizza_Order_Pizzas" , joinColumns = @JoinColumn(name = "pizzaOrder"), inverseJoinColumns = @JoinColumn(name = "pizza"))
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public void addDesign(Pizza design) {
        this.pizzas.add(design);
    }

    public void addUser(User user) { this.user=user;}

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
