package com.backgammon.game;

import java.util.ArrayList;

public class Game {
    private String currentPlayer;
    private ArrayList<Integer> topSlots;
    private ArrayList<Integer> bottomSlots;

    public Game() {
        currentPlayer = "WHITE";

        topSlots = new ArrayList<Integer>();
        bottomSlots = new ArrayList<Integer>();


    }

    public void switchTurns() {
        if(currentPlayer == "WHITE")
            currentPlayer = "BLACK";
        else
            currentPlayer = "WHITE";
    }
}
