package com.bluelanka_guide.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDate.setText(LocalDate.now().toString());
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