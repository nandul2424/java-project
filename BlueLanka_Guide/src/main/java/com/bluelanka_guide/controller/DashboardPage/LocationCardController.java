package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LocationCardController implements Initializable {
    public StackPane cityCard;
    public ImageView imageView;
    public Label lblPlaceName;
    public Label lblPlaceDescription;

    public void setCityData(String cityName, String cityDescription, String imageUrl) {
        lblPlaceName.setText(cityName);
        lblPlaceDescription.setText(cityDescription);
        imageView.setImage(new Image(imageUrl));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void showDescription() {
        lblPlaceDescription.setVisible(true);
    }

    private void hideDescription() {
        lblPlaceDescription.setVisible(false);
    }
}
