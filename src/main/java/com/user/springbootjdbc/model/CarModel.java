package com.user.springbootjdbc.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("car_model")
public class CarModel {
    @Id
    private Integer id;

    private String name;
    
    private String engine;
    
    @Column("fuel_type")
    private FuelType fuelType;
    
    @Column("transmission_type")
    private TransmissionType transmissionType;
    
    private BigDecimal price;
    
    @Column("release_year")
    private Integer releaseYear;

    @Column("manufacturer_id")
    private AggregateReference<Manufacturer, Integer> manufacturer;
}
