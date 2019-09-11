package com.ocr.sylvain.Character;

public class Prowler extends Character {

    public Prowler(String name) {
        super(name);
    }

    @Override
    public void appearance() {
        System.out.print("Shhhh je suis le Rôdeur ");
        super.appearance();
    }

    @Override
    public void basicAttack(Character character) {
        int damages = this.getAgility();
        System.out.println(this.getName() + " utilise Tir à l'Arc et inflige " + damages + " dommages");
        character.takeDamages(damages);
    }

    @Override
    public void specialAttack(Character character){
        int gain = this.getLevel()/2;
        System.out.println(this.getName() + " utilise Concentration et gagne " + gain + " d'Agilité");
        this.gainAgility(gain);
    }
}
