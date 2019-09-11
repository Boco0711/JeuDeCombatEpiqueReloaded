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
        this.appearance();
    }

    private int askStats(String toAsk, int min, int max) {
        String error = toAsk + " doit être compris entre " + min + " et " + max;
        String question = toAsk + " du personnage?";
        return Tools.askSomething(question, error, min, max);
    }

    public void appearance() {
        System.out.println( this.name + " niveau " + this.level + " je possède " +
                this.vitality + " de vitalité, " +
                this.strenght + " de force, " +
                this.agility + " d'agilité et " +
                this.intelligence + " d'intelligence !");
    }

    public void basicAttack(Character character){
    }

    public void specialAttack(Character character){
    }

    protected void takeDamages(int damages) {
        System.out.println(this.name + " perd " + damages + " points de vie");
        this.vitality -= damages;
        if(this.vitality <= 0) {
            this.vitality = 0;
            System.out.println(this.name + " est mort");
        }
    }

    protected void gainAgility(int gain) {
        this.agility += gain;
    }

    protected void gainHp(int gain) {
        this.vitality += gain;
        if (this.vitality > this.level * 5)
            this.vitality = this.level *5;
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
