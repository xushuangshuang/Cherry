package com.xushuangshuang.cherry.model;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherToday {

    public String sunrise;
    public String sunset;
    public WeatherTodaySuggest suggestion;

    public WeatherTodaySuggest getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(WeatherTodaySuggest suggestion) {
        this.suggestion = suggestion;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
