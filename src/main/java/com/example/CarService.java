package com.example;

import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {


    private final CarsRepository repository;

    @Autowired
    public CarService(CarsRepository repository) {
        this.repository = repository;
    }

    public List<Car> list() {
        return repository.findAll();
    }

    public Car newCar(Car newCar) {
        return repository.save(newCar);
    }

    public Optional<Car> show(Integer id) {
        return repository.findById(id).filter(car -> car.getId(id).equals(id));
    }

    public Car updatedCar(Car updatedCar, Integer id) {
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

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
