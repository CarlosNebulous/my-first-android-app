package com.example.my_first_android_app;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Utils {

    public static void ToastErrorHandler (Button button, Context context, int resId)
    {
        // Establish toast duration:
        final int LONG_DELAY = 3500; // 3.5 seconds
        // Hide button
        button.setVisibility(View.GONE);
        // Disable button (to avoid clicking it)
        button.setEnabled(false);
        // Show error message
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
        // Call handler to delay reactivation of buttons based on toast length
        int delay;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setVisibility(View.VISIBLE);
                button.setEnabled(true);
            }
        }, LONG_DELAY);
    }
}
