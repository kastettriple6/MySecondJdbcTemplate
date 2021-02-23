package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    private Integer id;

    @Column(name = "brand", length = 250, nullable = false)
    private String brand;

    @Column(name = "model", length = 250, nullable = false)
    private String model;

    public Car() {
    }

    public Car(Integer id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Integer getId(Integer id) {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
