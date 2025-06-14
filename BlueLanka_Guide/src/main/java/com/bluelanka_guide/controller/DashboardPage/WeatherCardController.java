package com.bluelanka_guide.controller.DashboardPage;

import com.bluelanka_guide.services.WeatherAPIConnection;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        weatherService = new WeatherAPIConnection();
        currentWeatherCard.setVisible(true);
    }
}
