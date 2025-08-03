package com.happycoding.ecommarce.dto;

import com.happycoding.ecommarce.entity.Address;
import com.happycoding.ecommarce.entity.Customer;
import com.happycoding.ecommarce.entity.Order;
import com.happycoding.ecommarce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
