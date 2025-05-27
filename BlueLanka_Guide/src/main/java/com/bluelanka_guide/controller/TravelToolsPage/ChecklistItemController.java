package com.bluelanka_guide.controller.TravelToolsPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChecklistItemController implements Initializable {
    public Button btnDelete;
    public Text lblDescription;
    public Label lblDate;
    public CheckBox chkChecked;
    public TextArea txtFieldDescription;

    private Runnable onDeleteCallback;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDelete.setOnAction(event -> onDelete());
        txtFieldDescription.setOnKeyPressed(event -> onEnterKeyPressed(event));
        chkChecked.setOnAction(event -> onChecked());
    }

    private void onChecked() {
        if(chkChecked.isSelected()){
            System.out.println("Checked");
            lblDescription.setStyle("-fx-strikethrough: true;");
        }else {
            System.out.println("Unchecked");
            lblDescription.setStyle("-fx-strikethrough: false;");
        }
    }

    private void onEnterKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            if(Objects.equals(txtFieldDescription.getText(), "")){
                lblDescription.setText("(Empty)");
            }
            lblDescription.setText(txtFieldDescription.getText());
            txtFieldDescription.setVisible(false);
            lblDescription.setVisible(true);
        }
    }

    public void setOnDeleteCallback(Runnable callback) {
        this.onDeleteCallback = callback;
    }

    private void onDelete() {
        if(onDeleteCallback != null){
            onDeleteCallback.run();
        }
    }

}
