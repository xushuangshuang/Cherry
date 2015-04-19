package com.xushuangshuang.cherry.model;

import java.util.List;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherModel {

    public String status;
    public List<Weather> weather;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
