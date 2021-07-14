package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DB_conn {
    private static DB_conn instance;
    private Connection conn = null;

    public DB_conn() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mint_schedule?zeroDateTimeBehavior=CONVERT_TO_NULL","root","mysql");
    }
    
    public Connection getConnection() {
        return conn;
    }

    public static DB_conn getInstance() throws SQLException {
        if (instance == null) {
            instance = new DB_conn();
        } else if (instance.getConnection().isClosed()) {
            instance = new DB_conn();
        }

        return instance;
    }
}
