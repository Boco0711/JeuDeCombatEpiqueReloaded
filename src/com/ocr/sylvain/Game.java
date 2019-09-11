package com.ocr.sylvain;

import com.ocr.sylvain.Character.Character;
import com.ocr.sylvain.Character.Mage;
import com.ocr.sylvain.Character.Prowler;
import com.ocr.sylvain.Character.Warrior;

import java.util.Scanner;

public class Game {
    private Scanner sc;
    private Character[] players;

    public Game() {
        this.sc = new Scanner(System.in);
        this.players = new Character[2];

        for (int i = 0; i < 2; i++) {
            this.players[i] = roleSelect("Joueur " + (i + 1));
        }
    }

    private Character roleSelect(String name) {
        System.out.println("Création du personnage du " + name);
        String question = "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rodeur; 3 : Mage)";
        String error = "Vous n'avez pas choisi de classe parmi les choix proposés";
        int min = 1;
        int max = 3;
        int choix = Tools.askSomething(question, error, min, max);

        Character character = null;
        switch (choix) {
            case 1:
                character = new Warrior(name);
                break;
            case 2:
                character = new Prowler(name);
                break;
            case 3:
                character = new Mage(name);
                break;
        }
        return character;
    }
}
