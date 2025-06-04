package com.bluelanka_guide.models.WeatherModel;

public class DayForcast {
    private final String date;
    private final double maxTemp;
    private final double minTemp;
    private final double avgTemp;
    private final String condition;
    private final String iconUrl;
    private final int chanceOfRain;
    private final int chanceOfSnow;
    private final double maxWind;
    private final int avgHumidity;

    public DayForcast(Builder builder) {
        this.date = builder.date;
        this.maxTemp = builder.maxTemp;
        this.minTemp = builder.minTemp;
        this.avgTemp = builder.avgTemp;
        this.condition = builder.condition;
        this.iconUrl = builder.iconUrl;
        this.chanceOfRain = builder.chanceOfRain;
        this.chanceOfSnow = builder.chanceOfSnow;
        this.maxWind = builder.maxWind;
        this.avgHumidity = builder.avgHumidity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDate() {
        return date;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public String getCondition() {
        return condition;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public int getChanceOfSnow() {
        return chanceOfSnow;
    }

    public double getMaxWind() {
        return maxWind;
    }

    public int getAvgHumidity() {
        return avgHumidity;
    }

    public static class Builder{
        private String date;
        private double maxTemp;
        private double minTemp;
        private double avgTemp;
        private String condition;
        private String iconUrl;
        private int chanceOfRain;
        private int chanceOfSnow;
        private double maxWind;
        private int avgHumidity;

        public Builder date(String date) { this.date = date; return this; }
        public Builder maxTemp(double maxTemp) { this.maxTemp = maxTemp; return this; }
        public Builder minTemp(double minTemp) { this.minTemp = minTemp; return this; }
        public Builder avgTemp(double avgTemp) { this.avgTemp = avgTemp; return this; }
        public Builder condition(String condition) { this.condition = condition; return this; }
        public Builder iconUrl(String iconUrl) { this.iconUrl = iconUrl; return this; }
        public Builder chanceOfRain(int chanceOfRain) { this.chanceOfRain = chanceOfRain; return this; }
        public Builder chanceOfSnow(int chanceOfSnow) { this.chanceOfSnow = chanceOfSnow; return this; }
        public Builder maxWind(double maxWind) { this.maxWind = maxWind; return this; }
        public Builder avgHumidity(int avgHumidity) { this.avgHumidity = avgHumidity; return this; }

        public DayForcast build() {
            return new DayForcast(this);
        }
    }
}
