package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;
import com.example.my_first_android_app.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To display Icon
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.app_good);

        Button btn_next = findViewById(R.id.buttonNext);
        EditText name = findViewById(R.id.editTextPerson_name);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the name of the edit text variable
                String NAME = name.getText().toString();
                // if name is not empty...
                if (!NAME.equals("")) {
                    Intent intent_name = new Intent(MainActivity.this, AgeOptionsActivity.class);
                    intent_name.putExtra("name", NAME);
                    startActivity(intent_name);
                    // if name is empty...
                } else {
                    Utils.ToastErrorHandler(btn_next, MainActivity.this, R.string.ErrorNameEmpty);
                }
            }
        });

    }



}