package com.example.utilitairejavafx.Controllers;

import com.example.utilitairejavafx.model.General;
import com.example.utilitairejavafx.model.Soldier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;

public class ArmySimController implements Initializable {

    @FXML
    private Pane InputArmy;

    @FXML
    private Button btnConfirm;

    @FXML
    private TreeView<String> armyTree;

    @FXML
    private TextField hpField;

    @FXML
    private Label hpLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField rankField;

    @FXML
    private Label rankLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<Soldier> soldiers = new ArrayList<Soldier>();
            List<General> generals = new ArrayList<General>();

            InputArmy.setVisible(false);
            TreeItem<String> army = new TreeItem<>("Mon Armée");
            army.setExpanded(true);
            TreeItem<String> generalList = new TreeItem<>("Généraux");
            army.getChildren().addAll(
                generalList
            );
            armyTree.setRoot(army);

            ContextMenu contextMenuGeneral = new ContextMenu();

            MenuItem menuItem1 = new MenuItem("Créer Un Général");
            MenuItem menuItem2 = new MenuItem("Créer Un Soldat");

            contextMenuGeneral.getItems().addAll(menuItem1,menuItem2);

            armyTree.setContextMenu(contextMenuGeneral);

//        MenuItem menuItem3 = new MenuItem("Assigner à un général");
            menuItem1.setOnAction(generalmaker -> {

                //affichage du panneau d'inoput
                InputArmy.setVisible(true);
                nameLabel.setText("Définisser le nom du général");
                hpLabel.setVisible(false);
                hpField.setVisible(false);
                rankLabel.setVisible(false);
                rankField.setVisible(false);
                //gestion bouton création
                btnConfirm.setOnMouseClicked(btnaction -> {
                    String name = nameField.getText();
                    General leader = new General(name);
                    generals.add(leader);
                    int index;
                    generalList.getChildren().add(
                            new TreeItem(leader)
                    );
                    //reset du panneau d'input
                    InputArmy.setVisible(false);
                    rankField.setText("");
                    hpField.setText("");
                    nameField.setText("");
                });
            });
            menuItem2.setOnAction(soldiermaker ->{
                //recup de la selection
                TreeItem<String> selectedItem = armyTree.getSelectionModel().getSelectedItem();
                //si la sélection n'est pas un général
                if (selectedItem == null || selectedItem == army || selectedItem.getValue() == "Généraux")
                    return;

                System.out.println(selectedItem);
                //affichage panneau d'input
                InputArmy.setVisible(true);
                nameLabel.setText("Définisser le nom du soldat");
                hpLabel.setVisible(true);
                hpLabel.setText("Définisser les hp du soldat");
                hpField.setVisible(true);
                rankLabel.setVisible(true);
                rankLabel.setText("Défnisser le rang du soldat");
                rankField.setVisible(true);

                //action bouton créer
                btnConfirm.setOnMouseClicked(btnaction -> {
                    String rank = rankField.getText();
                    int hp = Integer.parseInt(hpField.getText());
                    String name = nameField.getText();
                    Soldier soldier = new Soldier(hp,name,rank);
                    soldiers.add(soldier);
                    InputArmy.setVisible(false);
                    rankField.setText("");
                    hpField.setText("");
                    nameField.setText("");
                    selectedItem.getChildren().add(new TreeItem(soldier));
                });


            });




        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
