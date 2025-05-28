package com.bluelanka_guide.controller.DestinationsPage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DestinationsController extends Application {


    static class Destination {
        private final int id;
        private final String name;
        private final String country;
        private final String description;
        private final double rating;
        private final String imagePath;
        //private final double latitude;
        //private final double longitude;

        //public Destination(int id, String name, String country, String description, double rating, String imagePath, double latitude, double longitude) {
        public Destination(int id, String name, String country, String description, double rating, String imagePath) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.description = description;
            this.rating = rating;
            this.imagePath = imagePath;
            //this.latitude = latitude;
            //this.longitude = longitude;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public String getCountry() { return country; }
        public String getDescription() { return description; }
        public double getRating() { return rating; }
        public String getImagePath() { return imagePath; }
        //public double getLatitude() { return latitude; }
        //public double getLongitude() { return longitude; }

    }
        private BorderPane root;
        private VBox sidebar;
        private StackPane mapContainer;
        private VBox destinationDetails;
        private TabPane destinationTabs;
        private TextField searchField;
        private Button toggleSidebarButton;
        private boolean sidebarVisible = true;
        private List<Destination> destinations;
        private Destination selectedDestination;

    @Override
        public void start(Stage primaryStage) {
            initializeDestinations();
            root = new BorderPane();
            //applyStyles();
            //createSidebar();
            //createMapView();

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Destination Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        private void initializeDestinations() {
            destinations = new ArrayList<>();
            destinations.add(new Destination(1, "Negambo", "Sri Lanka", "Browns Beach in Negombo is a popular coastal destination known for its golden sands, clear waters, and vibrant atmosphere, offering a perfect blend of relaxation and adventure.", 4.8, ".jpg"));
            destinations.add(new Destination(2, "Hikkaduwa", "Sri Lanka", "A bustling metropolis blending ultramodern and traditional aspects of Japanese culture.", 4.7, "tokyo.jpg"));
            destinations.add(new Destination(3, "Arugambe", "Sri Lanka", "The Big Apple known for its skyscrapers, Broadway shows, and cultural diversity.", 4.6, "newyork.jpg"));
    }



}

