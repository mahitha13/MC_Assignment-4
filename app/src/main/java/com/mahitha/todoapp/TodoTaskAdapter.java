package com.mahitha.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskAdapter.TodoTaskViewHolder> {

    private List<TodoTask> todoTaskList;
    private Context context;
    public TodoTaskAdapter(Context context, List<TodoTask> todoTaskList) {
        this.todoTaskList = todoTaskList;
        this.context = context;
    }


    @Override
    public TodoTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View todoTaskView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_todo_list_box, parent,false);
        return new TodoTaskViewHolder(todoTaskView);
    }

    @Override
    public void onBindViewHolder(TodoTaskViewHolder holder, int position) {
        TodoTask todoTask = todoTaskList.get(position);
        holder.titleListTextView.setText(todoTask.getTitle());
    }

    public void remove(int position) {
        todoTaskList.remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition){
        Collections.swap(todoTaskList, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    @Override
    public int getItemCount() {
        return todoTaskList.size();
    }

    public class TodoTaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleListTextView;

      //  public ImageButton upButton;
        public TodoTaskViewHolder(View todoTaskView) {
            super(todoTaskView);
           // final TodoTask todoTask = todoTaskList.get(this.getAdapterPosition());
            titleListTextView = (TextView) todoTaskView.findViewById(R.id.todo_title);

            todoTaskView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,TodoViewPager.class);
            intent.putExtra("check",getAdapterPosition());
            context.startActivity(intent);
        }

    }
}
