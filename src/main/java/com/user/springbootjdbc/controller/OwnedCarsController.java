package com.user.springbootjdbc.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.springbootjdbc.model.Condition;
import com.user.springbootjdbc.model.OwnedCars;
import com.user.springbootjdbc.repository.DealerRepository;
import com.user.springbootjdbc.repository.OwnedCarsRepository;

@Controller
@RequestMapping("/owned-cars")
public class OwnedCarsController {
    @Autowired
    private OwnedCarsRepository ownedCarsRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping("/{id}")
    public String getOwnedCars(@PathVariable Integer id, Model model) {
        model.addAttribute("customerId", id);
        model.addAttribute("ownedCars", ownedCarsRepository.findByCustomerId(id));
        return "owned-cars";
    }

    @GetMapping("/buy/{id}")
    public String formOwnedCars(@PathVariable Integer id, Model model) {
        model.addAttribute("customerId", id);
        model.addAttribute("dealers", dealerRepository.findAll());
        return "add-owned-car";
    }

    @PostMapping("/buy/{id}")
    public String addOwnedCars(@PathVariable Integer id,
            @RequestParam("manufacturer") String manufacter,
            @RequestParam("carModel") String carModel,
            @RequestParam("purchaseDate") Date purchaseDate,
            @RequestParam("condition") Condition condition,
            @RequestParam("warrantyMonths") Integer warrantyMonths,
            @RequestParam("manufacturerDealer") Integer manufacturerDealer,
            Model model) {
        model.addAttribute("customerId", id);

        OwnedCars ownedCars = new OwnedCars();
        ownedCars.setManufacturer(manufacter);
        ownedCars.setCarModel(carModel);
        ownedCars.setPurchaseDate(purchaseDate);
        ownedCars.setCondition(condition);
        ownedCars.setWarrantyMonths(warrantyMonths);
        ownedCars.setDealer(AggregateReference.to(manufacturerDealer));
        ownedCars.setCustomer(AggregateReference.to(id));

        ownedCarsRepository.save(ownedCars);

        return "redirect:/owned-cars/" + id;
    }

    @GetMapping("/all")
    public String getAllOwnedCars(Model model) {
        model.addAttribute("ownedCars", ownedCarsRepository.findAll());
        return "all-owned-cars";
    }
}
