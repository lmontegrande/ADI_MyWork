package com.example.lmont.projectone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    TodoList currentTodoList;
    TodoListData todoListData;
    TextView headerTextView;
    Button backButton, addButton;
    ListView listView;
    TasksListAdapter tasksListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setUp();
    }

    protected void setUp() {

        headerTextView = (TextView) findViewById(R.id.headerTextView2);
        backButton = (Button) findViewById(R.id.backToListsButton);
        addButton = (Button) findViewById(R.id.addTaskButton);
        listView = (ListView) findViewById(R.id.taskListView);
        todoListData = TodoListData.getInstance();

        int taskListNum = getIntent().getIntExtra("listNum", 0);
        currentTodoList = todoListData.lists.get(taskListNum);
        headerTextView.setText(currentTodoList.name + "\n" + String.format("%1$tb %1$td %1$tY", currentTodoList.getmCalendar()));
        tasksListAdapter = new TasksListAdapter(this, currentTodoList.tasks);
        listView.setAdapter(tasksListAdapter);

        setUpButtons();
    }

    protected void setUpButtons() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
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
                        Toast.makeText(SecondActivity.this, nameEditText.getText() + " Added", Toast.LENGTH_SHORT).show();
                        currentTodoList.tasks.add(new Task(nameEditText.getText().toString(), aboutEditText.getText().toString(), currentTodoList));
                        tasksListAdapter.notifyDataSetChanged();
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

}
