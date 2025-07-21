package com.bluelanka_guide.controller;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    public BorderPane mainWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().addListener
            ((observable, oldValue, newValue) -> {
                System.out.println(newValue);
                switch (newValue){
//                    case "Settings":
//                        mainWindow.setCenter(Model.getInstance().getViewFactoryMain().getSettingsView());
//                        break;
                    case "Destinations":
                        mainWindow.setCenter(Model.getInstance().getViewFactoryMain().getDestinationsView());
                        break;
                    case "TravelTools":
                        mainWindow.setCenter(Model.getInstance().getViewFactoryTravelTools().getTravelToolsWindow());
                        break;
                    case "TripPlanner":
                        mainWindow.setCenter(Model.getInstance().getViewFactoryMain().getTripPlannerView());
                        break;
                    default:
                        mainWindow.setCenter(Model.getInstance().getViewFactoryMain().getDashboardView());
                        break;
                }
            });
    }
}
