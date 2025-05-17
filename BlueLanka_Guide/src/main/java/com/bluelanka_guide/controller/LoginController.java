package com.bluelanka_guide.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private Button loginbtn_id;

    @FXML
    private Label msg1id;

    @FXML
    private PasswordField passwordtext;
    @FXML
    private Button cancelbtn_id;
    @FXML
    private Button registerbtn_id;

    @FXML
    private TextField usernametext;

    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;


    public Connection connectdb(){
        try{
           connect= DriverManager.getConnection("jdbc:mysql://localhost/3306/logindetails","root","");
            return connect;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void loginbtn_idOnAction(ActionEvent event){
        connect =connectdb();
        try{
            String sql="SELECT * FROM user WHERE username = ? and password =?";
            statement=connect.prepareStatement(sql);
            statement.setString(1,usernametext.getText());
            statement.setString(2,passwordtext.getText());
            result=statement.executeQuery();

            if(result.next()){
                msg1id.setText("logging Successful!");
                loginbtn_id.getScene().getWindow().hide();
                Parent root= FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene=new Scene(root);
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.show();
            }else{
                msg1id.setText("logging Unsuccessful!");

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loginbtn_idOnAction(javafx.event.ActionEvent event) {
        if(usernametext.getText().isBlank()==true && passwordtext.getText().isBlank()==true){
            msg1id.setText("Please Enter User name and password");
        }else{
            if(usernametext.getText().isBlank()==true){
                msg1id.setText("Please Enter User name");

            }else{
                if(passwordtext.getText().isBlank()==true){
                    msg1id.setText("Please Enter Password");
                }else{
                    msg1id.setText("");
                }
            }
        }



    }

    public void cancelbtn_idOnAction(javafx.event.ActionEvent event) {
        Stage stage=(Stage)cancelbtn_id.getScene().getWindow();
        stage.close();
    }


}
