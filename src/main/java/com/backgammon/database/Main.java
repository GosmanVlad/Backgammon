package com.backgammon.database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Database database = Database.getInstance();
        DAOPlayer newPlayer = new DAOPlayer(database);

        System.out.println("Please introduce the name of the player that will play with the black stones:");
        Scanner keyboard = new Scanner(System.in);
        String firstPlayerName = keyboard.nextLine();
        Player player = new Player("Andrei",2);
        newPlayer.addPlayer(player);

        System.out.println("Please introduce the name of the player that will play with the white stones:");
        String secondPlayerName = keyboard.nextLine();
        Player player1 = new Player(secondPlayerName, 3);
        newPlayer.addPlayer(player1);


    }
}

