package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelToolsController implements Initializable {
    public Button btnCurrencyConverter;
    public Button btnWeather;
    public Button btnUnitConverter;
    public Button btnChecklist;
    public Button btnEmergencyContacts;
    public Button btnOther;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCurrencyConverter.setOnAction(actionEvent -> onCurrencyConverter());
        btnChecklist.setOnAction(actionEvent -> onChecklist());
        btnEmergencyContacts.setOnAction(actionEvent -> onEmergencyContacts());
        btnUnitConverter.setOnAction(actionEvent -> onUnitConvertor());
        btnWeather.setOnAction(actionEvent -> onWeather());
        btnOther.setOnAction(actionEvent -> onOther());
    }

    private void onOther() {
        System.out.println("other");
    }

    private void onCurrencyConverter() {
        Model.getInstance().getViewFactory().showCurrencyConverterWindow();
    }

    private void onChecklist() {
        Model.getInstance().getViewFactory().showChecklistWindow();
    }

    private void onEmergencyContacts() {
        Model.getInstance().getViewFactory().showEmergencyContactsWindow();
    }

    private void onUnitConvertor() {
        Model.getInstance().getViewFactory().showUnitConverterWindow();
    }

    private void onWeather() {
        Model.getInstance().getViewFactory().showWeatherWindow();
    }

}