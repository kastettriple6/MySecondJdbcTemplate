package com.example.controller;

import com.example.CarService;
import com.example.CarsRepository;
import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private CarService service;

    @Autowired
    public CarRestController(CarService service) {
        this.service = service;
    }

    @Autowired
    public void CarService(CarsRepository repository) {
        this.service = (CarService) repository;
    }

    @GetMapping("/show")
    public String list() {
        service.list();
        return "cars/show";
    }

    @PostMapping("/new")
    public String newCar(Car car) {
        service.newCar(car);
        return "cars/new";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        service.show(id);
        return "cars/{id}";
    }

    @PutMapping("/{id}")
    public String updatedCar(Car car, @PathVariable Integer id) {
        service.updatedCar(car, id);
        return "cars/{id}";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
