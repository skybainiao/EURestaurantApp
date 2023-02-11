package com.example.eurestaurant.Model;

import java.util.HashMap;

public class Restaurant {


    private String restName;
    private String pic;

    private String username;
    private String location;
    private String type;
    private String city;
    private String country;


    public Restaurant(String restName,String pic, String username,String location,String type,String city,String country){
        this.restName=restName;
        this.pic=pic;

        this.username=username;
        this.type=type;
        this.location=location;
        this.country=country;
        this.city=city;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }



    public String getPic() {
        return pic;
    }

    public String getRestName() {
        return restName;
    }



    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restName='" + restName + '\'' +
                ", pic='" + pic + '\'' +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
