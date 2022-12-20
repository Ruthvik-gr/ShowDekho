package com.example.showdekho.model;

public class Movie {
    String Name;
    String time;
    String location;
    String language;
    String genere;
    String price;

    public Movie(String name, String time, String location, String language, String genere, String price) {
        Name = name;
        this.time = time;
        this.location = location;
        this.language = language;
        this.genere = genere;
        this.price = price;
    }

    public Movie() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
