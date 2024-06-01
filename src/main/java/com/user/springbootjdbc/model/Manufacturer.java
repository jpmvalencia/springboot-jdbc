package com.user.springbootjdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class Manufacturer {
    @Id
    private Integer id;
    
    private String name;
    private String country;
    private String ceo;
    private String email;
    
    @Column("foundation_year")
    private Integer foundationYear;

    @Column("dealer_id")
    private AggregateReference<Dealer, Integer> dealer;
}
