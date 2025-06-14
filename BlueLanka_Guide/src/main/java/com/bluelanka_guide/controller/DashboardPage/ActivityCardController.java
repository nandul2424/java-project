package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ActivityCardController implements Initializable {
    public StackPane activityCard;
    public ImageView imageView;
    public Label lblActivityName;
    public Label lblActivityDescription;

    public void setActivityData(String activityName, String activityDescription, String imageUrl) {
        lblActivityName.setText(activityName);
        lblActivityDescription.setText(activityDescription);
        imageView.setImage(new Image(imageUrl));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
