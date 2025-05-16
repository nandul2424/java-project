package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.*;
import com.bluelanka_guide.models.UnitsModel.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UnitConverterController implements Initializable {
    public Button btnBack;
    public TextField txtFromAmount;
    public ComboBox<String> cmbFromUnit;
    public ComboBox<String> cmbToUnit;
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
        UnitType initialValue = Model.getInstance().getViewFactoryTravelTools().getUnitType();
        chbSelectUnit.setValue(initialValue);
        handleUnitChange(initialValue);

        chbSelectUnit.valueProperty().addListener((observable, oldVal, newVal) -> {
            handleUnitChange(newVal);
        });

        //convert button function
        btnConvert.setOnAction(event -> onConvert());
    }

    private void handleUnitChange(UnitType value) {
        switch (value){

            case Weight:
                setComboBox(WeightUnit.values());
                break;
            case Area:
                setComboBox(AreaUnit.values());
                break;
            case Temperature:
                setComboBox(TemperatureUnit.values());
                break;
            case Volume:
                setComboBox(VolumeUnit.values());
                break;
            case Time:
                setComboBox(TimeUnit.values());
                break;
            default:
                setComboBox(LengthUnit.values());
                break;
        }
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }

    private void onConvert() {

    }

    private <T extends Enum<T>> void setComboBox(T[] units){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(T unit: units){
            observableList.add(unit.toString());
        }
        cmbFromUnit.setItems(observableList);
        cmbToUnit.setItems(observableList);
    }

}
