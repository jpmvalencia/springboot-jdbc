package com.user.springbootjdbc.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("owned_cars")
public class OwnedCars {
    @Id
    private Integer id;

    private String manufacturer;

    @Column("car_model")
    private String carModel;

    @Column("purchase_date")
    private Date purchaseDate;

    private Condition condition;
    
    @Column("warranty_months")
    private Integer warrantyMonths;

    @Column("dealer_id")
    private AggregateReference<Dealer, Integer> dealer;

    @Column("customer_id")
    private AggregateReference<Customer, Integer> customer;
}
