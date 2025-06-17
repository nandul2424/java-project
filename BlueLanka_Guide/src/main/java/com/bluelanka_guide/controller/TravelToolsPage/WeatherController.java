package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.models.WeatherModel.DayForcast;
import com.bluelanka_guide.models.WeatherModel.LocationData;
import com.bluelanka_guide.models.WeatherModel.WeatherData;
import com.bluelanka_guide.services.WeatherAPIConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    public Button btnBack;
    public Button btnSearch;
    public TextField txtSearch;
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
    public VBox forecastCard;
    public ListView<DayForcast> forecastList;
    public VBox locationSearchCard;
    public ListView<LocationData> locationList;
    public Button currentLocationButton;
    public Button refreshButton;
    public Label statusLabel;

    private WeatherAPIConnection weatherService;
    private String currentLocation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnBack.setOnAction(event -> onBackBtnClicked());
        weatherService = new WeatherAPIConnection();
        setupUI();
        setupEventHandlers();
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }

    private void setupUI() {
        currentWeatherCard.setVisible(false);
        forecastCard.setVisible(false);
        locationSearchCard.setVisible(false);
//        loadingIndicator.setVisible(false);

        forecastList.setCellFactory(listView -> new ForecastListCell());

        locationList.setCellFactory(listView -> new LocationListCell());

        updateStatus("Ready - Enter a location to get weather data");
    }

    private void setupEventHandlers() {
        txtSearch.setOnAction(event -> handleSearch());

        // Location list selection
        locationList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        txtSearch.setText(newValue.getName());
                        locationSearchCard.setVisible(false);
                        handleSearch();
                    }
                }
        );

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > 2) {
                searchLocations(newValue);
            } else {
                locationSearchCard.setVisible(false);
            }
        });
    }


    @FXML
    private void handleSearch() {
        String location = txtSearch.getText().trim();
        if (location.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Required", "Please enter a location");
            return;
        }

        currentLocation = location + ", Sri Lanka";
        fetchWeatherData(location);
    }

    @FXML
    private void handleCurrentLocation() {
        // This would typically use geolocation API
        // For demo purposes, we'll use a default location
        String defaultLocation = "Matara";
        txtSearch.setText(defaultLocation);
        currentLocation = defaultLocation + ", Sri Lanka";
        fetchWeatherData(defaultLocation);
    }

    @FXML
    private void handleRefresh() {
        if (currentLocation != null && !currentLocation.isEmpty()) {
            fetchWeatherData(currentLocation);
        } else {
            showAlert(Alert.AlertType.INFORMATION, "No Location", "Please search for a location first");
        }
    }

    private void fetchWeatherData(String location) {
        setLoading(true);
        updateStatus("Fetching weather data...");
        locationSearchCard.setVisible(false);

        weatherService.getForecast(location, 3)
                .thenAccept(forecastData -> {
                    Platform.runLater(() -> {
                        updateWeatherDisplay(forecastData.getCurrent());
                        updateForecastDisplay(forecastData.getForecast());
                        setLoading(false);
                        updateStatus("Weather data updated successfully");
                    });
                })
                .exceptionally(throwable -> {
                    Platform.runLater(() -> {
                        setLoading(false);
                        updateStatus("Error: " + throwable.getMessage());
                        showAlert(Alert.AlertType.ERROR, "Weather Error",
                                "Failed to fetch weather data: " + throwable.getMessage());
                    });
                    return null;
                });
    }

    private void searchLocations(String query) {
        weatherService.searchLocations(query)
                .thenAccept(locations -> {
                    Platform.runLater(() -> {
                        updateLocationList(locations);
                    });
                })
                .exceptionally(throwable -> {
                    Platform.runLater(() -> {
                        locationSearchCard.setVisible(false);
                    });
                    return null;
                });
    }

    private void updateWeatherDisplay(WeatherData weather) {
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

        // Show the weather card
        currentWeatherCard.setVisible(true);
    }

    private void updateForecastDisplay(DayForcast[] forecast) {
        forecastList.getItems().clear();
        for (DayForcast day : forecast) {
            forecastList.getItems().add(day);
        }
        forecastCard.setVisible(true);
    }

    private void updateLocationList(LocationData[] locations) {
        locationList.getItems().clear();
        for (LocationData location : locations) {
            locationList.getItems().add(location);
        }
        locationSearchCard.setVisible(locations.length > 0);
    }

    private void setLoading(boolean loading) {
        btnSearch.setDisable(loading);
        refreshButton.setDisable(loading);
        currentLocationButton.setDisable(loading);
//        loadingIndicator.setVisible(loading);
    }

    private void updateStatus(String message) {
        statusLabel.setText(message);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Custom list cell for forecast display
    private static class ForecastListCell extends ListCell<DayForcast> {
        @Override
        protected void updateItem(DayForcast forecast, boolean empty) {
            super.updateItem(forecast, empty);

            if (empty || forecast == null) {
                setGraphic(null);
            } else {
                HBox container = new HBox(15);
                container.setAlignment(Pos.CENTER_LEFT);
                container.setPadding(new Insets(10));

                // Date
                Label dateLabel = new Label(forecast.getDate());
                dateLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
                dateLabel.setPrefWidth(100);

                // Icon (if available)
                ImageView iconView = new ImageView();
                if (forecast.getIconUrl() != null && !forecast.getIconUrl().isEmpty()) {
                    try {
                        Image icon = new Image(forecast.getIconUrl(), 32, 32, true, true);
                        iconView.setImage(icon);
                    } catch (Exception e) {
                        // Icon loading failed, continue without icon
                    }
                }
                iconView.setFitWidth(32);
                iconView.setFitHeight(32);

                // Condition
                Label conditionLabel = new Label(forecast.getCondition());
                conditionLabel.setPrefWidth(150);

                // Temperature range
                Label tempLabel = new Label(String.format("%.1f°C / %.1f°C",
                        forecast.getMaxTemp(), forecast.getMinTemp()));
                tempLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
                tempLabel.setPrefWidth(100);

                // Rain chance
                Label rainLabel = new Label(String.format("Rain: %d%%", forecast.getChanceOfRain()));
                rainLabel.setPrefWidth(80);

                container.getChildren().addAll(dateLabel, iconView, conditionLabel, tempLabel, rainLabel);
                setGraphic(container);
            }
        }
    }

    // Custom list cell for location display
    private static class LocationListCell extends ListCell<LocationData> {
        @Override
        protected void updateItem(LocationData location, boolean empty) {
            super.updateItem(location, empty);

            if (empty || location == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(String.format("%s, %s, %s",
                        location.getName(), location.getRegion(), location.getCountry()));
            }
        }
    }
}
