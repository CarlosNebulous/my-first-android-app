package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class sharing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_activity);

        // Back arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
    }
}