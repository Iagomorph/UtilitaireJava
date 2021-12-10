package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class ImcController implements Initializable {

    @FXML
    private TextField TFKilo;

    @FXML
    private TextField TFResultatIMC;

    @FXML
    private TextField TFTaille;

    @FXML
    private Button buttonCalculIMC;

    @FXML
    private Label comment;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Client converter = new Client();



        buttonCalculIMC.setOnMouseClicked(event -> {
            float poids = Float.parseFloat(TFKilo.getText());
            float taille = Float.parseFloat(TFTaille.getText());

            float IMC = (poids/(taille*taille) );

            TFResultatIMC.setText(String.valueOf(IMC));

            if (TFKilo.getText().isEmpty()) {
                comment.setText("Il faut rentrer une valeur");
            }

            if (TFTaille.getText().isEmpty()) {
                comment.setText("Il faut rentrer une valeur");
            }

            if (IMC < 18.5) {
                comment.setText("Vous êtes en sous-poids");
            }

            if (18.5 <= IMC && IMC <= 25) {
                comment.setText("Vous avez un poids normal");
            }

            if (IMC > 25) {
                comment.setText("Vous êtes en sur-poids");
            }




        });

    }
}