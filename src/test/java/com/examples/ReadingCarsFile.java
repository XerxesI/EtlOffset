package com.examples;

import com.beans.Car;
import com.beans.Cars;
import com.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReadingCarsFile {

    @Test
    void getCars() throws IOException, URISyntaxException {
        Cars carsObject;
        carsObject = MockData.getCars("cars.json");
        List<Car> cars = carsObject.getCars();

        MockData.setCars2(cars, "output.json");

    }

    @Test
    void comparecareLists() throws IOException, URISyntaxException {
        Cars carsObject;
        carsObject = MockData.getCars("cars.json");
        List<Car> cars = carsObject.getCars();
//        System.out.println("cars lis size is " + cars.size());
//        System.out.println("The last car of cars is " + cars.get(999));

        carsObject = MockData.getCars("carsetlstream.json");
        List<Car> carsFromEtl = carsObject.getCars();
//        System.out.println("carsFromEtl size is " + carsFromEtl.size());
//        System.out.println("The last car of carsFromEtl is " + carsFromEtl.get(999));


//        System.out.println("The car 998 of cars is " + cars.get(998));
//        System.out.println("The car 998 of carsFromEtl is " + carsFromEtl.get(998));
//        System.out.println(carsFromEtl.get(998).equals(cars.get(998)) ? "cars 998 are the same" : "cars 998 are not the same");
        System.out.println(cars.contains(carsFromEtl.get(998))? "cars 998 exists in cars list" : "cars 998 does not exist in cars list");

//        System.out.println("The car 999 of cars is " + cars.get(999));
//        System.out.println("The car 999 of carsFromEtl is " + carsFromEtl.get(999));
//        System.out.println(carsFromEtl.get(999).equals(cars.get(999)) ? "cars 999 are the same" : "cars 999 are not the same");
        System.out.println(cars.contains(carsFromEtl.get(999)) ? "cars 999 exists in cars lis" : "cars 999 does not exist in cars list");

        var difference = carsFromEtl.stream().filter(s->!cars.contains(s)).collect(Collectors.toList());

        System.out.println("Number of differences is " + difference.size());
        difference.forEach(System.out::println);

        var newList = cars.addAll(difference);

        MockData.setCars2(cars, "carsupdated.json");

//        carsFromEtl.forEach(cars::remove);
//        var result = carsFromEtl.removeAll(cars);

//        System.out.println("Number of differences is " + carsFromEtl.removeAll(cars));
    }

}
