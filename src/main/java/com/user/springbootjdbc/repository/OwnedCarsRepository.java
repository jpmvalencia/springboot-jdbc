package com.user.springbootjdbc.repository;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.springbootjdbc.model.OwnedCars;

public interface OwnedCarsRepository extends CrudRepository<OwnedCars, Integer> {
    @Query("SELECT oc.* FROM owned_cars oc JOIN customer c ON oc.customer_id = :id")
    Set<OwnedCars> findByCustomerId(Integer id);
}
