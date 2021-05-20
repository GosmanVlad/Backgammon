package com.backgammon.game;

import java.util.ArrayList;

public class Game {

    private String currentPlayer;
    private ArrayList<Integer> topSlots;
    private ArrayList<Integer> bottomSlots;
    private Table table;
    private Dice dice;

    public Game() {
        this.dice = new Dice();
        this.table = new Table();
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
