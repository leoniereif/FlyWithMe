package com.example.leoniereif.flywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.leoniereif.flywithme.activity.ApiTestActivity;
import com.example.leoniereif.flywithme.activity.MainActivity;

public class StartScreenActivity extends AppCompatActivity {

    private EditText inputFlightNumEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFlightNumEt = (EditText) findViewById(R.id.flight_number_et);


    }

    public void flightInfoActivityOnClick(View view) {

        Intent apiTestIntent = new Intent(this, ApiTestActivity.class);
        apiTestIntent.putExtra("flightNumber", inputFlightNumEt.getText().toString());
        startActivity(apiTestIntent);

    }
}
