package com.bluelanka_guide.controller.DashboardPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ActivityCardController implements Initializable {
    public ImageView imgVwLocation;
    public Label lblActivity;
    public Label lblRating;

    public void setActivityData(String activityName, String activityRating, String imageUrl) {
        lblActivity.setText(activityName);
        lblRating.setText(activityRating);
        imgVwLocation.setImage(new Image(imageUrl));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
