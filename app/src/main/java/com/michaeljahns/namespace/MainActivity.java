package com.michaeljahns.namespace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<User> users;
    UserDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.userRecycler);
        database = Room.databaseBuilder(
                getApplicationContext(),
                UserDatabase.class,
                "user-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        startRecycler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRecycler();
    }

    public void onFerry(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void startRecycler() {
        users = database.userDAO().getAll();
        UserLayoutAdapter userLayoutAdapter = new UserLayoutAdapter(this, users);
        this.recyclerView.setAdapter(userLayoutAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}