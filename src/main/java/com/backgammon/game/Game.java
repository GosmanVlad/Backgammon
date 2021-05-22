package com.backgammon.game;

import com.backgammon.game.common.Design;

import java.util.ArrayList;

public class Game {

    private String currentPlayer;
    private Table table;
    private Dice dice;
    private boolean selectFrom;
    private Design design;

    public Game() {
        this.dice = new Dice();
        this.table = new Table();
        currentPlayer = "WHITE";
        selectFrom = true;
    }

    public void refreshDesign() {
        design.refresh();
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

    public boolean isSelectFrom() {
        return selectFrom;
    }

    public void setSelectFrom(boolean selectFrom) {
        this.selectFrom = selectFrom;
    }
}
