package com.user.springbootjdbc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.springbootjdbc.model.Dealer;
import com.user.springbootjdbc.model.Manufacturer;
import com.user.springbootjdbc.repository.DealerRepository;
import com.user.springbootjdbc.repository.ManufacturerRepository;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping
    public String getManufacturer(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturers";
    }

    @GetMapping("/add-manufacturer")
    public String formManufacturer(Model model) {
        return "add-manufacturer";
    }

    @PostMapping("/add-manufacturer")
    public String addManufacturer(@RequestParam("manufacturerName") String manufacturerName,
            @RequestParam("manufacturerCountry") String manufacturerCountry,
            @RequestParam("manufacturerCeo") String manufacturerCeo,
            @RequestParam("manufacturerEmail") String manufacturerEmail,
            @RequestParam("manufacturerFoundedYear") Integer manufacturerFoundedYear,
            @RequestParam("dealerName") String dealerName,
            @RequestParam("dealerEmail") String dealerEmail,
            @RequestParam("dealerCapacity") Integer dealerCapacity,
            @RequestParam("dealerLocation") String dealerLocation,
            @RequestParam("dealerRating") BigDecimal dealerRating,
            Model model) {

        Dealer dealer = new Dealer();
        dealer.setName(dealerName);
        dealer.setEmail(dealerEmail);
        dealer.setCapacity(dealerCapacity);
        dealer.setLocation(dealerLocation);
        dealer.setRating(dealerRating);

        dealerRepository.save(dealer);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerName);
        manufacturer.setCountry(manufacturerCountry);
        manufacturer.setCeo(manufacturerCeo);
        manufacturer.setEmail(manufacturerEmail);
        manufacturer.setFoundationYear(manufacturerFoundedYear);
        manufacturer.setDealer(AggregateReference.to(dealer.getId()));

        manufacturerRepository.save(manufacturer);

        return "redirect:/manufacturers";
    }

}
