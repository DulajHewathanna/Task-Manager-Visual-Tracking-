package com.example.mobilecw.repository;

import com.example.mobilecw.model.Project;
import com.example.mobilecw.model.Task;
import com.example.mobilecw.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<User> loginUser(@Field("email") String email, @Field("password") String password);

    Call<Void> deleteTask(int taskId);

    Call<List<Task>> getTasksByProjectId(int projectId);

    Call<Task> getTaskById(int taskId);

    Call<Task> createTask(Task task);

    Call<Task> updateTask(int taskId, Task task);

    Call<List<Project>> getAllProjects();

    Call<Project> getProjectById(int projectId);

    Call<Project> createProject(Project project);

    Call<Project> updateProject(int projectId, Project project);

    Call<Void> deleteProject(int projectId);
}
