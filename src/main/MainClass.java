/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.Events;
import controllers.Instructors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DB_conn;
import models.Instructor;
import views.Scheduler;

/**
 *
 * @author andre
 */


public class MainClass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]){  
        
        //initial data
        Instructors instructors = new Instructors();
        List<Instructor> listInstructors = instructors.findAllInstructors();
        
        if(listInstructors.isEmpty())
        {
            initializeDatabase(instructors);
        }

        Scheduler schedule = new Scheduler();
        schedule.setVisible(true);
    }
    
    private static void initializeDatabase(Instructors instructors) {
        
        //instructors
        instructors.createInstructor("Carlos", "Fuentes", new java.sql.Date(1970 - 1900, 5, 12));
        instructors.createInstructor("Juliana", "Marin", new java.sql.Date(1981 - 1900, 11, 1));
        instructors.createInstructor("Miguel", "Torres", new java.sql.Date(1998 - 1900, 3, 4));
        instructors.createInstructor("Rodrigo", "Gutierrez", new java.sql.Date(1990 - 1900, 9, 18));
        instructors.createInstructor("Angelica", "Cruz", new java.sql.Date(1990 - 1900, 1, 22));
        
        Events events = new Events();
        //week off
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), "Holiday", "", 1);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), "Holiday", "", 2);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), "Holiday", "", 3);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), new GregorianCalendar(2021, Calendar.JULY, 30).getTime(), "Holiday", "", 4);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), "Holiday", "", 5);
        
        //two seminars of one week
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), "Seminar", "First seminar", 1);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), "Seminar", "First seminar", 2);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), new GregorianCalendar(2021, Calendar.JULY, 30).getTime(), "Seminar", "First seminar", 3);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), "Seminar", "First seminar", 4);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), "Seminar", "First seminar", 5);
        
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), "Seminar", "Second seminar", 1);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), new GregorianCalendar(2021, Calendar.JULY, 30).getTime(), "Seminar", "Second seminar",2);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), "Seminar", "Second seminar", 3);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), "Seminar", "Second seminar", 4);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), "Seminar", "Second seminar", 5);
        
        //project week
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), new GregorianCalendar(2021, Calendar.JULY, 30).getTime(), "Project", "Demo Client x", 1);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), "Project", "Demo Client x", 2);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 7).getTime(), new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), "Project", "Demo Client x", 3);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 14).getTime(), new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), "Project", "Demo Client x", 4);
        events.createEvent(new GregorianCalendar(2021, Calendar.JULY, 21).getTime(), new GregorianCalendar(2021, Calendar.JULY, 30).getTime(), "Project", "Demo Client x", 5);
    }
}
