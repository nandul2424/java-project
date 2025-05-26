package com.bluelanka_guide.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewFactoryMain {
    private BorderPane loginView;
    private BorderPane signUpView;

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

    public void showDashboardWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard.fxml"));
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
