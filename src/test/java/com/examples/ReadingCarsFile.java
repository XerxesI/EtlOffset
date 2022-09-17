package com.examples;

import com.beans.Car;
import com.beans.Cars;
import com.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingCarsFile {

    @Test
    void getCars() throws IOException, URISyntaxException {
        Cars carsObject;
        carsObject = MockData.getCars("cars.json");
        List<Car> cars = carsObject.getCars();

        MockData.setCars2(cars);

    }

    @Test
    void comparecareLists() throws IOException, URISyntaxException {
        Cars carsObject;
        carsObject = MockData.getCars("cars.json");
        List<Car> cars = carsObject.getCars();

        carsObject = MockData.getCars("carsetlstream.json");
        List<Car> carsFromEtl = carsObject.getCars();

        var difference = carsFromEtl.stream().filter(s->!cars.contains(s)).collect(Collectors.toList());

        System.out.println("Number of differences is " + difference.size());

//        carsFromEtl.forEach(cars::remove);
        var result = carsFromEtl.removeAll(cars);

        System.out.println("Number of differences is " + carsFromEtl.removeAll(cars));
    }

}
