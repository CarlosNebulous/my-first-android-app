package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class AgeOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_options);

        // Back arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

    }
}