package com.backgammon.game;

public class Slot {
    private String color;
    private int stones;

    public Slot(){
        color = "NONE";
        stones = 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public void addStone(){
        stones++;
    }

    public void removeSlot(){
        stones--;
    }
}
