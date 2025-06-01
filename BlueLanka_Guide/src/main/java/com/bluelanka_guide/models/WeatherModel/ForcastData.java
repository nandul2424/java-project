package com.bluelanka_guide.models.WeatherModel;

public class ForcastData {
    public final WeatherData current;
    public final DayForcast[] forecast;

    public ForcastData(WeatherData current, DayForcast[] forecast) {
        this.current = current;
        this.forecast = forecast;
    }

    public WeatherData getCurrent() {
        return current;
    }

    public DayForcast[] getForecast() {
        return forecast;
    }
}
