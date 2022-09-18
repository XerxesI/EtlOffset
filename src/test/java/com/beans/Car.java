package com.beans;

public class Car {

    private final Integer id;
    private final String make;
    private final String model;
    private final String color;
    private final Integer year;
    private final Double price;

    public Car(
            Integer id,
            String make,
            String model,
            String color,
            Integer year,
            Double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
//        System.out.println("id is " + id + " and car.id is " + car.id);
//        System.out.println("year is " + year + " and car.year is " + car.year);
//        System.out.println(id.intValue() == car.id.intValue() ? "id is the same" : "id is not the same");
//        System.out.println( make.equals(car.make) ? "make is the same" : "make is not the same");
//        System.out.println( model.equals(car.model) ? "model is the same" : "model is not the same");
//        System.out.println( color.equals(car.color) ? "color is the same" : "color is not the same");
//        System.out.println( year.intValue() == car.year.intValue() ? "year is the same" : "year is not the same");
        return id.intValue() == car.id.intValue() &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                color.equals(car.color) &&
                year.intValue() == car.year.intValue() &&
                price.doubleValue() == car.price.doubleValue();
    }
}

