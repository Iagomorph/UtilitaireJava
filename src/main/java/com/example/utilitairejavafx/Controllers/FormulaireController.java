package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.lang.reflect.AnnotatedType;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class FormulaireController implements Initializable {
    @FXML
    private TextField txtParution;

    @FXML
    private Button btnValider;

    @FXML
    private ImageView imgApercu;

    @FXML
    private TextField txtAuteur;

    @FXML
    private TextField txtColonne;

    @FXML
    private TextField txtCouverture;

    @FXML
    private TextField txtRange;

    @FXML
    private TextField txtResume;

    @FXML
    private TextField txtTitre;

    @FXML
    private Label txtErrCol;

    @FXML
    private Label txtErrRan;

    @FXML
    private Label txtErrPar;

    @FXML
    private VBox container;

    @FXML
    private Label txtError;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AtomicBoolean errorRan = new AtomicBoolean(true);
        AtomicBoolean errorCol = new AtomicBoolean(true);
        AtomicBoolean errorPar = new AtomicBoolean(true);
        AtomicBoolean errorTit = new AtomicBoolean(true);
        AtomicBoolean errorAut = new AtomicBoolean(true);

        btnValider.setDisable(true);
        AtomicBoolean bool = new AtomicBoolean(false);

        txtTitre.setOnKeyTyped(Action -> {
            if (txtTitre.getText() == "") {
                errorTit.set(true);
            } else errorTit.set(false);

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }


        });

        txtAuteur.setOnKeyTyped(Action -> {
            if (txtAuteur.getText() == "") {
                errorAut.set(true);
            } else errorAut.set(false);

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        txtRange.setOnKeyTyped(Erreur -> {


            int range = 0;
            try {
                range = Integer.parseInt(txtRange.getText());
                bool.set(false);
            } catch (Exception e) {
                txtErrRan.setText("Erreur : Le chiffre est pô bon banane");
                errorRan.set(true);
                bool.set(true);
            }
            if (range > 7) {
                txtErrRan.setText("Erreur : La rangée est trop grande");
                errorRan.set(true);
            } else if (range < 1) {
                txtErrRan.setText("Erreur : La rangée est trop petite");
                errorRan.set(true);
            } else {
                txtErrRan.setText("");
                errorRan.set(false);
            }
            if (bool.get()) {
                txtErrRan.setText("Erreur : Le chiffre est pô bon banane");
                errorRan.set(true);
            }
            if (txtRange.getText() == "") {
                txtErrRan.setText("");
                errorRan.set(true);
            }

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        txtColonne.setOnKeyTyped(Erreur -> {
            int range = 0;
            try {
                range = Integer.parseInt(txtColonne.getText());
                bool.set(false);
            } catch (Exception e) {
                txtErrCol.setText("Erreur : Ce n'est pas un chiffre valable, on est pas chez les putes");
                errorCol.set(true);
                bool.set(true);
            }

            if (range > 7 && txtColonne.getText() != "") {
                txtErrCol.setText("Erreur : La colonne est trop grande");
                errorCol.set(true);
            } else if (range < 1 && txtColonne.getText() != "") {
                txtErrCol.setText("Erreur : La colonne est trop petite");
                errorCol.set(true);
            } else {
                txtErrCol.setText("");
                errorCol.set(false);
            }

            if (bool.get()) txtErrCol.setText("Erreur : Ce n'est pas un chiffre valable, on est pas chez les putes");
            if (txtColonne.getText() == "") {
                txtErrCol.setText("");
                errorCol.set(true);
            }

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        txtParution.setOnKeyTyped(Erreur -> {
            int parution = 0;
            int annee = Year.now().getValue();
            try {
                parution = Integer.parseInt(txtParution.getText());
                bool.set(false);
            } catch (Exception e) {
                txtErrPar.setText("Erreur : C pa un chifr ");
                errorPar.set(true);
                bool.set(true);
            }
            if (parution > annee) {
                txtErrPar.setText("Erreur : L'année de parution est dans le futur ");
                errorPar.set(true);
            } else {
                txtErrPar.setText("");
                errorPar.set(false);
            }
            if (bool.get()) {
                txtErrPar.setText("Erreur : C pa un chifr ");
                errorPar.set(true);
            }
            if (txtParution.getText() == "") {
                txtErrPar.setText("");
                errorPar.set(true);
            }

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        btnValider.setOnMouseClicked(Valider ->{
            txtTitre.setText("");
            txtAuteur.setText("");
            txtParution.setText("");
            txtColonne.setText("");
            txtRange.setText("");
            txtResume.setText("");
            txtCouverture.setText("");
        });


//        txtTitre.setOnKeyTyped(Valide);

//        btnValider.setOnAction(Valider -> {
//            String urlImg = txtCouverture.getText();
//        });
    }
}
