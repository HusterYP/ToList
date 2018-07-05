package com.example.yuanping.todolist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuanping.todolist.R;
import com.example.yuanping.todolist.adapter.MainRecyclerViewAdapter;
import com.example.yuanping.todolist.bean.Events;

import java.util.ArrayList;
import java.util.List;

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
        List<Events> events = new ArrayList<>();
        events.add(new Events("First Title", "first content", false));
        events.add(new Events("Second Title", "second content", false));
        events.add(new Events("Third Title", "third content", true));
        events.add(new Events("Fourth Title", "fourth content", false));
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(events, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClick());
    }

    class OnItemClick implements MainRecyclerViewAdapter.OnItemClickListener {

        @Override
        public void onCommItemClick(int pos) {
            Intent intent = new Intent(getContext(), NewEvent.class);
            intent.setAction(MainRecyclerViewAdapter.COMMON_EVENTS + "");
            startActivity(intent);
        }

        @Override
        public void onFootItemClick() {
            Intent intent = new Intent(getContext(), NewEvent.class);
            intent.setAction(MainRecyclerViewAdapter.FOOTER_EVENTS + "");
            startActivity(intent);
        }
    }
}
