package com.user.springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.springbootjdbc.repository.DealerRepository;

@Controller
@RequestMapping("/dealer")
public class DealerController {
    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping("/{id}")
    public String getDealers(@PathVariable Integer id, Model model) {
        model.addAttribute("dealer", dealerRepository.findById(id));
        return "dealer";
    }
}
