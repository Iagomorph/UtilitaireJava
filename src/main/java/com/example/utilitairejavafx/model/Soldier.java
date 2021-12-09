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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
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
