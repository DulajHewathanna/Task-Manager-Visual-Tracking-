package com.example.mobilecw.viewmodel;

import android.app.Application;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilecw.model.Project;
import com.example.mobilecw.repository.ApiService;
import com.example.mobilecw.repository.ProjectRepository;

import java.util.List;

public class ProjectViewModel  {

    private final ProjectRepository projectRepository;
    private final MutableLiveData<List<Project>> allProjects;

    public ProjectViewModel(Application application) {
        super(); // Pass the Application to the parent class
        projectRepository = new ProjectRepository((ApiService) application); // Initialize with application context
        allProjects = new MutableLiveData<>();
    }

    // Method to get the list of all projects
    public LiveData<List<Project>> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    // Method to add a project
    public void addProject(Project project) {
        projectRepository.addProject(project);
    }

    // Method to update a project
    public void updateProject(Project project) {
        projectRepository.updateProject(project);
    }

    // Method to delete a project
    public void deleteProject(Project project) {
        projectRepository.deleteProject(project.getId());
    }

    // Method to fetch a specific project by its ID
    public LiveData<Project> getProjectById(int projectId) {
        return projectRepository.getProjectById(projectId);
    }

    // Method to fetch the list of projects
    public void fetchProjects() {
        allProjects.setValue(projectRepository.getAllProjects().getValue());
    }
}
