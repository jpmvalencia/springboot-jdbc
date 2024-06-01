package com.user.springbootjdbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.springbootjdbc.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
