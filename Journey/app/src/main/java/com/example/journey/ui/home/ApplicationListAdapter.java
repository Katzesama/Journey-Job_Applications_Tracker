package com.example.journey.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journey.Application;
import com.example.journey.ApplicationController;
import com.example.journey.R;

import java.util.ArrayList;

public class ApplicationListAdapter extends RecyclerView.Adapter<ApplicationListAdapter.ViewHolder> {

    private ArrayList<Application> applicationsList;
    private Context mainContext;

    public ApplicationListAdapter(ArrayList<Application> applicationsList, Context context) {
        this.applicationsList = applicationsList;
        this.mainContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jobTitle;
        private TextView companyName;
        private TextView Time;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            jobTitle = itemView.findViewById(R.id.job_title);
            companyName = itemView.findViewById(R.id.company);
            Time = itemView.findViewById(R.id.time);
        }

        @Override
        public void onClick(View view) {
            //Intent viewApplication = new Intent(mainContext, ViewHabitDetailActivity.class);
            //ApplicationController.getInstance().viewHabit(getAdapterPosition());
            //((Activity)mainContext).startActivityForResult(viewHabit, MainActivity.VIEW_HABIT_REQUEST);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_application, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Application application = applicationsList.get(position);
        holder.jobTitle.setText(application.getJobTitle());
        holder.companyName.setText(application.getCompany());
        holder.Time.setText(application.getAppliedDate().toString());
    }

    @Override
    public int getItemCount() {
        return applicationsList.size();
    }

}
