package com.example.leoniereif.flywithme.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.*;
import com.example.leoniereif.flywithme.model.FlightInfo;

import org.w3c.dom.Text;

import java.util.Random;

public class GenerateUIDActivity extends AppCompatActivity {

    private static FlightInfo info;
    //String name = getIntent().getStringExtra("name");

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_uid);
        DeltaApiDelegate delta = new DeltaApiDelegate(this);


        TextView readyToFlyTv = (TextView) findViewById(R.id.my_uid_tv);
        readyToFlyTv.setText("LACEY's FlyAlly ID:");
        String flightNum = getIntent().getStringExtra("flightNumber");
        //String dateText = getIntent().getStringExtra("date");
        String dateText = "2017-10-14";

        int attempts = 10;
        info = delta.getFlightInfo(flightNum, dateText);
        while (null == info && attempts-- > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            info = delta.getFlightInfo(flightNum, dateText);
        }
        TextView tv = (TextView) findViewById(R.id.uid_tv);
        if (null != info) {
            info.setUid(getRandomUID());
            info.setName("Lacey");

            // Write to firebase when done
            FirebaseDelegate firebase = new FirebaseDelegate();
            firebase.addNewEntry(info);

            tv.setText(info.getUid());
        } else {
            tv.setText("Request Timed Out.  Please go back and try again");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private String getRandomUID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();
    }

    public void readyToFlyOnClick(View view) {
        Intent travelerStartIntent = new Intent(this, TravelerHomeScreenActivity.class);
        travelerStartIntent.putExtra("name", "Lacey");
        startActivity(travelerStartIntent);
    }


}
