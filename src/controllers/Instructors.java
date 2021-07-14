/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DB_conn;
import models.Instructor;

/**
 *
 * @author andre
 */
public class Instructors {
    
    private Connection getConnection(){
        DB_conn databaseConnection = null;
        try {
            databaseConnection = DB_conn.getInstance();
            
        } catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return databaseConnection.getConnection();
    }
    
    public List<Instructor> findAllInstructors(){
        
        Connection db = getConnection();
        List<Instructor> instructors = new ArrayList<>();
        Statement stmt;
        try {
            stmt = db.createStatement();
            ResultSet rs=stmt.executeQuery("select * from instructors"); 
            while(rs.next()){
                Instructor i = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                instructors.add(i);
            }
            db.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return instructors;
    }
    
}
