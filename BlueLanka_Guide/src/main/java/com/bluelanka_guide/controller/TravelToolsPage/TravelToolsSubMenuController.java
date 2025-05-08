package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsSubMenuController implements Initializable {
    public Button btnCurrencyConverter;
    public Button btnWeather;
    public Button btnUnitConverter;
    public Button btnChecklist;
    public Button btnEmergencyContacts;
    public Button btnOther;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        btnCurrencyConverter.setOnAction(event -> onCurrencyConverter());
        btnWeather.setOnAction(event -> onWeather());
        btnUnitConverter.setOnAction(event -> onUnitConverter());
        btnEmergencyContacts.setOnAction(event -> onEmergencyContacts());
        btnChecklist.setOnAction(event -> onChecklist());
    }

    private void onChecklist() {
        System.out.println("Checklist button clicked");
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Checklist");
    }

    private void onEmergencyContacts() {
        System.out.println("Emergency Contacts button clicked");
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("EmergencyContacts");
    }

    private void onUnitConverter() {
        System.out.println("Unit Converter button clicked");
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("UnitConverter");
    }

    private void onWeather() {
        System.out.println("Weather button clicked");
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("Weather");
    }

    private void onCurrencyConverter() {
        System.out.println("Currency Converter button clicked");
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("CurrencyConverter");
    }
}
