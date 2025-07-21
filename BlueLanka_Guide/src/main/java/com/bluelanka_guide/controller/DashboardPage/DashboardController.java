package com.bluelanka_guide.controller.DashboardPage;

import com.bluelanka_guide.controller.DestinationsPage.DestinationManager;
import com.bluelanka_guide.controller.DestinationsPage.DestinationsController;
import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.services.CurrentLocation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {

    public Label lblDate;
    public Label lblGreeting;
    public Label lblLocation;
    public HBox hbxExploreContainer;
    public HBox hbxActivityContainer;
    public HBox hbxWeatherContainer;
    public HBox hbxDotContainerLocation;
    public HBox hbxDotContainerActivity;

    private List<Image> images = new ArrayList<>();
    private int currentImageIndex = 0;
    private Timeline timeline;
    private final List<StackPane> cityCards = new ArrayList<StackPane>();
    private int currentIndex = 0;
    private final List<StackPane> activityCards = new ArrayList<>();
    private int currentActivityIndex = 0;
    private Timeline activityTimeline;

    DestinationManager destinationManager = Model.getInstance().getDestinationManager();

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDateLocation();
        setLocation();
        loadCards();
        setupLocationDots();
        setupActivityDots();

        startLocationSlider();
        startActivitySlider();
//        addWeatherCard();
    }

    private void setDateLocation() {
        LocalTime time = LocalTime.now();
        lblDate.setText(LocalDate.now().toString());
        if(time.isAfter(LocalTime.of(6,0)) && time.isBefore(LocalTime.of(12,0))){
            lblGreeting.setText("Good Morning !");
        } else if (time.isAfter(LocalTime.of(12,0)) && time.isBefore(LocalTime.of(15,0))) {
            lblGreeting.setText("Good Afternoon !");
        } else if (time.isAfter(LocalTime.of(15,0)) && time.isBefore(LocalTime.of(19,0))) {
            lblGreeting.setText("Good Evening !");
        }else {
            lblGreeting.setText("Good Night !");
        }
        lblLocation.setText(Model.getInstance().getCurrentLocation().getLocation());
    }

    private void setLocation() {}

    private void addCityCard(String cityName, String rating, String imagePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/LocationCard.fxml"));
            StackPane card = loader.load();
            LocationCardController controller = loader.getController();
            controller.setCityData(cityName, rating, imagePath);
            cityCards.add(card);
//            hbxExploreContainer.getChildren().add(card);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addActivityCard(String activityName, String rating, String imageUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/ActivityCard.fxml"));
            StackPane card = loader.load();
            ActivityCardController controller = loader.getController();
            controller.setActivityData(activityName, rating, imageUrl);
            activityCards.add(card);
//            hbxActivityContainer.getChildren().add(card);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

     private void loadCards() {
         //location cards
         for(DestinationsController.Destination d: destinationManager.getDestinationsList()){
             addCityCard(d.getName(), String.valueOf(d.getRating()) , getClass().getResource(d.getImagePath()).toExternalForm());
         }

         //activity cards
         addActivityCard("Surfing", "4.8", getClass().getResource("/assets/images/dashboard/activities/surf.png").toExternalForm());
         addActivityCard("Diving", "4.8", getClass().getResource("/assets/images/dashboard/activities/diving.png").toExternalForm());
         addActivityCard("Whale Watching", "4.8", getClass().getResource("/assets/images/dashboard/activities/whale_watching.png").toExternalForm());
         addActivityCard("Sea Turtle Watching", "4.8", getClass().getResource("/assets/images/dashboard/activities/turtle_watching.png").toExternalForm());
         addActivityCard("Beach Volleyball", "4.8", getClass().getResource("/assets/images/dashboard/activities/beach_volleyball.png").toExternalForm());
     }


     private void setupLocationDots() {
         hbxDotContainerLocation.getChildren().clear();
         for (int i = 0; i < cityCards.size(); i++) {
            Circle dot = new Circle(4);
            dot.getStyleClass().add("dot");
            hbxDotContainerLocation.getChildren().add(dot);
         }
         updateLocationDotIndicator();
     }

      private void updateLocationDotIndicator() {
          for (int i = 0; i < hbxDotContainerLocation.getChildren().size(); i++) {
              hbxDotContainerLocation.getChildren().get(i).setStyle(i == currentIndex ? "-fx-fill: #000;" : "-fx-fill: #ccc;");
          }
      }

      private void startLocationSlider() {
         showCard(currentIndex);
         timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
             currentIndex = (currentIndex + 1) % cityCards.size();
             showCard(currentIndex);
         }));
         timeline.setCycleCount(Timeline.INDEFINITE);
         timeline.play();
      }

      private void showCard(int index) {
         hbxExploreContainer.getChildren().clear();
         hbxExploreContainer.getChildren().add(cityCards.get(index));
         hbxExploreContainer.getChildren().add(cityCards.get(index+1));
         hbxExploreContainer.getChildren().add(cityCards.get(index+2));
         updateLocationDotIndicator();
      }


