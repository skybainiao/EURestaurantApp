package com.example.eurestaurant.Model;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String continent;

    public Country(String name,String continent){
        this.name=name;
        this.continent=continent;
    }

    public Country(String name){
        this.name=name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return continent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
