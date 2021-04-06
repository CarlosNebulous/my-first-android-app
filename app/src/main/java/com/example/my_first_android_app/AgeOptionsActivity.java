package com.example.my_first_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Objects;
import com.example.my_first_android_app.Utils;

public class AgeOptionsActivity extends AppCompatActivity {

    // Create variable for radio button
    private RadioButton radio_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_options);

        // Back arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

        // Get intent
        Bundle bundle = getIntent().getExtras();
        String NAME = bundle.getString("name");

        // Get UI elements
        Button btn_next = findViewById(R.id.buttonNext);
        RadioGroup radio_group = findViewById(R.id.radioGroupOptions);
        SeekBar seekBar = findViewById(R.id.seekBarAge);
        TextView seekBarValue = findViewById(R.id.textViewSeekBar);

        // Display default seek bar value
        String seekValue = Integer.toString(seekBar.getProgress());
        seekBarValue.setText(seekValue);

        // Set listener to update value as the seek bar changes
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Set listener on btn_next
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Get the value of the radioGroup. First, get selected button by id
                int selectedId = radio_group.getCheckedRadioButtonId();
                // If none of them are Selected
                if (selectedId == -1) {
                    // Use Toast to raise error
                    Utils.ToastErrorHandler(btn_next, AgeOptionsActivity.this, R.string.ErrorSelectionEmpty);
                } else {
                    radio_btn = findViewById(selectedId);
                    String OPTION = (String) radio_btn.getText();
                    int AGE = seekBar.getProgress();
                    if (AGE < 16 || AGE > 60) {
                        // Use Toast to raise error
                        Utils.ToastErrorHandler(btn_next, AgeOptionsActivity.this, R.string.ErrorAgeOOB);
                    } else {
                        Intent intent_final = new Intent(AgeOptionsActivity.this, sharing_activity.class);
                        intent_final.putExtra("name", NAME);
                        intent_final.putExtra("option", OPTION);
                        intent_final.putExtra("age", AGE);
                        startActivity(intent_final);
                    }
                }
            }

        });

    }
}