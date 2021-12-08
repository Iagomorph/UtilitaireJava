package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML
    private TextField binToDecField;

    @FXML
    private TextField decToBinField;

    @FXML
    private TextField decToHexaField;

    @FXML
    private TextField decToRomField;

    @FXML
    private TextField hexaToDecField;

    @FXML
    private TextField romField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
