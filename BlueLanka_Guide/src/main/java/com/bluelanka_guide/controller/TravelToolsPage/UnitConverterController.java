package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.models.UnitType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UnitConverterController implements Initializable {
    public Button btnBack;
    public TextField txtFromAmount;
    public ComboBox cmbFromUnit;
    public ComboBox cmbToUnit;
    public Button btnSwap;
    public Button btnConvert;
    public Label lblError;
    public TextField txtToAmount;
    public ChoiceBox<UnitType> chbSelectUnit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        //setting choicebox values
        chbSelectUnit.setItems(FXCollections.observableArrayList(UnitType.Length, UnitType.Weight, UnitType.Area, UnitType.Temperature, UnitType.Volume, UnitType.Time));

        //convert button function
        btnConvert.setOnAction(event -> onConvert());
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactory().getToolSelectedMenuItem().set("back");
    }

    private void onConvert() {
        System.out.println("convert");
    }
}
