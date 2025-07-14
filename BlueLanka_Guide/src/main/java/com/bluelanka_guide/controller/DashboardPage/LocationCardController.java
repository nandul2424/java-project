package com.bluelanka_guide.controller.DashboardPage;

import com.bluelanka_guide.controller.DestinationsPage.DestinationsController;
import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
//        System.out.println(Model.getInstance().getDestinationManager().getDestinationsList().size());
    }

    public void goToDestinations(MouseEvent mouseEvent) {
        System.out.println("Clicked on " + lblLocation.getText());
    }
}
