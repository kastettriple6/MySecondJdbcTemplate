package com.example;

import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarsRepository repository;

    @Autowired
    public CarService(CarsRepository repository) {
        this.repository = repository;
    }

    public Optional<Car> getCar(Integer id) {
        return repository.findById(id);
    }
}
