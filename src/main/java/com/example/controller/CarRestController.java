package com.example.controller;

import com.example.model.Car;
import com.example.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarsRepository repository;

    @Autowired
    CarRestController(CarsRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Car> list() {
        return repository.findAll();
    }

    @PostMapping("/cars")
    public Car newCar(Car newCar) {
        return repository.save(newCar);
    }

    @GetMapping("/{id}")
    public Optional<Car> show(@PathVariable Integer id) {
        return repository.findById(id).filter(car -> car.getId(id).equals(id));
    }

    @PutMapping("/{id}")
    public Car updatedCar(Car updatedCar, @PathVariable Integer id) {
        return repository.findById(id).
                map(car -> {
                    car.setId(updatedCar.getId(id));
                    car.setBrand(updatedCar.getBrand());
                    car.setModel(updatedCar.getModel());
                    return repository.save(car);
                })
                .orElseGet(() -> {
                    updatedCar.setId(id);
                    return repository.save(updatedCar);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
