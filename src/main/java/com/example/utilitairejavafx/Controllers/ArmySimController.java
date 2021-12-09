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
    private TreeView<String> armyTree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        try {
        TreeItem<String> army = new TreeItem<> ("Mon Armée");
        army.setExpanded(true);
        TreeItem general = new TreeItem("Généraux");
        army.getChildren().addAll(
                general
        );
        armyTree.setRoot(army);

        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("Créer Un Général");
        MenuItem menuItem2 = new MenuItem("Créer Un Soldat");
//        MenuItem menuItem3 = new MenuItem("Assigner à un général");
            menuItem1.setOnAction(generalmaker -> {

            });


        contextMenu.getItems().addAll(menuItem1,menuItem2);

        armyTree.setContextMenu(contextMenu);

//        armyTree.setRoot();



    }catch (Exception e){
            System.out.println(e);
        }
    }}
