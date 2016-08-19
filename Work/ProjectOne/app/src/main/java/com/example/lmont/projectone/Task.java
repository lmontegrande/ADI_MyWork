package com.example.lmont.projectone;

import java.util.Calendar;

/**
 * Created by lmont on 8/16/2016.
 */
public class Task extends TodoItem {

    public TodoList parent;

    public Task(String name, String about, TodoList parent) {
        this.name = name;
        this.about = about;
        this.parent = parent;
        this.mCalendar = Calendar.getInstance();
        this.iAmATask = true;
    }
}
