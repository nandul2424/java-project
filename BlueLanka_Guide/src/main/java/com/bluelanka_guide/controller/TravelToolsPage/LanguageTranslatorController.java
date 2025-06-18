package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class LanguageTranslatorController implements Initializable {
    public Button btnBack;
    public WebView webvwTranslator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        // Load the Google Translate page
        webvwTranslator.getEngine().load("https://translate.google.com/?sl=auto&tl=si&op=translate");
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }
}
