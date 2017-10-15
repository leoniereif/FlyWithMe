package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;

public class MainActivity extends AppCompatActivity {

    private EditText inputFlightNumEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFlightNumEt = (EditText) findViewById(R.id.flight_number_et);

    }

    public void flightInfoActivityOnClick(View view) {
        Intent apiTestIntent = new Intent(this, ApiTestActivity.class);
        apiTestIntent.putExtra("flightNumber", inputFlightNumEt.getText());
        startActivity(apiTestIntent);
    }

    public void startMainScreen(View view) {
        Intent ms = new Intent(this, MainScreenActivity.class);
        startActivity(ms);
    }
}
