package com.bluelanka_guide.models.WeatherModel;

public class WeatherData {
    private final String cityName;
    private final String region;
    private final String country;
    private final double temperature;
    private final double temperatureF;
    private final double feelsLike;
    private final String condition;
    private final String iconUrl;
    private final int humidity;
    private final double windSpeed;
    private final String windDirection;
    private final double pressure;
    private final double visibility;
    private final double uvIndex;
    private final String lastUpdated;
    private final String airQuality;

    public WeatherData(Builder builder) {
        this.cityName = builder.cityName;
        this.region = builder.region;
        this.country = builder.country;
        this.temperature = builder.temperature;
        this.temperatureF = builder.temperatureF;
        this.feelsLike = builder.feelsLike;
        this.condition = builder.condition;
        this.iconUrl = builder.iconUrl;
        this.humidity = builder.humidity;
        this.windSpeed = builder.windSpeed;
        this.windDirection = builder.windDirection;
        this.pressure = builder.pressure;
        this.visibility = builder.visibility;
        this.uvIndex = builder.uvIndex;
        this.lastUpdated = builder.lastUpdated;
        this.airQuality = builder.airQuality;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCityName() {
        return cityName;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTemperatureF() {
        return temperatureF;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public String getCondition() {
        return condition;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public double getPressure() {
        return pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public static class Builder {
        private String cityName;
        private String region;
        private String country;
        private double temperature;
        private double temperatureF;
        private double feelsLike;
        private String condition;
        private String iconUrl;
        private int humidity;
        private double windSpeed;
        private String windDirection;
        private double pressure;
        private double visibility;
        private double uvIndex;
        private String lastUpdated;
        private String airQuality;

        public Builder cityName(String cityName) { this.cityName = cityName; return this; }
        public Builder region(String region) { this.region = region; return this; }
        public Builder country(String country) { this.country = country; return this; }
        public Builder temperature(double temperature) { this.temperature = temperature; return this; }
        public Builder temperatureF(double temperatureF) { this.temperatureF = temperatureF; return this; }
        public Builder feelsLike(double feelsLike) { this.feelsLike = feelsLike; return this; }
        public Builder condition(String condition) { this.condition = condition; return this; }
        public Builder iconUrl(String iconUrl) { this.iconUrl = iconUrl; return this; }
        public Builder humidity(int humidity) { this.humidity = humidity; return this; }
        public Builder windSpeed(double windSpeed) { this.windSpeed = windSpeed; return this; }
        public Builder windDirection(String windDirection) { this.windDirection = windDirection; return this; }
        public Builder pressure(double pressure) { this.pressure = pressure; return this; }
        public Builder visibility(double visibility) { this.visibility = visibility; return this; }
        public Builder uvIndex(double uvIndex) { this.uvIndex = uvIndex; return this; }
        public Builder lastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; return this; }
        public Builder airQuality(String airQuality) { this.airQuality = airQuality; return this; }

        public WeatherData build() {
            return new WeatherData(this);
        }
    }
}
