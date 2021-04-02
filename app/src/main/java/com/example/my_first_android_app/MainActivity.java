package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.app_good);

        Button btn_next = findViewById(R.id.buttonNext);
        EditText name = findViewById(R.id.editTextPerson_name);
        String NAME = name.getText().toString();

    btn_next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!NAME.equals("")) {
                Intent intent = new Intent(MainActivity.this, AgeOptionsActivity.class);
                intent.putExtra("name", NAME);
            } else {
                btn_next.setVisibility(View.GONE);
                btn_next.setEnabled(false);
                Toast.makeText(MainActivity.this, R.string.ErrorNameEmpty, Toast.LENGTH_LONG).show();
                btn_next.setVisibility(View.VISIBLE);
                btn_next.setEnabled(true);
            }
        }
    });

    }
}