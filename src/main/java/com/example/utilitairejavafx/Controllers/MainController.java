package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private MenuItem menuButtonQuit;

    @FXML
    private Button btnConvert;

    @FXML
    private Button btnIMC;

    @FXML
    private Button btnLibrary;

    @FXML
    private Button btnSim;

    @FXML
    private VBox tabBiblio;

    @FXML
    private VBox containerCentral;

    @FXML
    private VBox imcContainer;

    @FXML
    private VBox converterContainer;

    @FXML
    private VBox armySimContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //on efface la zone centrale
        containerCentral.getChildren().removeAll(imcContainer,armySimContainer,converterContainer,tabBiblio);



        btnConvert.setOnMouseClicked(btnaction -> {
            //affiche la vbox correspondante au bouton
            containerCentral.getChildren().removeAll(imcContainer,armySimContainer,converterContainer,tabBiblio);
            containerCentral.getChildren().add(converterContainer);
        });
        btnIMC.setOnMouseClicked(btnaction -> {
            //affiche la vbox correspondante au bouton
            containerCentral.getChildren().removeAll(imcContainer,armySimContainer,converterContainer,tabBiblio);
            containerCentral.getChildren().add(imcContainer);
        });
        btnLibrary.setOnMouseClicked(btnaction -> {
            //affiche la vbox correspondante au bouton
            containerCentral.getChildren().removeAll(imcContainer,armySimContainer,converterContainer,tabBiblio);
            containerCentral.getChildren().add(tabBiblio);
        });
        btnSim.setOnMouseClicked(btnaction -> {
            //affiche la vbox correspondante au bouton
            containerCentral.getChildren().removeAll(imcContainer,armySimContainer,converterContainer,tabBiblio);
            containerCentral.getChildren().add(armySimContainer);
        });
        menuButtonQuit.setOnAction(btnaction ->{
            System.exit(0);
        });
    }
}