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
import org.jetbrains.annotations.NotNull;

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
        public void start(@NotNull Stage primaryStage) {
            initializeDestinations();
            root = new BorderPane();
            //applyStyles();
            createSidebar();
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

    private void createSidebar() {
        sidebar = new VBox();
        sidebar.setPrefWidth(300);
        sidebar.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-width: 0 1 0 0;");

        HBox header = new HBox();
        header.setStyle("-fx-padding: 15; -fx-border-color: #e5e7eb; -fx-border-width: 0 0 1 0;");
        header.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label("Destination Explorer");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: #111827;");
        header.getChildren().add(titleLabel);

        HBox searchBox = new HBox();
        searchBox.setStyle("-fx-padding: 15;");
        searchBox.setAlignment(Pos.CENTER);

        searchField = new TextField();
        searchField.setPromptText("Search destinations...");
        searchField.setStyle("-fx-background-color: #f3f4f6; -fx-background-radius: 4; -fx-padding: 8;");
        HBox.setHgrow(searchField, Priority.ALWAYS);
        searchBox.getChildren().add(searchField);

        destinationTabs = new TabPane();
        destinationTabs.setStyle("-fx-background-color: transparent;");
        destinationTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        VBox.setVgrow(destinationTabs, Priority.ALWAYS);

        Tab popularTab = new Tab("Popular");
        popularTab.setContent(createDestinationList());

        Tab savedTab = new Tab("Saved");
        VBox savedContent = new VBox(new Label("No saved destinations yet"));
        savedContent.setAlignment(Pos.CENTER);
        savedContent.setPadding(new Insets(20));
        savedTab.setContent(savedContent);

        Tab recentTab = new Tab("Recent");
        VBox recentContent = new VBox(new Label("No recent searches"));
        recentContent.setAlignment(Pos.CENTER);
        recentContent.setPadding(new Insets(20));
        recentTab.setContent(recentContent);

        destinationTabs.getTabs().addAll(popularTab, savedTab, recentTab);
        sidebar.getChildren().addAll(header, searchBox, destinationTabs);

        root.setLeft(sidebar);

    }

    private ScrollPane createDestinationList() {
        VBox destinationList = new VBox(10);
        destinationList.setPadding(new Insets(10));

        for (Destination destination : destinations) {
            VBox card = createDestinationCard(destination);
            destinationList.getChildren().add(card);
        }

        ScrollPane scrollPane = new ScrollPane(destinationList);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        return scrollPane;
    }

    private VBox createDestinationCard(Destination destination) {
        VBox card = new VBox();
        card.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 4, 0, 0, 1); -fx-cursor: hand;");

        StackPane imageContainer = new StackPane();
        imageContainer.setPrefHeight(120);
        Rectangle imagePlaceholder = new Rectangle(300, 120, Color.LIGHTGRAY);

        HBox ratingBadge = new HBox();
        ratingBadge.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-background-radius: 12; -fx-padding: 4 8;");
        ratingBadge.getChildren().add(new Label(String.format("%.1f", destination.getRating())));
        StackPane.setAlignment(ratingBadge, Pos.TOP_RIGHT);
        StackPane.setMargin(ratingBadge, new Insets(8));
        imageContainer.getChildren().addAll(imagePlaceholder, ratingBadge);

        VBox infoContainer = new VBox(5);
        infoContainer.setPadding(new Insets(10));
        Label nameLabel = new Label(destination.getName());
        nameLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #111827;");
        Label countryLabel = new Label(destination.getCountry());
        countryLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");
        Label descriptionLabel = new Label(destination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #4b5563;");
        infoContainer.getChildren().addAll(nameLabel, countryLabel, descriptionLabel);

        card.getChildren().addAll(imageContainer, infoContainer);
        card.setOnMouseClicked(e -> selectDestination(destination));
        return card;
    }





    }

