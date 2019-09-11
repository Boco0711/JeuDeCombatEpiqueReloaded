package com.ocr.sylvain.Character;

import com.ocr.sylvain.Tools;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void Given_Warrior100Strenght100_When_AppearanceIsCalled_Then_DisplayCorrectSentence() {
        System.setIn(new ByteArrayInputStream("100\n100\n0\n0\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Warrior("Boco");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Boco niveau 100 je possède 500 de vitalité, 100 de force, 0 d'agilité et 0 d'intelligence !", output[4]);
    }

    @Test
    void Given_Prowler88Agility88_When_AppearanceIsCalled_Then_DisplayCorrectSentence() {
        System.setIn(new ByteArrayInputStream("88\n0\n88\n0\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Prowler("Boco");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Shhhh je suis le Rôdeur Boco niveau 88 je possède 440 de vitalité, 0 de force, 88 d'agilité et 0 d'intelligence !", output[4]);
    }

    @Test
    void Given_Mage66Intelligence66_When_AppearanceIsCalled_Then_DisplayCorrectSentence() {
        System.setIn(new ByteArrayInputStream("66\n0\n0\n66\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Mage("Boco");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Abracadabra je suis le Mage Boco niveau 66 je possède 330 de vitalité, 0 de force, 0 d'agilité et 66 d'intelligence !", output[4]);
    }

    @Test
    void Given_50_When_TakeDamageIsCalled_Then_DisplayCorrectSentence() {
        System.setIn(new ByteArrayInputStream("66\n0\n0\n66\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Mage("Boco");
        joueur1.takeDamages(50);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Boco perd 50 points de vie", output[5]);
    }

    @Test
    void Given_42_When_GainAgilityIsCalled_GetCorrectValue() {
        System.setIn(new ByteArrayInputStream("84\n0\n84\n0\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Prowler("Boco");
        joueur1.gainAgility(42);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertTrue(joueur1.getAgility() == 126);
    }

    @Test
    void Given_100_When_GainHpIsCalled_Then_GetCorrectValue() {
        System.setIn(new ByteArrayInputStream("50\n0\n0\n50\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Prowler("Boco");
        joueur1.takeDamages(150);
        joueur1.gainHp(100);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertTrue(joueur1.getVitality() == 200);
    }

    @Test
    void Given_TooMuch_When_GainHpIsCalled_Then_GetCorrectValue() {
        System.setIn(new ByteArrayInputStream("50\n0\n0\n50\n".getBytes()));
        Character joueur1 = null;
        joueur1= new Prowler("Boco");
        joueur1.takeDamages(20);
        joueur1.gainHp(100);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertTrue(joueur1.getVitality() == 250);
    }

}