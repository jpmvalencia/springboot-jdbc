package com.user.springbootjdbc.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Dealer {
    @Id
    private Integer id;

    private String name;
    private String email;
    private Integer capacity;
    private String location;
    private BigDecimal rating;
}
