package com.mockdata;

import com.beans.Car;
import com.beans.Cars;
import com.beans.People;
import com.beans.Person;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static People getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new com.google.common.reflect.TypeToken<ArrayList<Person>>() {
        }.getType();
        List<Person> people = new Gson().fromJson(json, listType);
        People allPeople = new People(people);
        return allPeople;
    }

    public static Cars getCars(String inputCars) throws IOException {
        InputStream inputStream = Resources.getResource(inputCars).openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        List<Car> cars = new Gson().fromJson(json, listType);
        Cars allCars = new Cars(cars);
        return allCars;
    }

    public static void setCars(List<Car> cars) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        gson.toJson(cars, new FileWriter("src\\main\\resources\\output.json"));
    }

    public static void setCars2(List<Car> cars, String fileName) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Writer writer = Files.newBufferedWriter(Paths.get("src\\main\\resources\\"+fileName));

        gson.toJson(cars, writer);
        writer.close();
    }

}
