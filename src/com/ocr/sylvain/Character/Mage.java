package com.ocr.sylvain.Character;

public class Mage extends Character{

    public Mage(String name) {
        super(name);
    }

    @Override
    public void appearance() {
        System.out.print("Abracadabra je suis le Mage ");
        super.appearance();
    }

    @Override
    public void basicAttack(Character character) {
        int damages = this.getIntelligence();
        System.out.println(this.getName() + " utilise Boule de Feu et inflige " + damages + " dommages");
        character.takeDamages(damages);
    }

    @Override
    public void specialAttack(Character character){
        int healing = this.getIntelligence() * 2;
        this.gainHp(healing);
    }
}
