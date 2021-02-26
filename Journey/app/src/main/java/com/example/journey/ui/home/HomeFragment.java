package com.example.journey.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.journey.Application;
import com.example.journey.ApplicationInfoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journey.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ApplicationListAdapter adapter;
    private ArrayList<Application> adapterList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Applications");
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Set Recycle View here
        adapterList = new ArrayList<>();
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ApplicationListAdapter(adapterList, getActivity());
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Clicking the add button will jump to the add application activity
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = ((AppCompatActivity) getActivity()).findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ApplicationInfoIntent = new Intent(((AppCompatActivity) getActivity()), ApplicationInfoActivity.class);
                String fragmentToDisplay = "Add";
                ApplicationInfoIntent.putExtra("fragmentToDisplay", fragmentToDisplay);
                getActivity().startActivity(ApplicationInfoIntent);
            }
        });
    }

}