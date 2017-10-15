package com.example.leoniereif.flywithme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        String uID = getIntent().getStringExtra("flightNumber");
        String flightNum = null;
        String arrival = curr.getArrivalTimeByFlightID(null, uID);
        if (flightNum == null) {
            flightNum = "flight num fail";
        }
        TextView flightNumTv = (TextView) findViewById(R.id.flight_number_tv);
        flightNumTv.setText(flightNum);



    }
}
