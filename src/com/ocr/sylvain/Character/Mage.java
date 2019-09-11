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
}
