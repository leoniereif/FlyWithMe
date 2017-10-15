package com.example.leoniereif.flywithme.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.*;
import com.example.leoniereif.flywithme.model.FlightInfo;

import org.w3c.dom.Text;

import java.util.Random;

public class GenerateUIDActivity extends AppCompatActivity {

    private static FlightInfo info;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_uid);
        DeltaApiDelegate delta = new DeltaApiDelegate(this);

        String name = getIntent().getStringExtra("name");
        String flightNum = getIntent().getStringExtra("flightNum");
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
}
