package com.beans;

import java.util.List;

public class Cars {
    private List<Car> Cars;

    public Cars(List<Car> Cars) {
        this.Cars = Cars;
    }

    public Cars() {
    }

    public List<Car> getCars() {
        return Cars;
    }

    public void setCars(List<Car> Cars) {
        this.Cars = Cars;
    }
}
