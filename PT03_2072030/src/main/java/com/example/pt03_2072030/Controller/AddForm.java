package com.example.pt03_2072030.Controller;

import com.example.pt03_2072030.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddForm {
    @FXML
    private ComboBox<String> disc;
    @FXML
    private ObservableList<String> options;
    @FXML
    private TextField namaMenu;
    @FXML
    private TextField hargaMenu;
    @FXML
    private Label labelNama;
    @FXML
    private Button customDisc;
    private String namaBack;
    private float hargaBack;
    private float discBack;
    private FXMLLoader fxmlLoader;
    private boolean closed;
    private Stage newStage;
    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AddDiscountForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 240);
        newStage = new Stage();
        newStage.setTitle("Custom Discount");
        newStage.setScene(scene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        options = FXCollections.observableArrayList(
                "0.0",
                "0.1",
                "0.2",
                "0.3",
                "0.4",
                "0.5",
                "0.6",
                "0.7",
                "0.8",
                "0.9");
        disc.setItems(options);
        disc.getSelectionModel().select(0);
    }

    public String getNamaBack() {
        return namaBack;
    }

    public void setNamaBack(String namaBack) {
        this.namaBack = namaBack;
    }

    public float getHargaBack() {
        return hargaBack;
    }

    public void setHargaBack(float hargaBack) {
        this.hargaBack = hargaBack;
    }

    public float getDiscBack() {
        return discBack;
    }

    public void setDiscBack(float discBack) {
        this.discBack = discBack;
    }

    public boolean isClosed() {
        return closed;
    }

    @FXML
    public void goToMenu() {
        this.namaBack = namaMenu.getText();
        this.hargaBack = Float.parseFloat(hargaMenu.getText());
        if (customDisc.getText().equals("Custom Discount")) {
            this.discBack = Float.parseFloat(disc.getValue());
        } else {
            this.discBack = Float.parseFloat(customDisc.getText());
        }
        namaMenu.clear();
        hargaMenu.clear();
        customDisc.setText("Custom Discount");
        disc.getSelectionModel().select(0);
        this.closed = labelNama.getScene().getWindow().isShowing();
        labelNama.getScene().getWindow().hide();
    }
    @FXML
    public void goToDiscount() {
        newStage.showAndWait();
        AddDiscountForm discountController = fxmlLoader.getController();
        customDisc.setText(String.valueOf(discountController.getDiscount() / 100));
    }

}
