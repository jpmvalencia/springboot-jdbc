package com.user.springbootjdbc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.springbootjdbc.model.CarModel;
import com.user.springbootjdbc.model.FuelType;
import com.user.springbootjdbc.model.TransmissionType;
import com.user.springbootjdbc.repository.CarModelRepository;

@Controller
@RequestMapping("/cars")
public class CarModelController {
    @Autowired
    private CarModelRepository carModelRepository;

    @GetMapping("/{id}")
    public String getCars(@PathVariable Integer id, Model model) {
        model.addAttribute("cars", carModelRepository.findByManufacturerId(id));
        model.addAttribute("manufacturerId", id);
        return "car-models";
    }

    @GetMapping("/add-car/{id}")
    public String formCar(@PathVariable Integer id, Model model) {

        return "add-car-models";
    }

    @PostMapping("/add-car/{id}")
    public String addCar(@PathVariable Integer id,
            @RequestParam("name") String name,
            @RequestParam("engine") String engine,
            @RequestParam("fuelType") FuelType fuelType,
            @RequestParam("transmissionType") TransmissionType transmissionType,
            @RequestParam("price") BigDecimal price,
            @RequestParam("releaseYear") Integer releaseYear,
            Model model) {

        CarModel carModel = new CarModel();
        carModel.setName(name);
        carModel.setEngine(engine);
        carModel.setFuelType(fuelType);
        carModel.setTransmissionType(transmissionType);
        carModel.setPrice(price);
        carModel.setReleaseYear(releaseYear);
        carModel.setManufacturer(AggregateReference.to(id));

        carModelRepository.save(carModel);

        return "redirect:/cars/" + id;
    }
}
