package com.example.pt03_2072030.Controller;

import com.example.pt03_2072030.MainApplication;
import com.example.pt03_2072030.Model.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainForm {
    @FXML
    private ObservableList<MenuItem> menu;
    @FXML
    private ListView listMenu;
    private Stage newStage;
    private FXMLLoader fxmlLoader;

    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AddForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 240);
        newStage = new Stage();
        newStage.setTitle("Add Menu");
        newStage.setScene(scene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        menu = FXCollections.observableArrayList(
                new MenuItem("Caramel Machiato", 40000, 10),
                new MenuItem("Caramel latte", 65000, 0),
                new MenuItem("Espresso", 50000, 0),
                new MenuItem("Macha Latte", 62500, 0)
        );

        listMenu.setItems(menu);
    }

    public void addMenu(){
        newStage.showAndWait();
        AddForm addController = fxmlLoader.getController();
        System.out.println(addController.isClosed());
        if (addController.isClosed() == false) {
            System.out.println("gajadi");
        }
        if (addController.getNamaBack() != null || addController.getHargaBack() != 0) {
            menu.add(new MenuItem(addController.getNamaBack(),addController.getHargaBack(), addController.getDiscBack() * 100));
        }
        addController.setNamaBack(null);
        addController.setHargaBack(0);
        addController.setDiscBack(0);
    }
}
