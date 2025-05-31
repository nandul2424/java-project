package com.bluelanka_guide.models.WeatherModel;

public class LocationData {
    private final String name;
    private final String region;
    private final String country;
    private final double latitude;
    private final double longitude;

    public LocationData(String name, String region, String country, double latitude, double longitude) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, region, country);
    }
}
