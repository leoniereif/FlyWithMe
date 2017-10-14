package com.example.leoniereif.flywithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ApiTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);

        String lastScreenText = getIntent().getStringExtra("currentText");
        TextView lastScreenTv = (TextView) findViewById(R.id.last_screen_tv);
        lastScreenTv.setText(lastScreenText);
    }
}
