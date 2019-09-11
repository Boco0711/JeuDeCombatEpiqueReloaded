package com.ocr.sylvain.Character;

import com.ocr.sylvain.Tools;

public class Character {
    private String name;
    private int level;
    private int vitality;
    private int strenght;
    private int agility;
    private int intelligence;

    public Character(String name){
        this.name = name;
        this.level = askStats("Niveau", 1, 100);
        this.vitality = this.level*5;
        this.strenght = askStats("Force", 0, this.level);
        this.agility = askStats("Agilité", 0, (this.level-this.strenght));
        this.intelligence = askStats("Intelligence", 0, (this.level - (this.strenght+this.agility)));
    }

    private int askStats(String toAsk, int min, int max) {
        String error = toAsk + " doit être compris entre " + min + " et " + max;
        return Tools.askSomething(error, toAsk, min, max);
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

    public int getIntelligence() {
        return this.intelligence;
    }
}
