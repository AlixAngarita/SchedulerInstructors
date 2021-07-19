/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.Events;

/**
 * @author andre
 *
 */
public class EventsTest {

	Date eventRefStart;
    Date eventRefEnd;
    
    public EventsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    @Before
    public void setUp() {
        eventRefStart = new GregorianCalendar(2021, Calendar.JULY, 2).getTime();
        eventRefEnd = new GregorianCalendar(2021, Calendar.JULY, 7).getTime();
    }
    
    /**
     * Test of checkConflicts method, of class Events.
     */
    @Test
    public void testCheckConflicts() {
        //System.out.println("checkConflicts");
        Events events = new Events();
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 1).getTime(), new GregorianCalendar(2021, Calendar.JULY, 3).getTime()));
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 5).getTime(), new GregorianCalendar(2021, Calendar.JULY, 10).getTime()));
        assertTrue(events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.JULY, 4).getTime(), new GregorianCalendar(2021, Calendar.JULY, 6).getTime()));
    }
    
    @Test
    public void testCheckNOConflicts() {
        //System.out.println("checkNOConflicts");
        Events events = new Events();
        assertTrue(!events.checkOverlapBetweenDates(eventRefStart, eventRefEnd, new GregorianCalendar(2021, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2021, Calendar.AUGUST, 3).getTime()));
    }
}
