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
}
