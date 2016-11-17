package com.mahitha.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTodoTask extends AppCompatActivity {


    private EditText titleText;
    private EditText detailText;
    private int todoTaskId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        titleText = (EditText) findViewById(R.id.input_title);
        detailText = (EditText) findViewById(R.id.input_detail);

    }

    public void addItem(View view){
        if(titleText.getText().toString().equals("")){
            titleText.setError("Enter Title");
            return;
        }
        if(detailText.getText().toString().equals("")){
            detailText.setError("Enter Details");
            return;
        }
        todoTaskId++;
        TodoTask todoTask = new TodoTask(titleText.getText().toString(), detailText.getText().toString(),todoTaskId);
        MainActivity.todoTaskList.add(todoTask);
        finish();
    }
}
