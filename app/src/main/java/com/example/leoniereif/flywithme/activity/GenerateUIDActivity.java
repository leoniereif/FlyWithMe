package com.example.leoniereif.flywithme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.*;

import java.util.Random;

public class GenerateUIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_uid);

        DeltaApiDelegate delta = new DeltaApiDelegate(this);
        FirebaseDelegate firebase = new FirebaseDelegate();


        // Get name and flight num from previous screens

        // Generate UID
        String newUID = getRandomUID();

        // Get from delta

        // delta.prepare()
        // FlightInfo flightInfo = delta.getFlightInfo(flightNum, date);

        // Write to firebase when done
        // firebase.addEntry(newUID, flightInfo.stuff);

        //Intent passengerActivity = new Intent(this, PassengerActivity.class);
        //startActivity(passengerActivity);
    }

    private String getRandomUID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();
    }
}
