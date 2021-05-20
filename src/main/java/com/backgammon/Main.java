package com.backgammon;

import com.backgammon.game.Game;
import com.backgammon.game.Table;
import com.backgammon.gui.GUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Backgammon Game");
        gameFrame.setSize(800, 600);
        gameFrame.add(new GUI(new Game()));
        gameFrame.setVisible(true);
    }
}
