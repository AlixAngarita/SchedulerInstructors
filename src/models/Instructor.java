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
public class Instructor {
    private int id;
    private String first_name;
    private String last_name;
    private Date birthday;

    public Instructor(int id, String first_name, String last_name, Date birthday) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday; 
    }
    
    public Instructor(String first_name, String last_name, Date birthday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday; 
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String toString()
    {
        return this.first_name + " " + this.last_name + " " + this.birthday;
    }
    
    public String getName()
    {
        return this.first_name + " " + this.last_name;
    }
}
