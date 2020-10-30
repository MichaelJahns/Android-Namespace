package com.michaeljahns.namespace;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private long userId;
    private String displayName;
    private String email;
    private String createdAt;

    public User() {

    }

    @Ignore
    public User(String displayName, String email, String createdAt) {
        this.displayName = displayName;
        this.email = email;
        this.createdAt = createdAt;
    }

    //    Getters
    public long getUserId() {
        return userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
