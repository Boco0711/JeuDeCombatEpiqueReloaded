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
}
