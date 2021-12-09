package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


    }catch (Exception e){
            System.out.println(e);
        }
    }}
