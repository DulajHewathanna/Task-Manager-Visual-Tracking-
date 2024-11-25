package com.example.mobilecw.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilecw.model.Project;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository class to handle project data operations.
 * It interacts with the ApiService to fetch and manage data from the API.
 */
public class ProjectRepository {

    private final ApiService apiService;

    public ProjectRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Fetches all projects from the API.
     *
     * @return LiveData containing a list of projects.
     */
    public LiveData<List<Project>> getAllProjects() {
        MutableLiveData<List<Project>> projectsLiveData = new MutableLiveData<>();
        apiService.getAllProjects().enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    projectsLiveData.postValue(response.body());
                } else {
                    projectsLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                t.printStackTrace();
                projectsLiveData.postValue(null); // Handle API call failure
            }
        });
        return projectsLiveData;
    }

    /**
     * Fetches a single project by its ID from the API.
     *
     * @param projectId The ID of the project.
     * @return LiveData containing the project details.
     */
    public LiveData<Project> getProjectById(int projectId) {
        MutableLiveData<Project> projectLiveData = new MutableLiveData<>();
        apiService.getProjectById(projectId).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                if (response.isSuccessful() && response.body() != null) {
                    projectLiveData.postValue(response.body());
                } else {
                    projectLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                t.printStackTrace();
                projectLiveData.postValue(null); // Handle API call failure
            }
        });
        return projectLiveData;
    }

    /**
     * Creates a new project using the API.
     *
     * @param project The project to be created.
     * @return LiveData containing the created project.
     */
    public LiveData<Project> createProject(Project project) {
        MutableLiveData<Project> createdProjectLiveData = new MutableLiveData<>();
        apiService.createProject(project).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                if (response.isSuccessful() && response.body() != null) {
                    createdProjectLiveData.postValue(response.body());
                } else {
                    createdProjectLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                t.printStackTrace();
                createdProjectLiveData.postValue(null); // Handle API call failure
            }
        });
        return createdProjectLiveData;
    }

    /**
     * Updates an existing project using the API.
     *
     * @param project The updated project data.
     * @return LiveData containing the updated project.
     */
    public LiveData<Project> updateProject(Project project) {
        MutableLiveData<Project> updatedProjectLiveData = new MutableLiveData<>();
        int projectId = 0;
        apiService.updateProject(projectId, project).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updatedProjectLiveData.postValue(response.body());
                } else {
                    updatedProjectLiveData.postValue(null); // Handle API error response
                }
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                t.printStackTrace();
                updatedProjectLiveData.postValue(null); // Handle API call failure
            }
        });
        return updatedProjectLiveData;
    }

    /**
     * Deletes a project by its ID using the API.
     *
     * @param projectId The ID of the project to be deleted.
     * @return LiveData containing the status of the deletion operation.
     */
    public LiveData<Boolean> deleteProject(int projectId) {
        MutableLiveData<Boolean> deletionStatusLiveData = new MutableLiveData<>();
        apiService.deleteProject(projectId).enqueue(new Callback<Void>() {
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

    public void addProject(Project project) {
    }
}
