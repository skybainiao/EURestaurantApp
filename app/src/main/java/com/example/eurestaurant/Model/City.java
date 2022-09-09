package com.example.eurestaurant.Model;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String country;

    public City(String name,String country){
        this.name=name;
        this.country=country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
