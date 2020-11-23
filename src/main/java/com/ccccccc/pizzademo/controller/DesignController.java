package com.ccccccc.pizzademo.controller;

import com.ccccccc.pizzademo.data.IngredientRepository;
import com.ccccccc.pizzademo.data.PizzaRepository;
import com.ccccccc.pizzademo.domain.Ingredient;
import com.ccccccc.pizzademo.domain.Ingredient.Type;
import com.ccccccc.pizzademo.domain.Order;
import com.ccccccc.pizzademo.domain.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignController {

    private final IngredientRepository ingredientRepo;
    private PizzaRepository pizzaRepo;

    @Autowired
    public DesignController(IngredientRepository ingredientRepo,PizzaRepository pizzaRepo) {
        this.ingredientRepo = ingredientRepo;
        this.pizzaRepo = pizzaRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }
    @ModelAttribute(name = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();

        Iterable<Ingredient> iter=ingredientRepo.findAll();
        iter.forEach(
                i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Pizza());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(
            @Valid Pizza design, Errors errors,
            @ModelAttribute Order order,Model model) {
        if (errors.hasErrors())
        {  model.addAttribute("design",design);
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepo.findAll().forEach(i -> ingredients.add(i));

            Type[] types = Ingredient.Type.values();
            for (Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        filterByType(ingredients, type));
            }
            return "design";}

        Pizza saved = pizzaRepo.save(design);
        order.addDesign(saved);

        log.info("Process design: " + design);
        return "redirect:/orders/current";
    }

}
