package com.xushuangshuang.cherry.model;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherAirQuerty {
    public String stations;
    public WeatherAirQuertyCity city;

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public WeatherAirQuertyCity getCity() {
        return city;
    }

    public void setCity(WeatherAirQuertyCity city) {
        this.city = city;
    }
}
