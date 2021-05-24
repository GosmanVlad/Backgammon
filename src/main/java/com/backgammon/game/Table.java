package com.backgammon.game;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<Slot> slots;

    public Table() {
        slots = new ArrayList<Slot>();
        createSlotsForEveryStone();
        addStones();
    }

    public void createSlotsForEveryStone() {
        for(int slotID = 0; slotID < 28; slotID++)
            slots.add(new Slot());
    }

    public void addStones() {
        slots.get(0).setColor("BLACK");
        slots.get(0).setStones(0);

        slots.get(1).setColor("BLACK");
        slots.get(1).setStones(2);
        slots.get(6).setColor("WHITE");
        slots.get(6).setStones(5);
        slots.get(9).setColor("WHITE");
        slots.get(9).setStones(3);
        slots.get(13).setColor("BLACK");
        slots.get(13).setStones(5);
        slots.get(14).setColor("WHITE");
        slots.get(14).setStones(5);
        slots.get(18).setColor("BLACK");
        slots.get(18).setStones(3);
        slots.get(21).setColor("BLACK");
        slots.get(21).setStones(5);
        slots.get(26).setColor("WHITE");
        slots.get(26).setStones(2);

        slots.get(27).setColor("WHITE");
        slots.get(27).setStones(0);

        slots.get(20).setColor("BLACK");
        slots.get(20).setStones(0);

        slots.get(7).setColor("WHITE");
        slots.get(7).setStones(0);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    /* In functie de jucatorul curent se verifica daca acesta mai are piese in afara tablei
        Casa jucatorului Black este in dreapta sus (se verifica de la cel mai mic slot pana la cel mai mare)
        Casa jucatorului White este in dreapta jos (se verifica de la cel mai mare slot la cel mai mic)
     */
    public boolean pieceInHome(String player) {
        if(player == "BLACK") {
            for (int piecePos = 0; piecePos < 21; piecePos++) {
                if (slots.get(piecePos).getStones() > 0 && slots.get(piecePos).getColor() == "BLACK") {
                    return false;
                }
            }
            return true;
        }
        else if(player == "WHITE") {
            for (int piecePos = 26; piecePos > 6; piecePos--) {
                if (slots.get(piecePos).getStones() > 0 && slots.get(piecePos).getColor() == "WHITE") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean onSide(String player) {
        if(player == "BLACK") {
            if(slots.get(20).getStones() > 0)
                return true;
            else
                return false;
        }
        else if(player == "WHITE") {
            if(slots.get(7).getStones() > 0)
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean isGameOver() {
        if(slots.get(27).getStones() == 15) //Black wins
            return true;
        if(slots.get(0).getStones() == 15) //White wins
            return true;
        return false;
    }

    public void moveOnSide(String player) {
        if(player == "BLACK") {
            slots.get(20).addStone();
            slots.get(20).setColor("WHITE");
        }
        else {
            slots.get(7).addStone();
            slots.get(7).setColor("BLACK");
        }
    }
}
