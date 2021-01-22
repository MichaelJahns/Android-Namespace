package com.michaeljahns.namespace;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class UserActivity extends AppCompatActivity {

    private EditText displayName, createdAt, email;
    private UserDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        bind();

        database = Room.databaseBuilder(
                getApplicationContext(),
                UserDatabase.class,
                "user-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


    }

    public void bind() {
        displayName = findViewById(R.id.displayNameEditText);
        createdAt = findViewById(R.id.createdAtEditText);
        email = findViewById(R.id.emailEditText);
    }

    public void newUser(View view) {
        String displayName = this.displayName.getText().toString().trim();
        String createdAt = this.createdAt.getText().toString().trim();
        String email = this.email.getText().toString().trim();
        User newUser = new User(displayName, email, createdAt);
        database.userDAO().add(newUser);
    }

}