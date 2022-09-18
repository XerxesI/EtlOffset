package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@NoArgsConstructor
@ToString
public class Car {

    private Integer id;

    private String make;

    private String model;

    private String color;

    private Integer year;

    private Double price;

    public Car(Integer id, String make, String model, String color, Integer year, Double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Step 1: Starting to compare car objects !!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        System.out.println("Starting to compare car objects !!!");
        return id == car.id &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                color.equals(car.color) &&
                year == car.year &&
                price == car.price;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, color, year, price);
    }

}

