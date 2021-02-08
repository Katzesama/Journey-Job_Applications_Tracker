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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_info);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String fragmentToDisplay = getIntent().getStringExtra("fragmentToDisplay");
        Fragment selectedFragment;
        switch (fragmentToDisplay) {
            case "Add":
                selectedFragment = new AddApplicationFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, selectedFragment);
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