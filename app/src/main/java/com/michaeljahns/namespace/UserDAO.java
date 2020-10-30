package com.michaeljahns.namespace;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void add(User user);
}
