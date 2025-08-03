package com.happycoding.ecommarce.controller;

import com.happycoding.ecommarce.dto.Purchase;
import com.happycoding.ecommarce.dto.PurchaseResponse;
import com.happycoding.ecommarce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @PostMapping("/purchase")
    ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(checkoutService.placeOrder(purchase), HttpStatus.CREATED);
    }
}
