package com.example.lmont.projectone;

import java.util.Calendar;

/**
 * Created by lmont on 8/18/2016.
 */
public class TodoItem {
    String name;
    String about;
    boolean iAmATask;
    Calendar mCalendar;

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public Calendar getmCalendar() {return mCalendar;}
}
