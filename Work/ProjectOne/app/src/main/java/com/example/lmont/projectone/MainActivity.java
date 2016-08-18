package com.example.lmont.projectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TodoListData todoListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    protected void setUp() {
        todoListData = TodoListData.getInstance();
        setUpMockData();
        
    }

    protected void setUpMockData() {
        List groceries = new List("Groceries", "Buy Groceries");
        groceries.tasks.add(new Task("Apple", "We're out of apples"));
        groceries.tasks.add(new Task("Banana", "Girlfriend wanted some"));
        List toDo = new List("ToDo", "What to do");
        toDo.tasks.add(new Task("Clean Dog", "He smells"));
        toDo.tasks.add(new Task("Wash Car", "Damn thing is dirty"));
        todoListData.lists.add(groceries);
        todoListData.lists.add(toDo);
    }
}
