package com.example.annak.mygame;

public class Guess {
    private int  num1, num2;
    private int center;

    public Guess(int num1, int num2) {
        if (num2 <= num1) throw new IllegalArgumentException("Верхняя граница должна быть больше, чем нижняя!");
        this.num1 = num1;
        this.num2 = num2;
        this.center = calcCenter(num1, num2);
    }

    public boolean guessed() {
        return num2 - num1 <= 1;
    }

    public int currentGuess() {
        return center;
    }

    public int nextGuess(boolean ans) {
         if (!guessed()) { // если разница между границами больше 1
             if (ans) {
                 num1 = center;
             } else {
                 num2 = center;
             }
             return center = calcCenter(num1, num2);
         } else {
             return ans ? num2 : num1;
         }
    }

    private static int calcCenter(int n1, int n2) {
        return (n1 + n2) / 2;
    }



}
