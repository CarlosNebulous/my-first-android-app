package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class sharing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_activity);

        // Back arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

        // Get intent
        Bundle bundle = getIntent().getExtras();
        String NAME = bundle.getString("name");
        String OPTION = bundle.getString("option");
        int AGE = bundle.getInt("age");

        // Get UI elements
        Button btn_share = findViewById(R.id.buttonShare); // By default not visible and disabled
        Button btn_preview = findViewById(R.id.buttonPreview);
        TextView textView = findViewById(R.id.textViewPreview);

        // Create message
        String message = createMessage(NAME, OPTION, AGE);

        btn_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(message);
                btn_share.setEnabled(true);
                btn_share.setVisibility(View.VISIBLE);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                // Send string to apps
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    private static String createMessage (String name, String option, int age)
    {
        final String message;
        if (option.equals("Greetings")) {
            message = "Greetings " + name + ", how are these " + Integer.toString(age) + " years old? #MyForms";
        } else {
            message = "Farewell " + name + ", I hope to see you before you turn " + Integer.toString(age + 1) + " years old! #MyForms";
        }
        return message;
    }
}