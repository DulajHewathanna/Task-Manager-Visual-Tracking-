package com.example.mobilecw.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilecw.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository class to handle task-related data operations.
 */
public class TaskRepository {

    private final ApiService apiService;

    public TaskRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Fetches all tasks for a specific project from the API.
     *
     * @param projectId The ID of the project.
     * @return LiveData containing a list of tasks.
     */
    public LiveData<List<Task>> getTasksByProjectId(int projectId) {
        MutableLiveData<List<Task>> tasksLiveData = new MutableLiveData<>();
        apiService.getTasksByProjectId(projectId).enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tasksLiveData.postValue(response.body());
                } else {
                    tasksLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                t.printStackTrace();
                tasksLiveData.postValue(null); // Handle API call failure
            }
        });
        return tasksLiveData;
    }

    /**
     * Fetches a single task by its ID from the API.
     *
     * @param taskId The ID of the task.
     * @return LiveData containing the task details.
     */
    public LiveData<Task> getTaskById(int taskId) {
        MutableLiveData<Task> taskLiveData = new MutableLiveData<>();
        apiService.getTaskById(taskId).enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if (response.isSuccessful() && response.body() != null) {
                    taskLiveData.postValue(response.body());
                } else {
                    taskLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                t.printStackTrace();
                taskLiveData.postValue(null); // Handle API call failure
            }
        });
        return taskLiveData;
    }

    /**
     * Creates a new task using the API.
     *
     * @param task The task to be created.
     * @return LiveData containing the created task.
     */
    public LiveData<Task> createTask(Task task) {
        MutableLiveData<Task> createdTaskLiveData = new MutableLiveData<>();
        apiService.createTask(task).enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if (response.isSuccessful() && response.body() != null) {
                    createdTaskLiveData.postValue(response.body());
                } else {
                    createdTaskLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                t.printStackTrace();
                createdTaskLiveData.postValue(null); // Handle API call failure
            }
        });
        return createdTaskLiveData;
    }

    /**
     * Updates an existing task using the API.
     *
     * @param task The updated task data.
     * @return LiveData containing the updated task.
     */
    public LiveData<Task> updateTask(Task task) {
        MutableLiveData<Task> updatedTaskLiveData = new MutableLiveData<>();
        int taskId = 0;
        apiService.updateTask(taskId, task).enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updatedTaskLiveData.postValue(response.body());
                } else {
                    updatedTaskLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                t.printStackTrace();
                updatedTaskLiveData.postValue(null); // Handle API call failure
            }
        });
        return updatedTaskLiveData;
    }

    /**
     * Deletes a task by its ID using the API.
     *
     * @param taskId The ID of the task to be deleted.
     * @return LiveData containing the status of the deletion operation.
     */
    public LiveData<Boolean> deleteTask(int taskId) {
        MutableLiveData<Boolean> deletionStatusLiveData = new MutableLiveData<>();
        apiService.deleteTask(taskId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                deletionStatusLiveData.postValue(response.isSuccessful()); // Success if HTTP status is 200-299
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                deletionStatusLiveData.postValue(false); // Failure
            }
        });
        return deletionStatusLiveData;
    }



    public void addTask(Task task) {
    }

    public LiveData<List<Task>> getAllTasks() {
        return null;
    }
}
