package com.mx.repository;

import com.mx.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustumerRepository extends JpaRepository<Customer, Long> {

}