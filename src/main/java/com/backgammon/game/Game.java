package com.backgammon.game;

import com.backgammon.game.common.Design;

import java.util.ArrayList;

public class Game {

    private String currentPlayer;
    private Table table;
    private Dice dice;
    private boolean firstSelect;
    private Design design;

    private int slotFrom=100;
    private int slotTo=100;

    private boolean moveDone;
    public Game() {
        this.dice = new Dice();
        this.table = new Table();
        currentPlayer = dice.whoMoves();
        firstSelect = true;
    }

    public void refreshDesign() {
        design.refresh();
    }

    public void addDesign(Design gui) {
        design = gui;
    }

    public void getDesireMove(int slot) {
        /* Verificam click-ul jucatorului - daca click-ul a fost pentru a selecta piesa sau pentru a o muta */
        if(firstSelect) {
            slotFrom = slot;
            firstSelect = false;
        }
        else {
            slotTo = slot;
            firstSelect = true;
        }

        if(firstSelect) {
            gameMonitor();
        }
    }

    public void gameMonitor() {
        if(!moveDone) {
            if(moveOption()) {
                if(checkPossibleMove(slotFrom, slotTo)) {
                    movePiece(slotFrom, slotTo);
                    refreshDesign();

                    //Daca jucatorul a terminat de mutat, zarurile vor fi aruncate de celalalt jucator
                    if(dice.getDiceSize() == 0) {
                        switchTurns();
                    }
                }
                else {
                    System.out.println("Mutare imposibila");
                    refreshDesign();
                }
            }
            else {
                System.out.println("Jucatorul este blocat! Switch turns..");
                switchTurns();
            }
        }
    }

    public void movePiece(int from, int to) {
        if (table.pieceInHome(currentPlayer)) {
            if (currentPlayer == "BLACK")
                dice.deleteDiceNumber(dice.checkNumberOnDice(Math.abs(from - to)));
            else if (currentPlayer == "WHITE")
                dice.deleteDiceNumber(dice.checkNumberOnDice(Math.abs(from - to)));

            table.getSlots().get(to).addStone();
            table.getSlots().get(to).setColor(currentPlayer);
            table.getSlots().get(from).removeSlot();
            return;
        }
        table.getSlots().get(from).removeSlot();
        if (table.getSlots().get(from).getStones() == 0 && from != 7 && from != 25) {
            table.getSlots().set( table.getSlots().indexOf(from) , new Slot());
            dice.deleteDiceNumber(Math.abs(from - to));
        }
        else {
            dice.deleteDiceNumber(Math.abs(from - to));
        }
    }

