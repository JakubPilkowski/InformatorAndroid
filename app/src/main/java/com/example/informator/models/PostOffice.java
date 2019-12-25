package com.example.informator.models;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PostOffice {
    private String street;
    private String imgUrl;
    private String postalCode;
    private int phoneNumber;
    private LinkedHashMap<String,String> openingHours;

    public PostOffice(String street, String imgUrl, String postalCode, int phoneNumber, LinkedHashMap<String, String> openingHours) {
        this.street = street;
        this.imgUrl = imgUrl;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.openingHours = openingHours;
    }

    public String getStreet() {
        return street;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public LinkedHashMap<String, String> getOpeningHours() {
        return openingHours;
    }
}
