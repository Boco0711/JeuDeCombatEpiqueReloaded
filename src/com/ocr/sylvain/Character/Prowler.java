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
}
