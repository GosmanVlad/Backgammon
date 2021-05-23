package com.backgammon.database;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Date;

public class Database {
    private static Database singleInstance = null;
    Connection con = null;
    int batchSize = 5;

    private Database() throws SQLException, ClassNotFoundException{
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user="student";
        String pass ="STUDENT";
        try{
            this.con= DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e) ;
        }

    }

    public static Database getInstance() throws SQLException, ClassNotFoundException{
        if(singleInstance== null){
            singleInstance = new Database();
        }
        return singleInstance;
    }

}


