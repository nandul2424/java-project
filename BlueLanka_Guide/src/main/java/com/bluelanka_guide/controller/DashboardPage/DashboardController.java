package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import java.util.ArrayList;
import java.util.List;


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
    
    private final List<StackPane> cityCards = new ArrayList<>(); 
    private int currentIndex = 0; 
    private Timeline timeline;
    
    public HBox hbxDotContainer; 
    
    
    
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(LocalDate.now().toString());
        loadCards();
        setupDots();
        startSlider();
    }

     private void loadCards() {
        addCityCard("Negombo", "A coastal city known for its beaches, fresh seafood, and colonial architecture.", "/assets/images/dashboard/negombo.jpg");
        addCityCard("Arugam Bay", "A world-famous surfing destination with golden beaches and a relaxed vibe.", "/assets/images/dashboard/arugambay.jpg");
        addCityCard("Hikkaduwa", "Known for coral reefs and vibrant marine life, ideal for snorkeling.", "/assets/images/dashboard/hikkaduwa.jpg");
        addCityCard("Galle", "A historic city with a Dutch fort, cobblestone streets, and coastal charm.", "/assets/images/dashboard/galle.jpg");
        addCityCard("Trincomalee", "Famous for crystal-clear waters, whale watching, and beautiful beaches.", "/assets/images/dashboard/trincomalee.jpg");
    }
    
       

   
    
    
     private void addCityCard(String cityName, String description, String imagePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard/LocationCard.fxml"));
            StackPane card = loader.load();
            LocationCardController controller = loader.getController();
            controller.setCityData(cityName, description, getClass().getResource(imagePath).toExternalForm());
            cityCards.add(card);
        } catch (Exception e) {
            e.printStackTrace();
        }
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