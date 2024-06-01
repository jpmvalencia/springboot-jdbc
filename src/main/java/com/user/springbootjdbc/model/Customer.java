package com.user.springbootjdbc.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Customer {
    @Id
    private Integer id;
    
    private String name;
    private String email;
    private String phone;
    private String address;
    private Gender gender;
}
