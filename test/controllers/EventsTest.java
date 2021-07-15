/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import models.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class EventsTest {
    
    Date eventRefStart;
    Date eventRefEnd;
    
    public EventsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        eventRefStart = new GregorianCalendar(2021, Calendar.JULY, 2).getTime();
        eventRefEnd = new GregorianCalendar(2021, Calendar.JULY, 7).getTime();
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of checkConflicts method, of class Events.
     */
    @Test
    public void testCheckConflicts() {
        System.out.println("checkConflicts");
        Events events = new Events();
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 3).getTime()));
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 5).getTime(), new GregorianCalendar(2021, Calendar.JULY, 10).getTime()));
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 4).getTime(), new GregorianCalendar(2021, Calendar.JULY, 6).getTime()));
    }
    
    @Test
    public void testCheckNOConflicts() {
        System.out.println("checkNOConflicts");
        Events events = new Events();
        assertTrue(!events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2021, Calendar.AUGUST, 3).getTime()));
    }
    
}
