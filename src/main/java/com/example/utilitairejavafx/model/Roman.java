package com.example.utilitairejavafx.model;

public class Roman {
    public String decimalToRomain(int dec) {
        String result = "";
        if (dec <= 3999) {
            if ((dec / 1000) > 0) {
                int millier = (int) Math.floor(dec / 1000);
                dec = dec - (millier * 1000);
                for (int i = 0; i < millier; i++) {
                    result += "M";
                }
            }
            if ((dec / 900) > 0) {
                int neufcents = (int) Math.floor(dec / 900);
                dec = dec - (dec * 900);
                if (neufcents == 1) {
                    result += "CM";
                }
            }
            if ((dec / 500) > 0) {
                int centaineFive = (int) Math.floor(dec / 500);
                dec = dec - (centaineFive * 500);
                for (int i = 0; i < centaineFive; i++) {
                    result += "D";
                }
            }
            if ((dec / 100) > 0) {
                int centaine = (int) Math.floor(dec / 100);
                dec = dec - (centaine * 100);
                if (centaine == 4) {
                    result += "CD";
                } else {
                    for (int i = 0; i < centaine; i++) {
                        result += "C";
                    }
                }
            }
            if ((dec / 90) > 0) {
                int quatre2010 = (int) Math.floor(dec / 90);
                dec = dec - (quatre2010 * 90);
                if (quatre2010 == 1) {
                    result += "XC";
                }
            }
            if ((dec / 50) > 0) {
                int cinquantaine = (int) Math.floor(dec / 50);
                dec = dec - (cinquantaine * 50);
                for (int i = 0; i < cinquantaine; i++) {
                    result += "L";
                }
            }
            if ((dec / 10) > 0) {
                int dixaine = (int) Math.floor(dec / 10);
                dec = dec - (dixaine * 10);
                if (dixaine == 4) {
                    result += "XL";
                } else {
                    for (int i = 0; i < dixaine; i++) {
                        result += "X";
                    }
                }
            }
            if ((dec / 9) > 0) {
                int neuf = (int) Math.floor(dec / 9);
                dec = dec - (neuf * 9);
                if (neuf == 1) {
                    result += "IX";
                }
            }
            if ((dec / 5) > 0) {
                int cinq = (int) Math.floor(dec / 5);
                dec = dec - (cinq * 5);
                for (int i = 0; i < cinq; i++) {
                    result += "V";
                }
            }
            if ((dec / 1) > 0) {
                int un = (int) Math.floor(dec / 1);
                dec = dec - (un * 10);
                if (un == 4) {
                    result += "IV";
                } else {
                    for (int i = 0; i < un; i++) {
                        result += "I";
                    }
                }
            }

        }
        else {
            System.out.println("la valeur max d'un chiffre romain est 10000");
        }
        return result;
    }
}
