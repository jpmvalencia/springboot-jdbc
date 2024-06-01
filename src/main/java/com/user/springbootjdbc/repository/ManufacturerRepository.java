package com.user.springbootjdbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.springbootjdbc.model.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
    
}
