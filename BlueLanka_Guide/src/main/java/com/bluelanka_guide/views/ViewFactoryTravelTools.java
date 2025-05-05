package com.bluelanka_guide.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactoryTravelTools {
    public ViewFactoryTravelTools(){}

    public void showTravelToolsWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelTools.fxml"));
        createStage(loader);
    }

    public void showChecklistWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Checklist.fxml"));
        createStage(loader);
    }

    public void showCurrencyConverterWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/CurrencyConverter.fxml"));
        createStage(loader);
    }

    public void showEmergencyContactsWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/EmergencyContacts.fxml"));
        createStage(loader);
    }

    public void showUnitConverterWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/UnitConverter.fxml"));
        createStage(loader);
    }

    public void showWeatherWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Weather.fxml"));
        createStage(loader);
    }

    public void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("BlueLanka Guide");
        stage.setScene(scene);
        stage.show();
    }
}
