package com.example.utilitairejavafx.model;

import java.util.List;

public class General {
    private String name;
    private int hp;
    private int soldierNbr;
    private List<Object> soldierList;

    public General(String name,int hp) {
        this.hp = hp;
        this.name = name;
        this.soldierNbr = soldierList.size();
    }

    protected void addSoldier(Soldier soldier){
        soldierList.add(soldier);
    }
}
