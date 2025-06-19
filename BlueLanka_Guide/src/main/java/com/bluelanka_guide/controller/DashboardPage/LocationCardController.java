package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LocationCardController implements Initializable {
    public ImageView imgVwLocation;
    public Label lblLocation;
    public Label lblRating;

    public void setCityData(String cityName, String rating, String imageUrl) {
        lblLocation.setText(cityName);
        imgVwLocation.setImage(new Image(imageUrl));
        lblRating.setText(rating);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