//    public void showDescription(MouseEvent mouseEvent) {
//        lblPlaceName.setVisible(false);
//        lblPlaceDescription.setVisible(true);
//        lblPlaceDescription.setText("It's a popular destination for snorkeling, diving, and enjoying the sun. The town also has a rich cultural heritage with various temples and local markets.");
//    }
//
//    public void hideDescription(MouseEvent mouseEvent) {
//        lblPlaceDescription.setVisible(false);
//        lblPlaceName.setVisible(true);
//    }
//
//    private void startImageSlider() {
//        images.add(new Image(getClass().getResource("/Slider_images/1.jpg").toExternalForm()));
//        images.add(new Image(getClass().getResource("/Slider_images/2.jpg").toExternalForm()));
//        images.add(new Image(getClass().getResource("/Slider_images/3.jpg").toExternalForm()));
//        images.add(new Image(getClass().getResource("/Slider_images/4.jpg").toExternalForm()));
//
//
//        imageSlider.setImage(images.get(0)); // First image
//
//        timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
//            currentImageIndex = (currentImageIndex + 1) % images.size();
//            imageSlider.setImage(images.get(currentImageIndex));
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }


    //private void addActivityCard(String title, String description, String imagePath) {
    //    try {
    //        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/LocationCard.fxml"));
    //        StackPane card = loader.load();
    //        LocationCardController controller = loader.getController();
    //        controller.setCityData(title, description, getClass().getResource(imagePath).toExternalForm());
    //        activityCards.add(card);
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //}

    private void setupActivityDots() {
        hbxDotContainerActivity.getChildren().clear();
        for (int i = 0; i < activityCards.size(); i++) {
            Circle dot = new Circle(4);
            dot.getStyleClass().add("dot");
            hbxDotContainerActivity.getChildren().add(dot);
        }
        updateActivityDotIndicator();
    }

    private void updateActivityDotIndicator() {
        for (int i = 0; i < hbxDotContainerActivity.getChildren().size(); i++) {
            hbxDotContainerActivity.getChildren().get(i).setStyle(i == currentActivityIndex ? "-fx-fill: #000;" : "-fx-fill: #ccc;");
        }
    }

    private void startActivitySlider() {
        showActivityCard(currentActivityIndex);
        activityTimeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            currentActivityIndex = (currentActivityIndex + 1) % activityCards.size();
            showActivityCard(currentActivityIndex);
        }));
        activityTimeline.setCycleCount(Timeline.INDEFINITE);
        activityTimeline.play();
    }

    private void showActivityCard(int index) {
        hbxActivityContainer.getChildren().clear();
        hbxActivityContainer.getChildren().add(activityCards.get(index));
        hbxActivityContainer.getChildren().add(activityCards.get(index+1));
        hbxActivityContainer.getChildren().add(activityCards.get(index+2));
        updateActivityDotIndicator();
    }

    public int getCurrentImageIndex() {
        return currentImageIndex;
    }

    public void setCurrentImageIndex(int currentImageIndex) {
        this.currentImageIndex = currentImageIndex;
    }
}