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
    @Override
    public void start(Stage stage) throws Exception {

    }

    static class Destination {
        private final int id;
        private final String name;
        private final String country;
        private final String description;
        private final double rating;
        private final String imagePath;
        private final double latitude;
        private final double longitude;

        public Destination(int id, String name, String country, String description, double rating, String imagePath, double latitude, double longitude) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.description = description;
            this.rating = rating;
            this.imagePath = imagePath;
            this.latitude = latitude;
            this.longitude = longitude;
        }


    }
}

