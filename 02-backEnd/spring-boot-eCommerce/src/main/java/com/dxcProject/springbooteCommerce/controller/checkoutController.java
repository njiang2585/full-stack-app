package com.dxcProject.springbooteCommerce.controller;

import com.dxcProject.springbooteCommerce.dto.purchase;
import com.dxcProject.springbooteCommerce.dto.purchaseResponse;
import com.dxcProject.springbooteCommerce.service.checkoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class checkoutController {

    private checkoutService checkoutService;

    public checkoutController(checkoutService checkoutService)  {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public purchaseResponse placeOrder(@RequestBody purchase purchase) {

        purchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}