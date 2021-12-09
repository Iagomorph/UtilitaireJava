package com.example.utilitairejavafx.model;

import javafx.scene.control.TreeItem;

import java.util.List;

public class General {
    private String name;




    public General(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return ("General(e)" + " " + name );
    }
//    protected void addSoldier(Soldier soldier){
//        soldierList.add(soldier);
//    }
}
