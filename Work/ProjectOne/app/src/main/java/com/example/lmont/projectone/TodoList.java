package com.example.lmont.projectone;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by lmont on 8/16/2016.
 */
public class TodoList extends TodoItem {
    ArrayList<Task> tasks;

    public TodoList(String name, String about) {
        this.name = name;
        this.about = about;
        this.iAmATask = false;
        this.mCalendar = Calendar.getInstance();
        tasks = new ArrayList<>();
    }
}
