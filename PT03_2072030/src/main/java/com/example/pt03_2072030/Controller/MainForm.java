package com.example.pt03_2072030.Controller;

import com.example.pt03_2072030.MainApplication;
import com.example.pt03_2072030.Model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Comparator;

public class MainForm {
    @FXML
    private ObservableList<Menu> menu;
    @FXML
    private ListView listMenu;
    private Stage newStage;
    private FXMLLoader fxmlLoader;
    private int idx;

    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AddForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 240);
        newStage = new Stage();
        newStage.setTitle("Add Menu");
        newStage.setScene(scene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        menu = FXCollections.observableArrayList(
                new Menu("Caramel Machiato", 40000, 10),
                new Menu("Caramel latte", 65000, 0),
                new Menu("Espresso", 50000, 0),
                new Menu("Macha Latte", 62500, 0)
        );

        listMenu.setItems(menu);
    }

    public void addMenu(){
        newStage.showAndWait();
        AddForm addController = fxmlLoader.getController();
        if (addController.getNamaBack() != null || addController.getHargaBack() != 0) {
            menu.add(new Menu(addController.getNamaBack(),addController.getHargaBack(), addController.getDiscBack() * 100));
            Comparator<Menu> comp = Comparator.comparing(Menu::getNama);
            FXCollections.sort(menu, comp);
        }
        addController.setNamaBack(null);
        addController.setHargaBack(0);
        addController.setDiscBack(0);
    }
    public void getSelectedItem() {
        if(!listMenu.getSelectionModel().getSelectedItems().isEmpty()) {
            idx = listMenu.getSelectionModel().getSelectedIndex();
            // create a contextMenu
            ContextMenu contextMenu = new ContextMenu();

            // create MenuItem
            MenuItem menuItem1 = new MenuItem("Delete");
            menuItem1.setOnAction((ActionEvent e) -> {
                listMenu.getItems().remove(idx);
                    });

            // add MenuItem to contextMenu
            contextMenu.getItems().add(menuItem1);
            // add contextMenu to listView
            listMenu.setContextMenu(contextMenu);
        }
    }
}
