package com.mahitha.todoapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class TodoViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_view_pager);

        List<TodoTask> todoTaskList = MainActivity.todoTaskList;
        ViewPager todoViewPager = (ViewPager) findViewById(R.id.tv_pager);

        todoViewPager.setAdapter(new MyPageAdapter(this, todoTaskList));
        todoViewPager.setCurrentItem(getIntent().getIntExtra("check",0));
    }
}
