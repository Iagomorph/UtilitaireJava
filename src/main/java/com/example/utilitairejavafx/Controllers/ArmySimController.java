package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TreeItem;

public class ArmySimController implements Initializable {

    @FXML
    private TreeView<?> armyTree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> army = new TreeItem<> ("Mon Armée");
        army.setExpanded(true);

        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("Choice 1");
        MenuItem menuItem2 = new MenuItem("Choice 2");
        MenuItem menuItem3 = new MenuItem("Choice 3");


        contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem3);

        armyTree.setContextMenu(contextMenu);
//        armyTree.setRoot();
    }
}
