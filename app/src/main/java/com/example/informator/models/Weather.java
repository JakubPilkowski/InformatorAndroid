package com.example.informator.models;

public class Weather {
    private String temp;
    private String tempMax;
    private String weatherType;
    private String humidity;
    private String pressure;

    public Weather(String temp, String tempMax, String weatherType, String humidity, String pressure) {
        this.temp = temp;
        this.tempMax = tempMax;
        this.weatherType = weatherType;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }
}
