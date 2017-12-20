package com.course.example.wakefulreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("RECEIVER", "Activity Started");
        Toast.makeText(this, "Activity Started", Toast.LENGTH_LONG).show();
        Intent intent = new Intent("TRIGGER_RECEIVER");
        sendBroadcast(intent);

    }
}
