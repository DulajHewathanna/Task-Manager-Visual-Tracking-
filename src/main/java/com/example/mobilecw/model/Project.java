package com.example.mobilecw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Project {

    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<Milestone> milestones;
    private boolean isCompleted;

    // Constructor
    public Project(int id, String name, String description, Date startDate, Date endDate, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.milestones = new ArrayList<>();
        this.isCompleted = isCompleted;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Add a milestone to the project
    public void addMilestone(Milestone milestone) {
        this.milestones.add(milestone);
    }

    // Remove a milestone from the project
    public void removeMilestone(Milestone milestone) {
        this.milestones.remove(milestone);
    }

    // Check if all milestones are completed
    public boolean checkCompletionStatus() {
        for (Milestone milestone : milestones) {
            if (!milestone.isCompleted()) {
                return false;
            }
        }
        this.isCompleted = true;
        return true;
    }

    // toString Method
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", milestones=" + milestones +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
