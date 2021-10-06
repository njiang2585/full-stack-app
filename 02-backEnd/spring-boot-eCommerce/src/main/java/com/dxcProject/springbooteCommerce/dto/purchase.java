package com.dxcProject.springbooteCommerce.dto;

import com.dxcProject.springbooteCommerce.entity.address;
import com.dxcProject.springbooteCommerce.entity.customer;
import com.dxcProject.springbooteCommerce.entity.order;
import com.dxcProject.springbooteCommerce.entity.orderItem;
import lombok.Data;

import java.util.Set;

@Data
public class purchase {

    private customer customer;
    private address shippingAddress;
    private address billingAddress;
    private order order;
    private Set<orderItem> orderItems;

}