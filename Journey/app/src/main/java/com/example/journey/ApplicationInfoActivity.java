package com.example.journey;

import android.os.Bundle;

import com.example.journey.ui.ApplicationInfo.AddApplicationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.content.Intent;

public class ApplicationInfoActivity extends AppCompatActivity {
    private Fragment addFragment = new AddApplicationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_info);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String fragmentToDisplay = getIntent().getStringExtra("fragmentToDisplay");
        switch (fragmentToDisplay) {
            case "Add":
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, addFragment);
                transaction.commit();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(ApplicationInfoActivity.this, MainActivity.class));
        return super.onOptionsItemSelected(item);

    }


}