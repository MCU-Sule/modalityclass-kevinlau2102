package com.example.pt03_2072030.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddDiscountForm {
    @FXML
    private TextField discValue;
    @FXML
    private Label discLabel;
    private float discount;

    public void AddDiscount() {
        this.discount = Float.parseFloat(discValue.getText());
        discValue.clear();
        discLabel.getScene().getWindow().hide();

    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}