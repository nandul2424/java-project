package com.bluelanka_guide.services;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import com.bluelanka_guide.models.WeatherModel.DayForcast;
import com.bluelanka_guide.models.WeatherModel.ForcastData;
import com.bluelanka_guide.models.WeatherModel.LocationData;
import com.bluelanka_guide.models.WeatherModel.WeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class WeatherAPIConnection {
    private static final String API_KEY = "8ddf4ee62ac64ffcbe771709251605";
    private static final String BASE_URL = "https://api.weatherapi.com/v1";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherAPIConnection() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public CompletableFuture<WeatherData> getCurrentWeather(String location) {
        try {
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
            String url = String.format("%s/current.json?key=%s&q=%s&aqi=yes",
                    BASE_URL, API_KEY, encodedLocation);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::parseCurrentWeather);
        }catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    public CompletableFuture<ForcastData> getForecast(String location, int days) {
        try {
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
            String url = String.format("%s/forecast.json?key=%s&q=%s&days=%d&aqi=yes&alerts=yes",
                    BASE_URL, API_KEY, encodedLocation, days);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::parseForecast);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    public CompletableFuture<LocationData[]> searchLocations(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = String.format("%s/search.json?key=%s&q=%s",
                    BASE_URL, API_KEY, encodedQuery);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::parseLocations);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    private WeatherData parseCurrentWeather(String jsonResponse) {
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);

            // Check for error
            if (root.has("error")) {
                throw new RuntimeException("API Error: " + root.get("error").get("message").asText());
            }

            JsonNode location = root.get("location");
            JsonNode current = root.get("current");
            JsonNode condition = current.get("condition");

            return WeatherData.builder()
                    .cityName(location.get("name").asText())
                    .region(location.get("region").asText())
                    .country(location.get("country").asText())
                    .temperature(current.get("temp_c").asDouble())
                    .temperatureF(current.get("temp_f").asDouble())
                    .feelsLike(current.get("feelslike_c").asDouble())
                    .condition(condition.get("text").asText())
                    .iconUrl("https:" + condition.get("icon").asText())
                    .humidity(current.get("humidity").asInt())
                    .windSpeed(current.get("wind_kph").asDouble())
                    .windDirection(current.get("wind_dir").asText())
                    .pressure(current.get("pressure_mb").asDouble())
                    .visibility(current.get("vis_km").asDouble())
                    .uvIndex(current.get("uv").asDouble())
                    .lastUpdated(current.get("last_updated").asText())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse weather data", e);
        }
    }

    private ForcastData parseForecast(String jsonResponse) {
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);

            if (root.has("error")) {
                throw new RuntimeException("API Error: " + root.get("error").get("message").asText());
            }

            WeatherData current = parseCurrentWeatherFromForecast(root);
            JsonNode forcastDays = root.get("forecast").get("forecastday");

            DayForcast[] days = new DayForcast[forcastDays.size()];
            for (int i = 0; i < forcastDays.size(); i++) {
                days[i] = parseDayForcast(forcastDays.get(i));
            }

            return new ForcastData(current, days);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse forecast data", e);
        }
    }

    private WeatherData parseCurrentWeatherFromForecast(JsonNode root) {
        JsonNode location = root.get("location");
        JsonNode current = root.get("current");
        JsonNode condition = current.get("condition");

        return WeatherData.builder()
                .cityName(location.get("name").asText())
                .region(location.get("region").asText())
                .country(location.get("country").asText())
                .temperature(current.get("temp_c").asDouble())
                .temperatureF(current.get("temp_f").asDouble())
                .feelsLike(current.get("feelslike_c").asDouble())
                .condition(condition.get("text").asText())
                .iconUrl("https:" + condition.get("icon").asText())
                .humidity(current.get("humidity").asInt())
                .windSpeed(current.get("wind_kph").asDouble())
                .windDirection(current.get("wind_dir").asText())
                .pressure(current.get("pressure_mb").asDouble())
                .visibility(current.get("vis_km").asDouble())
                .uvIndex(current.get("uv").asDouble())
                .lastUpdated(current.get("last_updated").asText())
                .build();
    }

    private DayForcast parseDayForcast(JsonNode dayNode) {
        JsonNode day = dayNode.get("day");
        JsonNode condition = day.get("condition");

        return DayForcast.builder()
                .date(dayNode.get("date").asText())
                .maxTemp(day.get("maxtemp_c").asDouble())
                .minTemp(day.get("mintemp_c").asDouble())
                .avgTemp(day.get("avgtemp_c").asDouble())
                .condition(condition.get("text").asText())
                .iconUrl("https:" + condition.get("icon").asText())
                .chanceOfRain(day.get("daily_chance_of_rain").asInt())
                .chanceOfSnow(day.get("daily_chance_of_snow").asInt())
                .maxWind(day.get("maxwind_kph").asDouble())
                .avgHumidity(day.get("avghumidity").asInt())
                .build();
    }

    private LocationData[] parseLocations(String jsonResponse) {
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            LocationData[] locations = new LocationData[root.size()];

            for (int i = 0; i < root.size(); i++) {
                JsonNode location = root.get(i);
                locations[i] = new LocationData(
                        location.get("name").asText(),
                        location.get("region").asText(),
                        location.get("country").asText(),
                        location.get("lat").asDouble(),
                        location.get("lon").asDouble()
                );
            }

            return locations;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse location data", e);
        }
    }
}
