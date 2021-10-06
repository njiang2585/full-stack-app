package com.dxcProject.springbooteCommerce.service;

import com.dxcProject.springbooteCommerce.dao.customerRepository;
import com.dxcProject.springbooteCommerce.dto.purchase;
import com.dxcProject.springbooteCommerce.dto.purchaseResponse;
import com.dxcProject.springbooteCommerce.entity.customer;
import com.dxcProject.springbooteCommerce.entity.order;
import com.dxcProject.springbooteCommerce.entity.orderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class checkoutServiceImpl implements checkoutService {

    private customerRepository customerRepository;

    public checkoutServiceImpl(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public purchaseResponse placeOrder(purchase purchase) {

        // retrieve the order info from dto
        order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<orderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new purchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









