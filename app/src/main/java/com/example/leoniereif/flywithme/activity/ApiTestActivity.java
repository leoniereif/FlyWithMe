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

        String uID = getIntent().getStringExtra("uID");
        DeltaApiDelegate curr = new DeltaApiDelegate(this);

        //--------Flight Number----------

        //String flightNum = getIntent().getStringExtra("flightNumber");

        //Given a UID
        String flightNum = curr.getFlightNumberByUID(uID);
        TextView flightNumTv = (TextView) findViewById(R.id.flight_number_tv);
        if (flightNum == null) {
           flightNum = "flight num fail";
        }
        flightNumTv.setText(flightNum);


        //--------Start Airport-----------

        String startAirport = curr.getStartAirportByUID(uID);
        //TextView startAirportTv = (TextView) findViewById(R.id.)

        //--------Destination Airport-----------


        //--------Arrival Time-----------


        //--------Departure Time-----------


        //--------TSA Wait Time-----------


        //--------Baggage Time-----------







        //String arrival = curr.getArrivalTimeByUID(uID);








    }
}
