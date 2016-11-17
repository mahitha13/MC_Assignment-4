package com.mahitha.todoapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class TodoTouchHelper extends ItemTouchHelper.SimpleCallback {
    private TodoTaskAdapter mTodoTaskAdapter;

    public TodoTouchHelper(MyPageAdapter adapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//        this.mTodoTaskAdapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mTodoTaskAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mTodoTaskAdapter.remove(viewHolder.getAdapterPosition());
    }
}