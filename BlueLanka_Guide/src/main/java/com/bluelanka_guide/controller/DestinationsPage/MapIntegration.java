package com.bluelanka_guide.controller.DestinationsPage;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapIntegration extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        // Create a WebView to display the map
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Load OpenStreetMap
        webEngine.loadContent(getMapHtml());

        root.getChildren().add(webView);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Map Integration Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getMapHtml() {
        // HTML content to load OpenStreetMap with Leaflet.js
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Map Example</title>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
                <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
                <style>
                    html, body, #map {
                        height: 100%;
                        margin: 0;
                        padding: 0;
                    }
                </style>
            </head>
            <body>
                <div id="map"></div>
                <script>
                    // Initialize the map
                    var map = L.map('map').setView([48.8566, 2.3522], 13);
            
                    //Add OpenStreetMap tile layer
                    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    }).addTo(map);
            
                    // Add markers for destinations
                    var destinations = [
                        {name: "Paris", lat: 48.8566, lng: 2.3522},
                        {name: "Tokyo", lat: 35.6762, lng: 139.6503},
                        {name: "New York", lat: 40.7128, lng: -74.006}
                    ];
            
                    destinations.forEach(function(dest) {
                        L.marker([dest.lat, dest.lng])
                            .addTo(map)
                            .bindPopup(dest.name);
                    });
                      // Function to be called from Java
                                        function selectDestination(lat, lng, name) {
                                            map.setView([lat, lng], 15);
                                            L.popup()
                                                .setLatLng([lat, lng])
                                                .setContent(name)
                                                .openOn(map);
                                        }
                                    </script>
                                </body>
                                </html>
            """ ;
                        }
                    
    public static void main(String[] args) {
        launch(args);
                        }
                    }