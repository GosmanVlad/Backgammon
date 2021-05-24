package com.backgammon.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOGames {

    Database database;

    public DAOGames(Database database){
        this.database= database;
    }

    public void addGame(Games games) throws SQLException {
        String query = "INSERT INTO games (name1, name2, winner) VALUES(?,?,?)";
        PreparedStatement ps = database.con.prepareStatement(query);
        ps.setString(1,games.getPlayer1());
        ps.setString(2,games.getPlayer2());
        ps.setString(3, games.getWinner());
        ps.executeUpdate();
        System.out.println("The players " + games.getPlayer1() +" and " + games.getPlayer2() + " are added to the database");
    }
}