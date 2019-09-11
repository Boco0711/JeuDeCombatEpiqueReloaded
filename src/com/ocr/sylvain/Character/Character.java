package com.ocr.sylvain.Character;

public class Character {
    private String name;
    private int level;
    private int vitality;
    private int strenght;
    private int agility;
    private int inttelligence;

    public Character(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getVitality() {
        return this.vitality;
    }

    public int getStrenght() {
        return this.strenght;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getInttelligence() {
        return this.inttelligence;
    }
}
