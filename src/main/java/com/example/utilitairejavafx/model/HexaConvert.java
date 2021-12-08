package com.example.utilitairejavafx.model;

import java.util.ArrayList;
import java.util.List;

public class HexaConvert {
    public String decimalToHexadecimal(double dec){
        List<String> fResult = new ArrayList<>();
        double puissance16 = 0;
        String result ="";
        int i =0;
        while(Math.pow(16,i) < dec){
            puissance16 = Math.pow(16,i);
            i++;
        }
        while(dec >= 15){
            double reste = dec/puissance16;
            String resultString = String.valueOf(reste);
            String[] resultArray = resultString.split("\\.");
            fResult.add(resultArray[0]);
            double transi = Double.parseDouble(resultArray[0]);
            dec = dec-(transi*puissance16);
            i--;
            puissance16 = Math.pow(16,i-1);
        }
        if (dec!=0){
            String resultString = String.valueOf(dec);
            String[] resultArray = resultString.split("\\.");
            fResult.add(resultArray[0]);
        }

        for (int j = 0; j < fResult.size(); j++) {
            if (Integer.parseInt(fResult.get(j)) < 10){
                result += fResult.get(j);
            }
            else if (fResult.get(j).equals("10")){
                result += "A";
            }
            else if (fResult.get(j).equals("11")){
                result += "B";
            }
            else if (fResult.get(j).equals("12")){
                result += "C";
            }
            else if (fResult.get(j).equals("13")){
                result += "D";
            }else if (fResult.get(j).equals("14")){
                result += "E";
            }
            else if (fResult.get(j).equals("15")){
                result += "F";
            }
        }
        return result;
    }

    public static int hexadecimalToDecimal(String hexa){
        String[] splitHexa = hexa.split("");
        List<String> lettres = new ArrayList<>();
        int result = 0;
        int j = splitHexa.length - 1;
        for (int i = 0; i < splitHexa.length; i++) {
            if (!splitHexa[i].equals("A") && !splitHexa[i].equals("B") && !splitHexa[i].equals("C") && !splitHexa[i].equals("D")
                    && !splitHexa[i].equals("E") && !splitHexa[i].equals("F") ){
                result += Integer.parseInt(splitHexa[i]) * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("A")){
                result += 10 * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("B")){
                result += 11 * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("C")){
                result += 12 * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("D")){
                result += 13 * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("E")){
                result += 14 * Math.pow(16,j);
                j--;
            }
            else if(splitHexa[i].equals("F")){
                result += 15 * Math.pow(16,j);
                j--;
            }
        }
        return result;
    }
}
