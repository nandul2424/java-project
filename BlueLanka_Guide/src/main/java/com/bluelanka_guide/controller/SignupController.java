package com.bluelanka_guide.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class SignupController {


    @FXML
    private Button cancel_reg_id;

    @FXML
    private PasswordField confirm_reg_id;

    @FXML
    private Label confirmpasswordtxt_reg_id;

    @FXML
    private TextField email_reg_id;

    @FXML
    private Label emailtxt_reg_id;

    @FXML
    private Button login_reg_id;

    @FXML
    private Label msg2id;

    @FXML
    private PasswordField password_reg_id;

    @FXML
    private Label passwordtxt_reg_id;

    @FXML
    private Label register_text_id;

    @FXML
    private Button signup_reg_id;

    @FXML
    private Label text_reg_id;

    @FXML
    private TextField username_reg_id;

    @FXML
    private Label usernametxt_reg_id;





    public void ignup_reg_idOnAction(javafx.event.ActionEvent event) {
    }


    public void cancel_reg_idOnAction(javafx.event.ActionEvent event) {
        Stage stage=(Stage)cancel_reg_id.getScene().getWindow();
        stage.close();
    }

    public void signup_reg_idOnAction(javafx.event.ActionEvent event) {
        if(username_reg_id.getText().isBlank()==true){
            msg2id.setText("Please Enter User name");
            msg2id.setVisible(true);
        }else{

            if(email_reg_id.getText().isBlank()==true){
                msg2id.setText("Please Enter Email Address");
                msg2id.setVisible(true);
            }else{
                if(password_reg_id.getText().isBlank()==true){
                    msg2id.setText("Please Enter Password");
                    msg2id.setVisible(true);
                }else{
                    if(confirm_reg_id.getText().isBlank()==true){
                        msg2id.setText("Please Confirm Password");
                        msg2id.setVisible(true);

                    }else{
                        if(password_reg_id.getText().equals(confirm_reg_id.getText())){
                          msg2id.setText("");
                        } else{
                            msg2id.setText("Confirm Password is Wrong!");
                            msg2id.setVisible(true);

                        }
                    }
                }
            }
        }

        if(username_reg_id.getText().isBlank()==false&&email_reg_id.getText().isBlank()==false&&password_reg_id.getText().isBlank()==false&&confirm_reg_id.getText().isBlank()==false&&password_reg_id.getText()==confirm_reg_id.getText()){
            msg2id.setVisible(false);
        }
    }







    }



