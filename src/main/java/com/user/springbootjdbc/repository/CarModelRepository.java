package com.user.springbootjdbc.repository;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.springbootjdbc.model.CarModel;

public interface CarModelRepository extends CrudRepository<CarModel, Integer> {
    @Query("SELECT cm.* FROM car_model cm JOIN manufacturer m ON cm.manufacturer_id = :id")
    Set<CarModel> findByManufacturerId(Integer id);
}
