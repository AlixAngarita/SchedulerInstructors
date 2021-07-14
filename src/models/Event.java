/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author andre
 */
public class Event {
    private int id;
    private Date start;
    private Date end;
    private String type;
    private String description;
    private int instructor;
    private boolean overlap = false; 

    public Event(int id, Date start, Date end, String type, String description, int instructor) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.type = type;
        this.description = description;
        this.instructor = instructor;
    }
    
    public Event(Date start, Date end, String type, String description, int instructor) {
        this.start = start;
        this.end = end;
        this.type = type;
        this.description = description;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    @Override
    public String toString() {
        return "Event{" + "start=" + start + ", end=" + end + ", type=" + type + ", description=" + description + ", instructor=" + instructor + '}';
    }
    
    
}
