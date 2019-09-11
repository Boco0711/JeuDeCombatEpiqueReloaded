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

    /**
     * Display a question, get the result by askSomething, and create a Warrior, Prowler or Mage depending on the choice
     * @param name the name of the Character
     * @return Character(Warrior or Mage or Prowler)
     */
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

    /**
     * A loop that last as long as both Character are alive
     * It display a question about the comp to use one player after the other.
     * Depending on choice it call basicAttack() or specialAttack()
     */
    public void Combat() {
        boolean bothAlive = true;
        while (bothAlive) {
            for (int i = 0; i < this.players.length; i++) {
                String question = this.players[i].getName() + " (" + this.players[i].getVitality() + ") veuillez choisir votre action (1 : Attaque basique, 2 : Attaque Spéciale)";
                String error = "Votre choix n'est pas valide veuillez choisir 1 ou 2";
                int choice = Tools.askSomething(question, error, 1, 2);
                switch (choice) {
                    case 1:
                        this.players[i].basicAttack(players[i == 0 ? 1 : 0]);
                        break;
                    case 2:
                        this.players[i].specialAttack(players[i == 0 ? 1 : 0]);
                        break;
                }
                if (this.players[0].getVitality() <= 0) {
                    System.out.println(this.players[0].getName() + " a perdu !");
                    bothAlive = false;
                    break;
                } else if (this.players[1].getVitality() <= 0) {
                    System.out.println(this.players[1].getName() + " a perdu !");
                    bothAlive = false;
                    break;
                }
            }
        }
    }
}
