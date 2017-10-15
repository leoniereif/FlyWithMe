package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.DeltaApiDelegate;

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
        DeltaApiDelegate api = new DeltaApiDelegate(this);
        api.prepareFlightInfoForRetrieval(inputFlightNumEt.getText().toString(), "2017-10-14");
        finish();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent apiTestIntent = new Intent(this, GenerateUIDActivity.class);
        apiTestIntent.putExtra("name", inputName);
        apiTestIntent.putExtra("flightNumber", inputFlightNumEt.getText().toString());
        startActivity(apiTestIntent);
    }
}
