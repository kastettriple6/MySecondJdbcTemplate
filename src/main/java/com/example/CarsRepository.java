package com.example;

import com.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CarsRepository extends JpaRepository<Car, Integer> {
}