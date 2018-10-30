package com.example.annak.mygame;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuessTest {

    @Test
    public void testFirstGuess() {
        Guess guess = new Guess(0, 100);
        assertEquals(guess.currentGuess(), 50);
    }

    @Test
    public void testSecondGuess() {
        Guess guess = new Guess(0, 100);
        assertEquals(guess.nextGuess(true), 75);

        guess = new Guess(0, 100);
        assertEquals(guess.nextGuess(false), 25);
    }

    @Test
    public void testLastGuess() {
        Guess guess = new Guess(41, 42);
        assertTrue(guess.guessed());

        assertEquals(guess.nextGuess(true), 42);
        assertEquals(guess.nextGuess(false), 41);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegal() {
        Guess guess = new Guess(42, 42);
    }
}
