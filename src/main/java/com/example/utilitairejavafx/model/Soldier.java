package com.example.utilitairejavafx.model;

public class Soldier {
    private int hp;
    private String name;
    private String rank;

    public Soldier(int hp, String name, String rank) {
        this.hp = hp;
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Soldat " +
                " nom : " + name +
                " hp : " + hp +
                " rang : " + rank ;
    }
}
