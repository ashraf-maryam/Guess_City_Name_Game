//Author : Maryam Ashraf
//Date   : 11-15-2020
//File   : GuessTheCity.java

package com.company;

public class City {

    //fields
    private String hintOne;
    private String hintTwo;
    private String hintThree;
    private String cityName;

    //methods
    public String getHintOne() {
        return hintOne;
    }

    public String getHintTwo() {
        return hintTwo;
    }

    public String getHintThree() {
        return hintThree;
    }

    public String getCityName() {
        return cityName;
    }

    //constructor
    public City (String cityHintOne, String cityHintTwo, String cityHintThree, String cityName) {
        hintOne = cityHintOne;
        hintTwo = cityHintTwo;
        hintThree = cityHintThree;
        this.cityName = cityName;
    }
}
