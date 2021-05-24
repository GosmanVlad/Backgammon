package com.backgammon;

import com.backgammon.database.*;
import com.backgammon.game.Game;
import com.backgammon.game.Table;
import com.backgammon.gui.GUI;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Table table = new Table();
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Backgammon Game");
        gameFrame.setSize(800, 600);
        gameFrame.add(new GUI(new Game()));
        gameFrame.setVisible(true);

        Database database = Database.getInstance();
        DAOPlayer newPlayer = new DAOPlayer(database);

        System.out.println("Please introduce the name of the player that will play with the black stones:");
        Scanner keyboard = new Scanner(System.in);
        String firstPlayerName = keyboard.nextLine();
        Player player = new Player(firstPlayerName, 3);
        newPlayer.addPlayer(player);

        System.out.println("Please introduce the name of the player that will play with the white stones:");
        String secondPlayerName = keyboard.nextLine();
        Player player1 = new Player(secondPlayerName, 3);
        newPlayer.addPlayer(player1);

        if (table.isGameOver()) {
            Games game = new Games(firstPlayerName, secondPlayerName, table.getWinner());
            DAOGames newGame = new DAOGames(database);
            newGame.addGame(game);
        }
    }
}
