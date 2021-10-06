package com.dxcProject.springbooteCommerce.service;

import com.dxcProject.springbooteCommerce.dto.purchase;
import com.dxcProject.springbooteCommerce.dto.purchaseResponse;

public interface checkoutService {

    purchaseResponse placeOrder(purchase purchase);
}
