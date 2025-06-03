package com.bluelanka_guide.views;

import com.bluelanka_guide.controller.MainWindowController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewFactoryMain {

    private final StringProperty mainMenuSelectedItem;
    private BorderPane loginView;
    private BorderPane signUpView;
    private AnchorPane dashboardView;
    private BorderPane destinationsView;
    private BorderPane travelToolsView;
    private BorderPane tripPlannerView;
    private AnchorPane settingsView;

    public ViewFactoryMain() {
        this.mainMenuSelectedItem = new SimpleStringProperty("");
    }

    public StringProperty getMainMenuSelectedItem() {
        return mainMenuSelectedItem;
    }

    //main menu views


    public AnchorPane getDashboardView() {
        try {
            if (dashboardView == null) {
                dashboardView = new FXMLLoader(getClass().getResource("/FXML/Dashboard.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dashboardView;
    }

    public BorderPane getDestinationsView() {
        try {
            if (destinationsView == null) {
                destinationsView = new FXMLLoader(getClass().getResource("/FXML/Destinations.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destinationsView;
    }

    public BorderPane getTravelToolsView() {
        try{
            if(travelToolsView == null){
                travelToolsView = new FXMLLoader(getClass().getResource("/FXML/TravelTools.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return travelToolsView;
    }

    public BorderPane getTripPlannerView() {
        try {
            if (tripPlannerView == null) {
                tripPlannerView = new FXMLLoader(getClass().getResource("/FXML/TripPlanner/TripPlanner.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripPlannerView;
    }

    public AnchorPane getSettingsView(){
        try {
            if (settingsView == null) {
                settingsView = new FXMLLoader(getClass().getResource("/FXML/Settings.fxml")).load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return settingsView;
    }

    //login and signup views

    public BorderPane getLoginView(){
        try{
            if(loginView == null){
                loginView = new FXMLLoader(getClass().getResource("/FXML/Login.fxml")).load();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return loginView;
    }

    public BorderPane getSignUpView(){
        try{
            if(signUpView == null){
                signUpView = new FXMLLoader(getClass().getResource("/FXML/SignUp.fxml")).load();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return signUpView;
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }

    public void showMainWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainWindow.fxml"));
        MainWindowController controller = new MainWindowController();
        loader.setController(controller);
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
