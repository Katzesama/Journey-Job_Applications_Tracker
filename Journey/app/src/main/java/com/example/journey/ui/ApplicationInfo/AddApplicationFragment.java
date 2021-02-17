package com.example.journey.ui.ApplicationInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.journey.ApplicationController;
import com.example.journey.MainActivity;
import com.example.journey.R;
import com.google.android.material.snackbar.Snackbar;

public class AddApplicationFragment extends Fragment {
    private EditText jobTitle;
    private EditText company;
    private EditText expectedSalary;
    private EditText postUrl;
    private EditText description;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_application_add, container, false);
        jobTitle = (EditText) root.findViewById(R.id.job_title);
        company = (EditText) root.findViewById(R.id.company);
        expectedSalary = (EditText) root.findViewById(R.id.expected_salary);
        postUrl = (EditText) root.findViewById(R.id.post_url);
        description = (EditText) root.findViewById(R.id.description);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Clicking the add button will jump back to the main activity and save the data input
        super.onActivityCreated(savedInstanceState);
        Button saveButton = ((AppCompatActivity) getActivity()).findViewById(R.id.save_button);
        saveButton.setVisibility(View.VISIBLE);
        saveButton.setOnClickListener((View.OnClickListener) view -> {
            if (checkRequiredFields()) {
                saveApplication();
                clearAllFields();
                Intent intent = new Intent(((AppCompatActivity) getActivity()), MainActivity.class);
                getActivity().startActivity(intent);
            } else{
                Snackbar.make(view, "Please fill all the required fields", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *
     * @return check indicator if all the required fields are filled
     */
    private boolean checkRequiredFields() {
        boolean check = true;
        if (jobTitle.getText().toString().trim().isEmpty()){
            jobTitle.setError("Job title required");
            check = false;
        }
        if (company.getText().toString().trim().isEmpty()){
            company.setError("Company required");
            check = false;
        }
        return check;
    }

    private void saveApplication(){
        ApplicationController controller = ApplicationController.getInstance();
        String title = jobTitle.getText().toString();
        String Company = company.getText().toString();
        String salary = expectedSalary.getText().toString();
        String url = postUrl.getText().toString();
        String descr = description.getText().toString();
        controller.createApplication(title, Company, salary, url, descr);
        controller.saveNewApplication(getActivity().getApplicationContext());
    }

    private void clearAllFields(){
        jobTitle.getText().clear();
        company.getText().clear();
        expectedSalary.getText().clear();
        postUrl.getText().clear();
        description.getText().clear();
    }
}