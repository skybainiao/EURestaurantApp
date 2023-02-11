package com.example.eurestaurant.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Post {
    private String username;
    private String restaurantName;
    private String location;
    private String title;
    private String content;
    private String type;
    private String city;
    private String country;
    private String picture;
    private int star1;
    private int star2;
    private int star3;
    private int star4;
    private int star5;
    private HashMap<String,String> comments = new HashMap();
    private int likes;
    private int number;


    public Post(int number,String username,String restaurantName,String location,String title,String content,String type,String city,String country,String picture,int star1,int star2,int star3,int star4,int star5,HashMap<String,String> comments,int likes){
        this.number=number;
        this.username=username;
        this.restaurantName=restaurantName;
        this.location=location;
        this.title=title;
        this.content=content;
        this.type=type;
        this.city=city;
        this.country=country;
        this.picture=picture;
        this.star1=star1;
        this.star2=star2;
        this.star3=star3;
        this.star4=star4;
        this.star5=star5;
        this.comments=comments;
        this.likes=likes;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComments(HashMap<String, String> comments) {
        this.comments = comments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setStar1(int star1) {
        this.star1 = star1;
    }

    public void setStar2(int star2) {
        this.star2 = star2;
    }

    public void setStar3(int star3) {
        this.star3 = star3;
    }

    public void setStar4(int star4) {
        this.star4 = star4;
    }

    public void setStar5(int star5) {
        this.star5 = star5;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public HashMap<String, String> getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public int getStar1() {
        return star1;
    }

    public int getStar2() {
        return star2;
    }

    public int getStar3() {
        return star3;
    }

    public int getStar4() {
        return star4;
    }

    public int getStar5() {
        return star5;
    }

    public String getLocation() {
        return location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "username='" + username + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", picture='" + picture + '\'' +
                ", star1=" + star1 +
                ", star2=" + star2 +
                ", star3=" + star3 +
                ", star4=" + star4 +
                ", star5=" + star5 +
                ", comments=" + comments +
                ", likes=" + likes +
                ", number=" + number +
                '}';
    }
}


