package com.happycoding.ecommarce.service;

import com.happycoding.ecommarce.dto.Purchase;
import com.happycoding.ecommarce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
