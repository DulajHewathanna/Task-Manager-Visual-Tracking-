package com.example.mobilecw.viewmodel;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.mobilecw.model.Task;
import com.example.mobilecw.repository.ApiService;
import com.example.mobilecw.repository.TaskRepository;

import java.util.List;

public class TaskViewModel  {

    private final TaskRepository taskRepository;
    private final LiveData<List<Task>> allTasks;

    public TaskViewModel(Application application) {
        super();

        // Initialize repository and fetch tasks
        taskRepository = new TaskRepository((ApiService) application);
        allTasks = taskRepository.getAllTasks();
    }

    // Get all tasks
    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    // Add a new task
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    // Update an existing task
    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    // Delete a task
    public void deleteTask(Task task) {
        taskRepository.deleteTask(task.getId());
    }

    // Get tasks by project ID
    public LiveData<List<Task>> getTasksByProjectId(int projectId) {
        return taskRepository.getTasksByProjectId(projectId);
    }

    // Get a specific task by its ID
    public LiveData<Task> getTaskById(int taskId) {
        return taskRepository.getTaskById(taskId);
    }

    // Provide the task list to observe
    public LiveData<List<Task>> getTaskList() {
        return allTasks;
    }
}
