package com.searchapp.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */

public class Result implements Serializable {
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("abbr")
    @Expose
    String abbr;
    @SerializedName("area")
    @Expose
    String area;
    @SerializedName("largestCity")
    @Expose
    String largestCity;
    @SerializedName("capital")
    @Expose
    String capital;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public void setLargestCity(String largestCity) {
        this.largestCity = largestCity;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
