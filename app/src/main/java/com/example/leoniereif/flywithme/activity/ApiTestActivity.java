package com.example.leoniereif.flywithme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.DeltaApiDelegate;

public class ApiTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);

        //TextView lastScreenTv = (TextView) findViewById(R.id.last_screen_tv);
        //lastScreenTv.setText(lastScreenText);

        DeltaApiDelegate curr = new DeltaApiDelegate(this);
        curr.prepareFlightInfoForRetrieval(null, null);
        String startingAirport = curr.getStartAirportByFlightID(null, null);
        System.out.println(startingAirport);
    }

    public void debug(View view) {
        DeltaApiDelegate curr = new DeltaApiDelegate(this);
        String arrival = curr.getStartAirportByFlightID(null, null);
    }
}
