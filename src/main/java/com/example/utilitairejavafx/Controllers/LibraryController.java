package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
    @FXML
    private TableColumn<?, ?> colAuteur;

    @FXML
    private TableColumn<?, ?> colColonne;

    @FXML
    private TableColumn<?, ?> colParution;

    @FXML
    private TableColumn<?, ?> colRangee;

    @FXML
    private TableColumn<?, ?> colResume;

    @FXML
    private TableColumn<?, ?> colTitre;

    @FXML
    private TableView<?> tabBibliothèque;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
