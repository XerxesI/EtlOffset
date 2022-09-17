package com.beans;

import java.util.List;

public class People {

    private List<Person> People;

    public People(List<Person> People) {
        this.People = People;
    }

    public People() {
    }

    public List<Person> getPeople() {
        return People;
    }

    public void setPeople(List<Person> People) {
        this.People = People;
    }
}
