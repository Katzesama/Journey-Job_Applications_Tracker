package com.example.journey.ui.ApplicationInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.journey.ApplicationInfoActivity;
import com.example.journey.MainActivity;
import com.example.journey.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddApplicationFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_application_add, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Clicking the add button will jump to the add application activity
        super.onActivityCreated(savedInstanceState);
        Button saveButton = ((AppCompatActivity) getActivity()).findViewById(R.id.save_button);
        saveButton.setVisibility(View.VISIBLE);
        saveButton.setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(((AppCompatActivity) getActivity()), MainActivity.class);
            getActivity().startActivity(intent);
        });
    }
}