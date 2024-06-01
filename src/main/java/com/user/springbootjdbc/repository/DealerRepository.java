package com.user.springbootjdbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.springbootjdbc.model.Dealer;

public interface DealerRepository extends CrudRepository<Dealer, Integer> {
    
}
