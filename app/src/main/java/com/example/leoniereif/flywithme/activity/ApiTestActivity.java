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

        //Flight Number

        //TextView lastScreenTv = (TextView) findViewById(R.id.last_screen_tv);
        //DeltaApiDelegate curr = new DeltaApiDelegate(this);
        String flightNum = getIntent().getStringExtra("flightNumber");
        TextView flightNumTv = (TextView) findViewById(R.id.flight_number_tv);

       if (flightNum == null) {
           flightNum = "flight num fail";
       }

       flightNumTv.setText(flightNum);

        //String flightNum = curr.getFlightNumberByUID(uID);

        //Arrival Time

        //String arrival = curr.getArrivalTimeByUID(uID);








    }
}
