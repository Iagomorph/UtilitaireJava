package com.example.utilitairejavafx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import com.example.utilitairejavafx.model.*;

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
        BinaryConvert binary = new BinaryConvert();
        HexaConvert hex = new HexaConvert();
        Roman roman = new Roman();
        try{
            decToHexaField.setOnKeyPressed(convertion ->{
                if(!decToHexaField.getText().equals("")){
                    hexaToDecField.setText(hex.decimalToHexadecimal(Double.parseDouble(decToHexaField.getText())));
                }else hexaToDecField.setText("");
            });
            hexaToDecField.setOnKeyPressed(convertion ->{
                if(!hexaToDecField.getText().equals("")) {
                    decToHexaField.setText(hex.hexadecimalToDecimal(hexaToDecField.getText()));
                }else decToHexaField.setText("");
            });

            decToBinField.setOnKeyPressed(convertion ->{
                if(!decToBinField.getText().equals("")) {
                    binToDecField.setText(binary.decimalToBinaire(Integer.parseInt(decToBinField.getText())));
                }else binToDecField.setText("");
            });
            binToDecField.setOnKeyPressed(convertion ->{
                if(!binToDecField.getText().equals("")) {
                    decToBinField.setText(binary.binaireToDecimal(binToDecField.getText()));
                }else decToBinField.setText("");
            });

            decToRomField.setOnKeyPressed(convertion ->{
                if(!decToRomField.getText().equals("")) {
                    romField.setText(roman.decimalToRomain(Integer.parseInt(decToRomField.getText())));
                }else romField.setText("");
            });

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
