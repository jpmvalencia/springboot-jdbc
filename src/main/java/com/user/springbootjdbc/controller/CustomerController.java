package com.user.springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.springbootjdbc.model.Customer;
import com.user.springbootjdbc.model.Gender;
import com.user.springbootjdbc.repository.CustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String getCustomer(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customer";
    }

    @GetMapping("/add-customer")
    public String formCustomer(Model model) {
        return "add-customer";
    }

    @PostMapping("/add-customer")
    public String addCustomer(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("gender") Gender gender,
            Model model) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setGender(gender);

        customerRepository.save(customer);

        return "redirect:/customers";
    }
}
