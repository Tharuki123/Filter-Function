package com.hit.searchanimationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserDetials extends AppCompatActivity {
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detials);

        userName = findViewById(R.id.tv_username);

        String username = getIntent().getStringExtra("Username");
        userName.setText(username);
    }
}