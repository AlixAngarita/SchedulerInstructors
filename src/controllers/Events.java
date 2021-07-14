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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DB_conn;
import models.Event;


/**
 *
 * @author andre
 */
public class Events {
    
    private Connection getConnection(){
        DB_conn databaseConnection = null;
        try {
            databaseConnection = DB_conn.getInstance();
            
        } catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return databaseConnection.getConnection();
    }
    
    public List<Event> findAllEvents(){
        
        Connection db = getConnection();
        List<Event> events = new ArrayList<>();
        Statement stmt;
        try {
            stmt = db.createStatement();
            ResultSet rs=stmt.executeQuery("select * from events"); 
            while(rs.next()){
                Event i = new Event(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                events.add(i);
            }
            db.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }
    
    /**
     * 
     * @param idInstructor
     * @return 
     */
    
    public List<Event> EventsPerInstructor(int idInstructor){
        
        Connection db = getConnection();
        List<Event> events = new ArrayList<>();
        try {
            PreparedStatement pstmt = db.prepareStatement("select * from events where events.instructor = ? ORDER BY start_date");
            pstmt.setInt(1, idInstructor);
            ResultSet rs=pstmt.executeQuery(); 
            while(rs.next()){
                Event i = new Event(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                events.add(i);
            }
            db.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }
    
    public List<Event> EventsPerInstructor(int idInstructor, int month){
        
        Connection db = getConnection();
        List<Event> events = new ArrayList<>();
        try {
            PreparedStatement pstmt = db.prepareStatement("SELECT * FROM events WHERE events.instructor = ? AND (MONTH(start_date) = ? OR MONTH(end_date) = ?) ORDER BY start_date");
            pstmt.setInt(1, idInstructor);
            pstmt.setInt(2, month);
            pstmt.setInt(3, month);
            ResultSet rs=pstmt.executeQuery(); 
            while(rs.next()){
                Event i = new Event(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                events.add(i);
            }
            db.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }
    
    public Event createEvent(Date start, Date end, String type, String description, int instructor) {
        boolean eventWithConflicts = this.checkConflicts(instructor, -1, start, end);
        Connection db = getConnection();
        if(type.equals("") || start == null || end == null || start.after(end) ) {
            return null;
        }
        
        Event evt = new Event(start, end, type, description, instructor);
        evt.setOverlap(eventWithConflicts);
        
        String sql = "INSERT INTO events (start_date, end_date, type, description, instructor) VALUES (?, ?, ?, ?, ?)";
                
        java.sql.Date startSql = new java.sql.Date(start.getTime());
        java.sql.Date endSql = new java.sql.Date(end.getTime());
        
        PreparedStatement statement;
        try {
            statement = db.prepareStatement(sql);
            statement.setDate(1, startSql);
            statement.setDate(2, endSql);
            statement.setString(3, type);
            statement.setString(4, description);
            statement.setString(5, String.valueOf(instructor));
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new event was inserted successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evt;
    }
    
    public boolean deleteEvent(int id){
        Connection db = getConnection();
        String sql = "DELETE FROM events WHERE id_event=?";
 
        PreparedStatement statement;
        try {
            statement = db.prepareStatement(sql);
            statement.setString(1, String.valueOf(id));

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An event was deleted successfully");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateEvent(int id, Date start, Date end, String type, String description, int instructor){
        if(this.checkConflicts(instructor, id, start, end))
            return false;
        
        Connection db = getConnection();
        
        if(type.equals("") || start == null || end == null || start.after(end) ) {
            return false;
        }
        
        String sql = "UPDATE events SET start_date=?, end_date=?, type=?, description=?, instructor=? WHERE id_event=?";
 
        java.sql.Date startSql = new java.sql.Date(start.getTime());
        java.sql.Date endSql = new java.sql.Date(end.getTime());
        
        PreparedStatement statement;
        try {
            statement = db.prepareStatement(sql);
            statement.setDate(1, startSql);
            statement.setDate(2, endSql);
            statement.setString(3, type);
            statement.setString(4, description);
            statement.setString(5, String.valueOf(instructor));
            statement.setString(6, String.valueOf(id));
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("An existing event was updated successfully!");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int totalDaysPerInstructor(int idInstructor){
        
        Connection db = getConnection();
        int days = 0;
        
        try {
            PreparedStatement pstmt = db.prepareStatement("select start_date,end_date from events where instructor = ?");
            pstmt.setInt(1, idInstructor);
            ResultSet rs=pstmt.executeQuery(); 
            while(rs.next()){
                long diff = Math.abs(rs.getDate(2).getTime()-rs.getDate(1).getTime());
                days += TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            }
            db.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Instructors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return days;
    }
    
    private boolean checkConflicts(int idInstructor, int idEvent, Date start, Date end)
    {
        Events events1 = new Events();
        List<Event> allEvents1 = events1.EventsPerInstructor(idInstructor);
         
        for (Event e: allEvents1 ) {
            //System.out.println(e.toString());
            if(( start.before(e.getEnd()) && end.after(e.getStart()) ) && e.getId() != idEvent)
                return true;
        }
        return false;
    }
}