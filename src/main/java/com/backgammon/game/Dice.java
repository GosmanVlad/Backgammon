package com.backgammon.game;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private Random randomNumber;
    private ArrayList<Integer> diceNumbers;

    public Dice() {
        randomNumber = new Random();
        diceNumbers = new ArrayList<Integer>();
    }

    public void roll() {
        int firstNumber = randomNumber.nextInt(6)+1;
        int secondNumber = randomNumber.nextInt(6)+1;

        if(firstNumber == secondNumber) {
            diceNumbers.add(firstNumber);
            diceNumbers.add(firstNumber);
            diceNumbers.add(firstNumber);
            diceNumbers.add(firstNumber);
        }
        else {
            diceNumbers.add(firstNumber);
            diceNumbers.add(secondNumber);
        }
    }

    public ArrayList<Integer> getDiceNumbers() {
        return diceNumbers;
    }

    public void setDiceNumbers(ArrayList<Integer> diceNumbers) {
        this.diceNumbers = diceNumbers;
    }

    public int getDiceSize() {
        return diceNumbers.size();
    }
}
