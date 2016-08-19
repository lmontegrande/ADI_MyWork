package com.example.lmont.projectone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TodoListData todoListData;
    Button addListButton, helpButton;
    ListView listView;
    TodoListAdapter todoListAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    protected void setUp() {
        context = this;
        todoListData = TodoListData.getInstance();
        addListButton = (Button) findViewById(R.id.addListButton);
        helpButton = (Button) findViewById(R.id.helpButton);
        listView = (ListView) findViewById(R.id.listsListView);
        setUpList();
        setButton();
        setUpMockData();
    }

    protected void setButton() {
        addListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click list to navigate\nLong click list to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void setUpList() {
        todoListAdapter = new TodoListAdapter(this, todoListData.lists);
        listView.setAdapter(todoListAdapter);
    }

    protected void showDialog() {
        LayoutInflater inflater = this.getLayoutInflater();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View dialogView = inflater.inflate(R.layout.alert_layout, null);
        builder.setView(dialogView);

        builder.setMessage("Add New")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText nameEditText = (EditText) dialogView.findViewById(R.id.nameEditText);
                        EditText aboutEditText = (EditText) dialogView.findViewById(R.id.aboutEditText);
                        Toast.makeText(MainActivity.this, nameEditText.getText() + " Added", Toast.LENGTH_SHORT).show();
                        todoListData.lists.add(new TodoList(nameEditText.getText().toString(), aboutEditText.getText().toString()));
                        todoListAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Cancel
                    }
                });

        builder.show();

    }

    static boolean isSetUp = false;
    protected void setUpMockData() {
        if (isSetUp) return;
        isSetUp = true;
        TodoList groceries = new TodoList("Groceries", "Buy Groceries");
        groceries.tasks.add(new Task("Apple", "We're out of apples", groceries));
        groceries.tasks.add(new Task("Banana", "Bobo wanted some", groceries));
        TodoList toDo = new TodoList("ToDo", "What to do");
        toDo.tasks.add(new Task("Clean Dog", "He smells", toDo));
        toDo.tasks.add(new Task("Wash Car", "Damn thing is dirty", toDo));
        todoListData.lists.add(groceries);
        todoListData.lists.add(toDo);
    }
}
