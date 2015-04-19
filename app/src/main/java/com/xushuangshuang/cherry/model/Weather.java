package com.xushuangshuang.cherry.model;

import java.util.List;

/**
 * Created by xuss on 2015/4/19.
 */
public class Weather {

    public String status;
    public String city_id;
    public String last_update;
    public WeatherNow now;
    public WeatherToday today;
    public List<WeatherFuture> future;

    public List<WeatherFuture> getFuture() {
        return future;
    }

    public void setFuture(List<WeatherFuture> future) {
        this.future = future;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WeatherToday getToday() {
        return today;
    }

    public void setToday(WeatherToday today) {
        this.today = today;
    }

    public WeatherNow getNow() {
        return now;
    }

    public void setNow(WeatherNow now) {
        this.now = now;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}
