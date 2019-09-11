package com.ocr.sylvain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ToolsTest {

    String question = "Niveau du personnage ?";
    String error = "Le niveau doit être compris entre 1 et 100";

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
    public void Given_GoodValue_When_AskSomethingIsRun_Then_ReturnCorrectResult() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        int min = 1;
        int max = 100;
        int result = Tools.askSomething(question, error, min, max);
        assertEquals(1, result);
    }

    @Test
    public void Given_TooHighValue_When_AskSomethingIsRun_Then_SendErrorAndReAsk() {
        System.setIn(new ByteArrayInputStream("101\n5\n".getBytes()));
        int min = 1;
        int max = 100;
        int result = Tools.askSomething(question, error, min, max);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(error, output[1]);
        assertEquals(question, output[2]);
        assertEquals(5, result);
    }

    @Test
    public void Given_TooLowValue_When_AskSomethingIsRun_Then_SendErrorAndReAsk() {
        System.setIn(new ByteArrayInputStream("0\n51\n".getBytes()));
        int min = 1;
        int max = 100;
        int result = Tools.askSomething(question, error, min, max);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(error, output[1]);
        assertEquals(question, output[2]);
        assertEquals(51, result);
    }

    @Test
    public void Given_Text_When_AskSomethingIsRun_Then_SendErrorAndReAsk() {
        System.setIn(new ByteArrayInputStream("Toto\n75\n".getBytes()));
        int min = 1;
        int max = 100;
        int result = Tools.askSomething(question, error, min, max);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(error, output[1]);
        assertEquals(question, output[2]);
        assertEquals(75, result);
    }

    @Test
    public void Given_MultipleBadValue_When_AskSomethingIsRun_Then_SendErrorAndReAsk() {
        System.setIn(new ByteArrayInputStream("0\n105\n51\n".getBytes()));
        int min = 1;
        int max = 100;
        int result = Tools.askSomething(question, error, min, max);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(error, output[1]);
        assertEquals(question, output[2]);
        assertEquals(error, output[3]);
        assertEquals(question, output[4]);
        assertEquals(51, result);
    }
}