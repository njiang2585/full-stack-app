package com.dxcProject.springbooteCommerce.dao;

import com.dxcProject.springbooteCommerce.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<customer, Long> {
}
