package com.ccccccc.pizzademo.controller;

import com.ccccccc.pizzademo.User;
import com.ccccccc.pizzademo.data.OrderRepository;
import com.ccccccc.pizzademo.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.awt.print.Pageable;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute("order") Order order) {
        if (order.getDeliveryName() == null)
            order.setDeliveryName(user.getFullname());
        if (order.getCity() == null)
            order.setCity(user.getCity());
        if (order.getState() == null)
            order.setState(user.getState());
        if (order.getStreet() == null)
            order.setStreet(user.getStreet());
        if (order.getZip() == null)
            order.setZip(user.getZip());

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors())
            return "orderForm";

        order.addUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order Submit: " + order);
        return "result";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {

        Pageable pageable = (Pageable) PageRequest.of(0, 20);
        model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }

}
