package com.example.mobilecw.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobilecw.R;

public class ProjectDetailsActivity extends AppCompatActivity {

    private TextView projectNameTextView, projectDescriptionTextView, projectStartDateTextView, projectEndDateTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        // Initialize the UI elements
        projectNameTextView = findViewById(R.id.projectNameTextView);
        projectDescriptionTextView = findViewById(R.id.projectDescriptionTextView);
        projectStartDateTextView = findViewById(R.id.projectStartDateTextView);
        projectEndDateTextView = findViewById(R.id.projectEndDateTextView);

        // Get the project data passed via Intent
        String projectName = getIntent().getStringExtra("PROJECT_NAME");
        String projectDescription = getIntent().getStringExtra("PROJECT_DESCRIPTION");
        String projectStartDate = getIntent().getStringExtra("PROJECT_START_DATE");
        String projectEndDate = getIntent().getStringExtra("PROJECT_END_DATE");

        // Set the project data to the TextViews
        projectNameTextView.setText(projectName);
        projectDescriptionTextView.setText(projectDescription);
        projectStartDateTextView.setText(projectStartDate);
        projectEndDateTextView.setText(projectEndDate);
    }
}
