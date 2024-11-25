package com.example.mobilecw.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobilecw.R;

public class MainActivity extends AppCompatActivity {

    private Button manageTasksButton, manageProjectsButton, logoutButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manageTasksButton = findViewById(R.id.manageTasksButton);
        manageProjectsButton = findViewById(R.id.manageProjectsButton);
        logoutButton = findViewById(R.id.logoutButton);


        manageTasksButton.setOnClickListener(v -> navigateToTaskListActivity());
        manageProjectsButton.setOnClickListener(v -> navigateToProjectListActivity());
        logoutButton.setOnClickListener(v -> logoutUser());
    }

    // Navigate to the Task List Activity
    private void navigateToTaskListActivity() {
        Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
        startActivity(intent);
    }


    private void navigateToProjectListActivity() {
        Intent intent = new Intent(MainActivity.this, ProjectListActivity.class);
        startActivity(intent);
    }


    private void logoutUser() {
        // You can add code to clear any stored authentication tokens or session data
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
