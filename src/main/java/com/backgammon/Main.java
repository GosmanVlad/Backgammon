package com.backgammon;

import com.backgammon.gui.GUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Backgammon Game");
        gameFrame.setSize(800, 600);
        gameFrame.add(new GUI());
        gameFrame.setVisible(true);
    }
}
