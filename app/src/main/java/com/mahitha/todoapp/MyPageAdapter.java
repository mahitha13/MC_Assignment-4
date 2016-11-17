package com.mahitha.todoapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyPageAdapter extends PagerAdapter {


    private List<TodoTask> todoTaskList;
    private Context context;


    public MyPageAdapter(Context context, List<TodoTask> todoTaskList){
        this.context = context;
        this.todoTaskList = todoTaskList;
    }

    @Override
    public int getCount() {
        return todoTaskList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TodoTask todoTask = todoTaskList.get(position);
        View layout = LayoutInflater.from(context).inflate(R.layout.activity_todo_task_view,container,false);
        TextView titleView = (TextView) layout.findViewById(R.id.tv_title);
        TextView detailsView = (TextView) layout.findViewById(R.id.tv_details);
        titleView.setText(todoTask.getTitle());
        detailsView.setText(todoTask.getDetail());
        container.addView(layout);
        return todoTask;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return todoTaskList.get(position).getTitle();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        TextView titleView = (TextView) view.findViewById(R.id.tv_title);
        TodoTask todoTask = (TodoTask) object;
        return titleView.getText() == todoTask.getTitle();
    }
}
