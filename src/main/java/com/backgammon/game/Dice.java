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
        clearNumbers();
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

    public void clearNumbers(){
        for (int numberIndex =0; diceNumbers.size() != 0; numberIndex++){
            diceNumbers.remove(0);
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

    public boolean containsDiceNumber(int number) {
//        for(int diceIndex = 0; diceIndex < getDiceNumbers().size(); diceIndex++){
//            if(diceNumbers.get(diceIndex) == number)
//                return true;
//        }
//        return false;
        System.out.println(diceNumbers.size()+ " size");
        return diceNumbers.contains(number);
    }

    public void deleteDiceNumber(int dice) {
        System.out.println("DICE REMOVE " + dice);
        diceNumbers.remove(diceNumbers.indexOf(dice));
    }

    public int checkNumberOnDice(int number) {
        int smallNumber;

        /* Daca nu a fost facuta nici o mutare */
        if(diceNumbers.size() > 1) {
            if(diceNumbers.get(0) == diceNumbers.get(1)) {
                return diceNumbers.get(1);
            }

            if(diceNumbers.get(0) < diceNumbers.get(1)) {
                smallNumber = diceNumbers.get(0);
            }
            else {
                smallNumber = diceNumbers.get(1);
            }

            /* Daca numarul coincide cu un numar de pe zar */
            if(number <= smallNumber)
                return smallNumber;
            else if(number < diceNumbers.get(0) && number < diceNumbers.get(1)) {
                if(diceNumbers.get(0) < diceNumbers.get(1)) {
                    return diceNumbers.get(0);
                }
                else {
                    return diceNumbers.get(1);
                }
            }
        }
        else {
            return diceNumbers.get(0);
        }
        return 0;
    }

    public boolean checkDice(int num){
        if (diceNumbers.size() >1) {
            if (num > diceNumbers.get(0) || num > diceNumbers.get(1)) {
                return false;
            }
        }
        else{
            if (num > diceNumbers.get(0)){
                return false;
            }
        }
        return true;
    }

    public String whoMoves() {
        roll();

        /* Daca ambele zaruri sunt la fel => nu incepe nimeni, se arunca din nou */
        while(diceNumbers.get(0) == diceNumbers.get(1)) {
            clearNumbers();
            roll();
        }

        if(diceNumbers.get(0) > diceNumbers.get(1))
            return "BLACK";
        else
            return "WHITE";
    }
}
