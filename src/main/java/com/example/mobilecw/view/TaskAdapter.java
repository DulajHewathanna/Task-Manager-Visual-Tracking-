package com.example.mobilecw.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilecw.R;
import com.example.mobilecw.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final Context context;
    private List<Task> taskList = new ArrayList<>();

    public TaskAdapter(Context context) {
        this.context = context;
    }

    // Method to update the task list dynamically
    public void setTaskList(List<Task> tasks) {
        this.taskList = tasks;
        notifyDataSetChanged(); // Notify RecyclerView to update
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for a single task
        View view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // Bind the data for each task
        Task task = taskList.get(position);
        holder.taskTitle.setText(task.getTitle());
        holder.taskDescription.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {
        // Return the size of the task list
        return taskList.size();
    }

    // ViewHolder class to hold the task item view
    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskTitle;
        private final TextView taskDescription;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle); // TextView for task title
            taskDescription = itemView.findViewById(R.id.taskDescription); // TextView for task description
        }
    }
}
