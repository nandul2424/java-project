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


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class DashboardController implements Initializable {

    public Label lblDate;
    public Label lblGreeting;
    public Label lblLocation;
    public ImageView imageLocHikkaduwa;
    public Label lblPlaceName;
    public Label lblPlaceDescription;
    public HBox hbxExploreContainer;
    
    @FXML
private ImageView imageSlider;
    
    
    private List<Image> images = new ArrayList<>();
private int currentImageIndex = 0;
private Timeline timeline;


private void startImageSlider() {
    images.add(new Image(getClass().getResource("/resources/Slider_images/1.jpg").toExternalForm()));
    images.add(new Image(getClass().getResource("/resources/Slider_images/2.jpg").toExternalForm()));
    images.add(new Image(getClass().getResource("/resources/Slider_images/3.jpg").toExternalForm()));
    images.add(new Image(getClass().getResource("/resources/Slider_images/4.jpg").toExternalForm()));
    

    imageSlider.setImage(images.get(0)); // First image

    timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
        currentImageIndex = (currentImageIndex + 1) % images.size();
        imageSlider.setImage(images.get(currentImageIndex));
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
}

    }
}




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(LocalDate.now().toString());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
        addCityCard("Hikkaduwa", "It's a popular destination for snorkeling, diving, and enjoying the sun. The town ", getClass().getResource("/assets/images/dashboard/hikkaduwa_beach.jpg").toExternalForm());
    
        @FXML
void initialize() {
    System.out.println("Controller initialized");
    startImageSlider();
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