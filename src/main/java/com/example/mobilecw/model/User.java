package com.example.mobilecw.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("authenticated") // Ensure this matches your API response field
    private boolean authenticated;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
