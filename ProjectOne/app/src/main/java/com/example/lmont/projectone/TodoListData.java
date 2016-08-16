package com.example.lmont.projectone;

import java.util.ArrayList;

/**
 * Created by lmont on 8/16/2016.
 */
public class TodoListData {

    private ArrayList<List> lists = new ArrayList<>();

    private static TodoListData ourInstance = new TodoListData();

    public static TodoListData getInstance() {
        return ourInstance;
    }

    private TodoListData() {
    }


}
