package com.ocr.sylvain.Character;

import com.ocr.sylvain.Tools;

public class Character {
    private String name;
    private int level;
    private int vitality;
    private int strenght;
    private int agility;
    private int intelligence;

    Tools tools = new Tools();

    public Character(String name){
        this.name = name;
        this.level = askStats("Niveau", 1, 100);
        this.vitality = this.level*5;
        this.strenght = askStats("Force", 0, this.level);
        this.agility = askStats("Agilité", 0, (this.level-this.strenght));
        this.intelligence = askStats("Intelligence", 0, (this.level - (this.strenght+this.agility)));
        this.appearance();
    }

    /**
     * méthod is using askSomething() in Tools class to get an in to return.
     *
     * @param toAsk The stats that is asked
     * @param min minimum value for the stat
     * @param max maximum value for the stat
     * @return the stat with correct value
     */
    private int askStats(String toAsk, int min, int max) {
        String error = toAsk + " doit être compris entre " + min + " et " + max;
        String question = toAsk + " du personnage?";
        return tools.askSomething(question, error, min, max);
    }

    /**
     * Display a text with the value of character
     */
    public void appearance() {
        System.out.println( this.name + " niveau " + this.level + " je possède " +
                this.vitality + " de vitalité, " +
                this.strenght + " de force, " +
                this.agility + " d'agilité et " +
                this.intelligence + " d'intelligence !");
    }

    /**
     * this method is just meant to be overrided in Mage, Prowler or Warrior
     * @param character is the opponent character.
     */
    public void basicAttack(Character character){
    }

    /**
     * this method is just meant to be overrided in Mage, Prowler or Warrior.
     * @param character is the opponent character.
     */
    public void specialAttack(Character character){
    }

    /**
     * receive a number and reduce vitality of this character for that number
     * If vitality is under or equal 0 this character is dead.
     * @param damages number received
     */
    protected void takeDamages(int damages) {
        System.out.println(this.name + " perd " + damages + " points de vie");
        this.vitality -= damages;
        if(this.vitality <= 0) {
            this.vitality = 0;
            System.out.println(this.name + " est mort");
        }
    }

    /**
     * Receive a number and add that number to the current amount of agility
     * @param gain number received
     */
    protected void gainAgility(int gain) {
        this.agility += gain;
    }

    /**
     * Receive a number and add that number to the current amount of vitality
     * Vitality can never be higher then level * 5
     * @param gain number received
     */
    protected void gainHp(int gain) {
        if (this.vitality + gain > this.level * 5)
            gain = this.level*5 - this.vitality;
        System.out.println(this.getName() + " utilise Soin et gagne " + gain + " en vitalité");
        this.vitality += gain;
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
