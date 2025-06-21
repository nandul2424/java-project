package com.bluelanka_guide.controller.DashboardPage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public ImageView imageSlider;
    public HBox hbxDotContainer;
    public HBox hbxActivityDotContainer;

    private List<Image> images = new ArrayList<>();
    private int currentImageIndex = 0;
    private Timeline timeline;
    private final List<StackPane> cityCards = new ArrayList<StackPane>();
    private int currentIndex = 0;
    private final List<StackPane> activityCards = new ArrayList<>();
    private int currentActivityIndex = 0;
    private Timeline activityTimeline;


     @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(LocalDate.now().toString());
        addCityCard("Hikkaduwa", "4.5" , getClass().getResource("/assets/images/dashboard/newloc.png").toExternalForm());
//        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
//        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
//        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());

//        startImageSlider();

        addActivityCard("Surfing", "4.8", getClass().getResource("/assets/images/surf.jpg").toExternalForm());
//        addActivityCard("Surfing", "Experience the thrill of surfing in Hikkaduwa's waves.", getClass().getResource("/assets/images/surf.jpg").toExternalForm());
//        addActivityCard("Surfing", "Experience the thrill of surfing in Hikkaduwa's waves.", getClass().getResource("/assets/images/surf.jpg").toExternalForm());

//        addWeatherCard();
    }

    private void addCityCard(String cityName, String rating, String imagePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/LocationCard.fxml"));
            StackPane card = loader.load();
            LocationCardController controller = loader.getController();
            controller.setCityData(cityName, "4.5", imagePath);
            cityCards.add(card);
            hbxExploreContainer.getChildren().add(card);
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
//
//        loadCards();
//        setupDots();
//        startSlider();
//
//        loadActivityCards();
//        setupActivityDots();
//        startActivitySlider();
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
        addCityCard("Negombo", "A coastal city known for its beaches, fresh seafood, and colonial architecture.", "/assets/images/dashboard/negombo.jpg");
        addCityCard("Arugam Bay", "A world-famous surfing destination with golden beaches and a relaxed vibe.", "/assets/images/dashboard/arugambay.jpg");
        addCityCard("Hikkaduwa", "Known for coral reefs and vibrant marine life, ideal for snorkeling.", "/assets/images/dashboard/hikkaduwa.jpg");
        addCityCard("Galle", "A historic city with a Dutch fort, cobblestone streets, and coastal charm.", "/assets/images/dashboard/galle.jpg");
        addCityCard("Trincomalee", "Famous for crystal-clear waters, whale watching, and beautiful beaches.", "/assets/images/dashboard/trincomalee.jpg");
    }


      private void setupDots() {
        hbxDotContainer.getChildren().clear();
        for (int i = 0; i < cityCards.size(); i++) {
            Circle dot = new Circle(4);
            dot.getStyleClass().add("dot");
            hbxDotContainer.getChildren().add(dot);
        }
        updateDotIndicator();
    }


      private void updateDotIndicator() {
        for (int i = 0; i < hbxDotContainer.getChildren().size(); i++) {
            hbxDotContainer.getChildren().get(i).setStyle(i == currentIndex ? "-fx-fill: #000;" : "-fx-fill: #ccc;");
        }
    }

       private void startSlider() {
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
        updateDotIndicator();
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

    private void startImageSlider() {
        images.add(new Image(getClass().getResource("/Slider_images/1.jpg").toExternalForm()));
        images.add(new Image(getClass().getResource("/Slider_images/2.jpg").toExternalForm()));
        images.add(new Image(getClass().getResource("/Slider_images/3.jpg").toExternalForm()));
        images.add(new Image(getClass().getResource("/Slider_images/4.jpg").toExternalForm()));


        imageSlider.setImage(images.get(0)); // First image

        timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            currentImageIndex = (currentImageIndex + 1) % images.size();
            imageSlider.setImage(images.get(currentImageIndex));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // 🔽 Methods for Activities Slider

private void loadActivityCards() {
    addActivityCard("Surfing", "Ride the waves at Sri Lanka’s top surf spots like Arugam Bay.", "/assets/images/dashboard/surfing.jpg");
    addActivityCard("Diving", "Explore underwater coral reefs and shipwrecks in Hikkaduwa.", "/assets/images/dashboard/diving.jpg");
    addActivityCard("Whale Watching", "Spot majestic blue whales off the coast of Mirissa.", "/assets/images/dashboard/whale.jpg");
    addActivityCard("Sea Turtle Watching","Watch sea turtles nest or hatch along Sri Lanka’s southern shores for a truly magical wildlife encounter.","/assets/images/dashboard/sea_turtle.jpg");
    addActivityCard("Beach Volleyball", "Enjoy exciting beach games with fellow travelers.", "/assets/images/dashboard/volleyball.jpg");
}

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
    hbxActivityDotContainer.getChildren().clear();
    for (int i = 0; i < activityCards.size(); i++) {
        Circle dot = new Circle(4);
        dot.getStyleClass().add("dot");
        hbxActivityDotContainer.getChildren().add(dot);
    }
    updateActivityDotIndicator();
}

private void updateActivityDotIndicator() {
    for (int i = 0; i < hbxActivityDotContainer.getChildren().size(); i++) {
        hbxActivityDotContainer.getChildren().get(i).setStyle(i == currentActivityIndex ? "-fx-fill: #000;" : "-fx-fill: #ccc;");
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
    updateActivityDotIndicator();
}

}