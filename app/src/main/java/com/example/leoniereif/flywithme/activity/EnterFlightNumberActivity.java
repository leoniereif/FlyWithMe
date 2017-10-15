package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;

public class EnterFlightNumberActivity extends AppCompatActivity {

    private EditText inputFlightNumEt;
    String inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_flight_number);
        inputName = getIntent().getStringExtra("name");
        inputFlightNumEt = (EditText) findViewById(R.id.flight_number_et);
        TextView flightNumberPrompt = (TextView) findViewById(R.id.flight_number_prompt_tv);
        flightNumberPrompt.setText("Ok " + inputName + ", what's your flight #?");


    }

    public void enterFlightNumberActivityOnClick(View view) {

        Intent apiTestIntent = new Intent(this, TravelerHomeScreenActivity.class);

        if(inputFlightNumEt.getText().toString().isEmpty()) { //make sure it's a valid flight number

        }

        apiTestIntent.putExtra("name", inputName);
        apiTestIntent.putExtra("flightNumber", inputFlightNumEt.getText().toString());
        startActivity(apiTestIntent);

    }

}
