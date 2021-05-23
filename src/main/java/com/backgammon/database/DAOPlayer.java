package com.backgammon.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOPlayer {

    Database database;

    public DAOPlayer(Database database){
        this.database= database;
    }

    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, points) VALUES(?,?)";
        PreparedStatement ps = database.con.prepareStatement(query);
        ps.setString(1,player.getName());
        ps.setInt(2,player.getPoints());
        ps.executeUpdate();
        System.out.println("The player " + player.getName() + " is added to the database");
    }
}
