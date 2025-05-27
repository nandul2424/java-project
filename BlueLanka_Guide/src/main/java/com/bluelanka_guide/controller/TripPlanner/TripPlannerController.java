package com.bluelanka_guide.controller.TripPlanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TripPlannerController {

    @FXML
    public RadioButton radWeekend;
    @FXML
    public RadioButton radWeek;
    @FXML
    public RadioButton radExtended;
    @FXML
    public CheckBox checkMediterranean;
    @FXML
    public CheckBox checkCaribbean;
    @FXML
    public CheckBox checkNordicFjords;
    @FXML
    public CheckBox checkSouthPacific;
    @FXML
    public CheckBox checkOther;
    @FXML
    public TextField txtOtherRegion;

    @FXML
    public Button btnGeneratePlan;
    @FXML
    public Button btnNext;
    @FXML
    public Button btnPrevious;
    @FXML
    public Button btnSave;

    @FXML
    public CheckBox chkChildFriendly;
    @FXML
    public CheckBox chkAccessibility;

    @FXML
    public Spinner spinnerChildren;
    @FXML
    public Spinner spinnerAdults;

    @FXML
    public ComboBox comboCurrency;
    @FXML
    public TextField txtBudgetAmount;

    @FXML
    public RadioButton radUltraLuxury;
    @FXML
    public RadioButton radLuxury;
    @FXML
    public RadioButton radModerate;
    @FXML
    public RadioButton radBudget;

    @FXML
    public Slider sliderIntensity;

    @FXML
    public CheckBox checkCultural;
    @FXML
    public CheckBox checkWildlife;
    @FXML
    public CheckBox checkSailing;
    @FXML
    public CheckBox checkWaterSports;

    @FXML
    public CheckBox checkRelaxation;
    @FXML
    public CheckBox checkSnorkeling;
    @FXML
    public CheckBox checkDiving;
    @FXML
    public CheckBox checkFishing;

    @FXML
    public Slider sliderDays;
    
    @FXML
    public Slider sliderPopularity;
    
    @FXML
    public RadioButton radCoastal;
    @FXML
    public RadioButton radOpenSea;
    @FXML
    public RadioButton radIslandHopping;
    @FXML
    public RadioButton radMixed;


    @FXML
    public RadioButton radDayTrip;

    @FXML
    public void handleOtherRegion() {

    }

    @FXML
    public void handleSaveProgress() {

    }

    @FXML
    private void handlePrevious() {

    }

    @FXML
    private void handleNext() {

    }

    @FXML
    private void handleGeneratePlan() {

    }
}
