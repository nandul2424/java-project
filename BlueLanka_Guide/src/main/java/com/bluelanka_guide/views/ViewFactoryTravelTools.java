package com.bluelanka_guide.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactoryTravelTools {
    private AnchorPane travelToolsView;
    private AnchorPane checklistView;
    private AnchorPane currencyConverterView;
    private AnchorPane emergencyContactsView;
    private AnchorPane unitConverterView;
    private AnchorPane weatherView;

    public ViewFactoryTravelTools(){}

    public AnchorPane getTravelToolsView() {
        try{
            if(travelToolsView == null){
                travelToolsView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/TravelTools.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return travelToolsView;
    }

    public AnchorPane getChecklistView() {
        try{
            if(checklistView == null){
                checklistView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Checklist.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return checklistView;
    }

    public AnchorPane getCurrencyConverterView() {
        try{
            if(currencyConverterView == null){
                currencyConverterView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/CurrencyConverter.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return currencyConverterView;
    }

    public AnchorPane getEmergencyContactsView() {
        try{
            if(emergencyContactsView == null){
                emergencyContactsView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/EmergencyContacts.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emergencyContactsView;
    }

    public AnchorPane getUnitConverterView() {
        try{
            if(unitConverterView == null){
                unitConverterView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/UnitConverter.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return unitConverterView;
    }

    public AnchorPane getWeatherView() {
        try{
            if(weatherView == null){
                weatherView = new FXMLLoader(getClass().getResource("/FXML/TravelToolsPage/Weather.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return weatherView;
    }

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