    public boolean checkPossibleMove(int from, int to) {
        System.out.println("TestFROM: " + from + "SlotTo: " + to);
        /* Daca slotul selectat = slot tinta, nu se va face mutarea */
        if(from == to) {
            return false;
        }

        /* Daca slotul tinta este o mutare valida */
        if(table.getSlots().get(to).getColor() != currentPlayer && table.getSlots().get(to).getColor() != "NONE" && table.getSlots().get(to).getStones() != 1) {
            System.out.println("TEST1 - " + from + " " + to + " " + table.getSlots().get(to).getColor() + " " + currentPlayer + " " + table.getSlots().get(to).getStones());
            return false;
        }

        /* Daca slotul selectat este culoarea jucatorului */
        if(table.getSlots().get(from).getColor() != currentPlayer) {
            System.out.println("TEST2");
            return false;
        }

        /* Daca piesa nu este in casa (nu urmeaza sa fie scoasa de pe table) si nu este nici pe margine (mancata) */
        if(!table.pieceInHome(currentPlayer)) {
            if(!table.onSide(currentPlayer)) {

                /* Daca numarul de sloturi peste care sare piesa este diferit de un numar dat de zar */
                if(!dice.containsDiceNumber(Math.abs(from-to))) {
                    System.out.println("TEST3");
                    return false;
                }

                /* Daca mutarea se face pe unul dintre sloturile de pe tabla */
                if(from > 26 || from < 1 || to > 26 || to < 1) {
                    System.out.println("TEST4");
                    return false;
                }

                /* Daca mutarea este in directia corecta */
                if(currentPlayer == "BLACK") {
                    if(to <= from) {
                        System.out.println("TEST5");
                        return false;
                    }
                }
                else if(currentPlayer == "WHITE") {
                    if(to >= from) {
                        System.out.println("TEST6");
                        return false;
                    }
                }
            }
            else {
                if(currentPlayer == "BLACK") {
                    /* Daca jucatorul incearca sa mute o alta piesa in afara de cea de pe margine */
                    if(from != 7) {
                        System.out.println("TEST7");
                        return false;
                    }

                    /* Daca destinatia piesei apartine unui slot de pe tabla / o mutare valida */
                    if(to > 6 || to < 1) {
                        System.out.println("TEST8");
                        return false;
                    }
                }
                else if(currentPlayer == "WHITE") {
                    if(from != 20) {
                        System.out.println("TEST9");
                        return false;
                    }

                    if(to < 21 || to > 26) {
                        System.out.println("TEST10");
                        return false;
                    }
                }
            }
        }
        else {
            /* Daca piesa se afla pe tabla - nu este deja scoasa */
            if(from > 26) {
                System.out.println("TEST11");
                return false;
            }

            if(currentPlayer == "BLACK") {
                if(to <= from) {
                    System.out.println("TEST12");
                    return false;
                }

                if ((to-1)-from > dice.checkNumberOnDice((to-1)-from)) {
                    System.out.println("TEST13");
                    return false;
                }
            }
            else {
                if(!dice.checkDice(from-to)) {
                    System.out.println("TEST14");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean moveOption() {
        boolean valid = false;
        if(currentPlayer == "BLACK") {
            if(!table.pieceInHome(currentPlayer)) {
                for (int pieceIndex = 0; pieceIndex < 26; pieceIndex++) {
                    int targetSlot = pieceIndex + dice.getDiceNumbers().get(0);
                    if (targetSlot < 29) {
                        if (checkPossibleMove(pieceIndex, targetSlot)) {
                            return true;
                        }
                    }
                    if (dice.getDiceSize() > 1) {
                        targetSlot = pieceIndex + dice.getDiceNumbers().get(1);
                        if (targetSlot < 29) {
                            if (dice.getDiceSize() > 1) {
                                if (checkPossibleMove(pieceIndex, targetSlot)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            else {
                valid = true;
            }
        }
        if(currentPlayer == "WHITE") {
            if(!table.pieceInHome(currentPlayer)) {
                for (int pieceIndex = 0; pieceIndex < 26; pieceIndex++) {
                    int temp = pieceIndex - dice.getDiceNumbers().get(0);
                    if (temp > 0) {
                        if (checkPossibleMove(pieceIndex, temp)) {
                            return true;
                        }
                    }
                    if (dice.getDiceSize() > 1) {
                        temp = pieceIndex - dice.getDiceNumbers().get(1);
                        if (temp > 0) {
                            if (dice.getDiceSize()  > 1) {
                                if (checkPossibleMove(pieceIndex, temp)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }else{
                valid = true;
            }
        }
        return valid;
    }

    public void switchTurns() {
        if(currentPlayer == "WHITE")
            currentPlayer = "BLACK";
        else
            currentPlayer = "WHITE";
        dice.roll();
        moveDone = table.isGameOver();
        refreshDesign();
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

    public boolean isFirstSelect() {
        return firstSelect;
    }

    public void setFirstSelect(boolean firstSelect) {
        this.firstSelect = firstSelect;
    }

    public boolean isMoveDone() {
        return moveDone;
    }

    public void setMoveDone(boolean moveDone) {
        this.moveDone = moveDone;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
