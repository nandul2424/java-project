package com.bluelanka_guide.controller.DashboardPage;

import com.bluelanka_guide.controller.TravelToolsPage.WeatherController;
import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.models.WeatherModel.WeatherData;
import com.bluelanka_guide.services.WeatherAPIConnection;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherCardController implements Initializable {
    public StackPane weatherCard;
    public VBox currentWeatherCard;
    public Label cityLabel;
    public Label lastUpdatedLabel;
    public ImageView weatherIcon;
    public Label conditionLabel;
    public Label temperatureLabel;
    public Label feelsLikeLabel;
    public Label humidityLabel;
    public Label windLabel;
    public Label pressureLabel;
    public Label visibilityLabel;
    public Label uvIndexLabel;
    public Label airQualityLabel;

    WeatherAPIConnection weatherService;
    String currentLocation = "Colombo";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        weatherService = new WeatherAPIConnection();
        currentWeatherCard.setVisible(true);

        // Fetch current weather data
        System.out.println(currentLocation);
        fetchWeatherData(currentLocation);
    }

    private void fetchWeatherData(String location) {
//        setLoading(true);
//        updateStatus("Fetching weather data...");
//        locationSearchCard.setVisible(false);

        weatherService.getForecast(location, 3)
                .thenAccept(forecastData -> {
                    Platform.runLater(() -> {
                        updateWeatherCard(forecastData.getCurrent());
//                        updateForecastDisplay(forecastData.getForecast());
//                        setLoading(false);
//                        updateStatus("Weather data updated successfully");
                    });
                })
                .exceptionally(throwable -> {
                    Platform.runLater(() -> {
//                        setLoading(false);
//                        updateStatus("Error: " + throwable.getMessage());
//                        showAlert(Alert.AlertType.ERROR, "Weather Error",
//                                "Failed to fetch weather data: " + throwable.getMessage());
                    });
                    return null;
                });
    }

    private void updateWeatherCard(WeatherData weather) {
        // Update location info
        cityLabel.setText(String.format("%s, %s", weather.getCityName(), weather.getCountry()));
        lastUpdatedLabel.setText("Last updated: " + weather.getLastUpdated());

        // Update temperature
        temperatureLabel.setText(String.format("%.1f°C", weather.getTemperature()));
        feelsLikeLabel.setText(String.format("Feels like: %.1f°C", weather.getFeelsLike()));

        // Update condition
        conditionLabel.setText(weather.getCondition());

        // Update details
        humidityLabel.setText(String.format("%d%%", weather.getHumidity()));
        windLabel.setText(String.format("%.1f km/h %s", weather.getWindSpeed(), weather.getWindDirection()));
        pressureLabel.setText(String.format("%.1f mb", weather.getPressure()));
        visibilityLabel.setText(String.format("%.1f km", weather.getVisibility()));
        uvIndexLabel.setText(String.format("%.1f", weather.getUvIndex()));

        // Update air quality if available
        if (weather.getAirQuality() != null) {
            airQualityLabel.setText(weather.getAirQuality());
        } else {
            airQualityLabel.setText("N/A");
        }

        // Load weather icon
        if (weather.getIconUrl() != null && !weather.getIconUrl().isEmpty()) {
            try {
                Image icon = new Image(weather.getIconUrl(), true);
                weatherIcon.setImage(icon);
            } catch (Exception e) {
                System.err.println("Failed to load weather icon: " + e.getMessage());
            }
        }
    }
}
