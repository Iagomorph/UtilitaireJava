package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class FormulaireController implements Initializable {
    @FXML
    private TextField TxtParution;

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
    private VBox container;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnValider.setOnMouseClicked(Valider -> {

            txtErrCol.setText("");
            txtErrRan.setText("");

            int range = Integer.parseInt(txtRange.getText());
            int colonne = Integer.parseInt((txtColonne.getText()));

            String urlImg = txtCouverture.getText();

            if (range > 7) txtErrRan.setText("Erreur : La rangée est trop grande");
            if (range < 1) txtErrRan.setText("Erreur : La rangée est trop petite");
            if (colonne > 5) txtErrCol.setText("Erreur : La colonne est trop grande");
            if (colonne < 1)txtErrCol.setText("Erreur : La colonne est trop petite");

//            Image image = new Image(new FileInputStream("urlImg"));
//            ImageView imageView = new ImageView(image);
     });
    }
}
