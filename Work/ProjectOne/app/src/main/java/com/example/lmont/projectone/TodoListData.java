package com.example.lmont.projectone;

import java.util.ArrayList;

/**
 * Created by lmont on 8/16/2016.
 */
public class TodoListData {

    public ArrayList<TodoList> lists = new ArrayList<>();

    private static TodoListData ourInstance = new TodoListData();

    public static TodoListData getInstance() {
        return ourInstance;
    }

    private TodoListData() {
        lists = new ArrayList<>();
    }

    public TodoList getTodoListAt(int i) {
        return lists.get(i);
    }

}
