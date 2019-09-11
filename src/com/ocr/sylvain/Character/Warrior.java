package com.ocr.sylvain.Character;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void appearance() {
        System.out.print("Woarg je suis le Guerrier ");
        super.appearance();
    }

    @Override
    public void basicAttack(Character character) {
        int damages = this.getStrenght();
        System.out.println(this.getName() + " utilise Coup d'Épée et inflige " + damages + " dommages");
        character.takeDamages(damages);
    }

    @Override
    public void specialAttack(Character character){
        int damages = this.getStrenght() * 2;
        int sideEffects = this.getStrenght() / 2;
        System.out.println(this.getName() + " utilise Coup de Rage et inflige " + damages + " dommages");
        character.takeDamages(damages);
        this.takeDamages(sideEffects);
    }
}
