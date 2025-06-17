package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Label lblDate;
    public Label lblGreeting;
    public Label lblLocation;
    public ImageView imageLocHikkaduwa;
    public Label lblPlaceName;
    public Label lblPlaceDescription;
    public HBox hbxExploreContainer;
    public HBox hbxActivityContainer;
    public HBox hbxWeatherContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(LocalDate.now().toString());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());

        addActivityCard("Surfing", "Experience the thrill of surfing in Hikkaduwa's waves.", getClass().getResource("/assets/images/surf.jpg").toExternalForm());
        addActivityCard("Surfing", "Experience the thrill of surfing in Hikkaduwa's waves.", getClass().getResource("/assets/images/surf.jpg").toExternalForm());
        addActivityCard("Surfing", "Experience the thrill of surfing in Hikkaduwa's waves.", getClass().getResource("/assets/images/surf.jpg").toExternalForm());

        addWeatherCard();
    }

    private void addWeatherCard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/WeatherCard.fxml"));
            StackPane weatherCard = loader.load();
            WeatherCardController controller = loader.getController();
            controller.weatherService.getCurrentWeather(lblLocation.getText());
            hbxWeatherContainer.getChildren().add(weatherCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addActivityCard(String activityName, String description, String imageUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/ActivityCard.fxml"));
            StackPane card = loader.load();
            ActivityCardController controller = loader.getController();
            controller.setActivityData(activityName, description, imageUrl);
            hbxActivityContainer.getChildren().add(card);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addCityCard(String cityName, String description, String imageUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/LocationCard.fxml"));
            StackPane card = loader.load();
            LocationCardController controller = loader.getController();
            controller.setCityData(cityName, description, imageUrl);
            hbxExploreContainer.getChildren().add(card);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showDescription(MouseEvent mouseEvent) {
        lblPlaceName.setVisible(false);
        lblPlaceDescription.setVisible(true);
        lblPlaceDescription.setText("It's a popular destination for snorkeling, diving, and enjoying the sun. The town also has a rich cultural heritage with various temples and local markets.");
    }

    public void hideDescription(MouseEvent mouseEvent) {
        lblPlaceDescription.setVisible(false);
        lblPlaceName.setVisible(true);
    }
}