package com.example.utilitairejavafx.Controllers;

import com.example.utilitairejavafx.model.General;
import com.example.utilitairejavafx.model.Soldier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

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
            MenuItem menuItem3 = new MenuItem("Editer");
            MenuItem menuItem4 = new MenuItem("Supprimer");

            contextMenuGeneral.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

            armyTree.setContextMenu(contextMenuGeneral);

//        MenuItem menuItem3 = new MenuItem("Assigner à un général");
            //sous menu 1
            menuItem1.setOnAction(generalmaker -> {

                //affichage du panneau d'input
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
//sous menu 2
            menuItem2.setOnAction(soldiermaker -> {
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
                rankLabel.setText("Définisser le rang du soldat");
                rankField.setVisible(true);

                //action bouton créer
                btnConfirm.setOnMouseClicked(btnaction -> {
                    String rank = rankField.getText();
                    int hp = Integer.parseInt(hpField.getText());
                    String name = nameField.getText();
                    Soldier soldier = new Soldier(hp, name, rank);
                    soldiers.add(soldier);
                    InputArmy.setVisible(false);
                    rankField.setText("");
                    hpField.setText("");
                    nameField.setText("");
                    selectedItem.getChildren().add(new TreeItem(soldier));
                });


            });
//sous menu 3
            menuItem3.setOnAction(editer -> {
                TreeItem selectedItem = armyTree.getSelectionModel().getSelectedItem();
                System.out.println(selectedItem);
                String[] tabCheck = selectedItem.getValue().toString().split(" ");
                System.out.println(Arrays.toString(tabCheck));
                System.out.println(selectedItem.getValue());
                if (tabCheck[0].equals("Soldat")) {
                    //on affiche le panneau d'input
                    InputArmy.setVisible(true);
                    nameLabel.setText("Redéfinisser le nom du soldat");
                    nameField.setText(tabCheck[4]);
                    hpLabel.setVisible(true);
                    hpLabel.setText("Redéfinisser les hp du soldat");
                    hpField.setText(tabCheck[7]);
                    hpField.setVisible(true);
                    rankLabel.setVisible(true);
                    rankLabel.setText("Redéfinisser le rang du soldat");
                    rankField.setText(tabCheck[10]);
                    rankField.setVisible(true);
                    //on récupère et affiches les valeurs de selecteditem
                    btnConfirm.setOnMouseClicked(btnaction -> {
                        TreeItem selected = armyTree.getSelectionModel().getSelectedItem();
                        //on recup la selection
                        TreeItem parent = selected.getParent();
                        //on recup le parent
                        String rank = rankField.getText();
                        int hp = Integer.parseInt(hpField.getText());
                        String name = nameField.getText();
                        //nouvelle déclaration du TreeItem
                        Soldier soldier = new Soldier(hp, name, rank);
                        TreeItem newselected = new TreeItem(soldier);
                        //on remove l'ancien
                        selected.getParent().getChildren().remove(selected);
                        //on ajoute le nouveau
                        parent.getChildren().add(newselected);

                        InputArmy.setVisible(false);
                    });

                } else if (tabCheck[0].equals("General(e)")) {
                    //affichage du panneau d'input
                    InputArmy.setVisible(true);
                    nameLabel.setText("Redéfinisser le nom du général");
                    nameField.setText(tabCheck[1]);
                    hpLabel.setVisible(false);
                    hpField.setVisible(false);
                    rankLabel.setVisible(false);
                    rankField.setVisible(false);
                    //gestion bouton création
                    btnConfirm.setOnMouseClicked(btnaction -> {
                        TreeItem selected = armyTree.getSelectionModel().getSelectedItem();
                        //on recup la selection
                        String name = nameField.getText();
                        //nouvelle déclaration du TreeItem
                        General general = new General(name);
                        TreeItem newselected = new TreeItem(general);
                        List<TreeItem> allChildren = selected.getChildren();
                        for (TreeItem child : allChildren) {
                            newselected.getChildren().add(child);
                        }
                        //on remove l'ancien
                        selected.getParent().getChildren().remove(selected);
                        //on ajoute le nouveau
                        generalList.getChildren().add(newselected);
                        InputArmy.setVisible(false);
                        nameField.setText("");
                    });
                }
            });
//sousmenu 4
            menuItem4.setOnAction(remover -> {
                TreeItem selectedItem = armyTree.getSelectionModel().getSelectedItem();
                selectedItem.getParent().getChildren().remove(selectedItem);
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
