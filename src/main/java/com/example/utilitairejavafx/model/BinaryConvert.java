package com.example.utilitairejavafx.model;

import java.util.ArrayList;
import java.util.List;

public class BinaryConvert {
    public String binaireToDecimal(String bin){
        String[] arrayofChars = new String[bin.length()];
        int j = 0;
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            arrayofChars[i] = String.valueOf(bin.charAt(i));
        }
        for (int i = bin.length() - 1; i >= 0 ; i--) {
            if (arrayofChars[i].equals("1")){
                result += Math.pow(2,j);
            }
            j++;
        }
        return String.valueOf(result);
    }
    public String decimalToBinaire(int dec){
        List<String> Bin = new ArrayList<>();
        String result = "";
        while(dec > 0 || dec > 1){
            int reste = dec%2;
            Bin.add(String.valueOf(reste));
            dec = dec/2;
        }
        for (int i = Bin.size() -1 ; i >= 0 ; i--) {
            result += Bin.get(i);
        }

        return result;
    }
}
