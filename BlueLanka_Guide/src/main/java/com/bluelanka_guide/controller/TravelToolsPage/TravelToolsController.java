package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsController implements Initializable {
    public Button btnMenuCurrencyConverter;
    public Button btnMenuWeather;
    public Button btnMenuUnitConverter;
    public Button btnMenuChecklist;
    public Button btnMenuEmergencyContacts;
    public Button btnMenuOther;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        btnMenuCurrencyConverter.setOnAction(actionEvent -> onCurrencyConverter());
        btnMenuWeather.setOnAction(actionEvent -> onWeather());
        btnMenuUnitConverter.setOnAction(actionEvent -> onUnitConverter());
        btnMenuEmergencyContacts.setOnAction(actionEvent -> onEmergencyContacts());
        btnMenuChecklist.setOnAction(actionEvent -> onChecklist());
    }

    private void onChecklist() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Checklist");
//        System.out.println("Checklist button clicked");
    }

    private void onEmergencyContacts() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("EmergencyContacts");
//        System.out.println("Emergency Contacts button clicked");
    }

    private void onUnitConverter() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("UnitConverter");
//        System.out.println("Unit Converter button clicked");
    }

    private void onWeather() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Weather");
//        System.out.println("Weather button clicked");
    }

    private void onCurrencyConverter() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("CurrencyConverter");
//        System.out.println("Currency Converter button clicked");
    }

}