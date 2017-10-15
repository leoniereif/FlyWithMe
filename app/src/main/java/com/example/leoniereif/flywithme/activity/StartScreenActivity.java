package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.leoniereif.flywithme.R;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);
    }

    public void imFlyingOnClick(View view) {

        Intent startScreenActivityIntent = new Intent(this, EnterNameActivity.class);
        startActivity(startScreenActivityIntent);
    }

    public void imAlongOnClick(View view) {

        Intent startScreenActivityIntent = new Intent(this, EnterUIDActivity.class);
        startActivity(startScreenActivityIntent);
    }
}
