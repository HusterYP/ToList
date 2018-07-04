package com.example.yuanping.todolist.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuanping.todolist.R;
import com.example.yuanping.todolist.adapter.MainRecyclerViewAdapter;

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mRecyclerView = view.findViewById(R.id.main_recyclerview);
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter();
        mRecyclerView.setAdapter(adapter);
    }
}
