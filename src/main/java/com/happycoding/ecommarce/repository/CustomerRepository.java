package com.happycoding.ecommarce.repository;

import com.happycoding.ecommarce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
