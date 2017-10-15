package com.example.leoniereif.flywithme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.DeltaApiDelegate;
import com.example.leoniereif.flywithme.delegate.FirebaseDelegate;
import com.example.leoniereif.flywithme.model.FlightInfo;
import com.example.leoniereif.flywithme.model.FlightModel;

import java.util.TimerTask;


public class AllyHomeScreenActivity extends Activity {

    int currentState = 1;
    private FlightInfo firebaseModel;
    private FlightInfo deltaModel;
    private String flightNum;
    private String uid;
    private TimerTask updateInfoTask;
    private DeltaApiDelegate delta;
    private FirebaseDelegate firebaseDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        ImageView mImageView1;
        mImageView1 = (ImageView) findViewById(R.id.imageView001);
        ImageView mImageView2;
        mImageView2 = (ImageView) findViewById(R.id.imageView002);
        ImageView mImageView3;
        mImageView3 = (ImageView) findViewById(R.id.imageView003);
        ImageView mImageView4;
        mImageView4 = (ImageView) findViewById(R.id.imageView004);
        ImageView mImageView5;
        mImageView5 = (ImageView) findViewById(R.id.imageView005);
        ImageView mImageView6;
        mImageView6 = (ImageView) findViewById(R.id.imageView006);


        if (currentState == 2) {
            mImageView1.setImageResource(R.drawable.checkmark_simple);
            mImageView2.setImageResource(R.drawable.arrow_simple);

        } else if(currentState == 3) {
            mImageView1.setImageResource(R.drawable.security_blue);

        } else if(currentState == 4) {
            mImageView1.setImageResource(R.drawable.security_blue);

        } else if(currentState == 5) {
            mImageView1.setImageResource(R.drawable.security_blue);

        } else if(currentState == 6) {
            mImageView1.setImageResource(R.drawable.security_blue);
        }
        setupTimers();
    }

    private void setupTimers() {
        updateInfoTask = new TimerTask() {
            @Override
            public void run() {
                delta.prepareFlightInfoForRetrieval(flightNum, "2017-10-14");
            }
        };
    }

    boolean inflated = false;
    public void onClickCheckin(View view) {

       LinearLayout wholeLl = (LinearLayout) findViewById(R.id.checkin_ll);
        if (!inflated) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_checkin_piece, null);
            wholeLl.addView(pieceLl);
            inflated = true;
        } else {
            View pieceLl = findViewById(R.id.parent_new_checkin_ll);
            wholeLl.removeView(pieceLl);
            inflated = false;
        }
    }

    public void onClickBaggage(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.baggage_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_baggage_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_baggage_ll);
            wholeLl.removeView(pieceLl);
        }
    }

    public void onClickInFlight(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.in_flight_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_inflight_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_inflight_ll);
            wholeLl.removeView(pieceLl);
        }
    }

    public void onClickBoarding(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.boarding_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_boarding_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_boarding_ll);
            wholeLl.removeView(pieceLl);
        }
    }

    public void onClickGate(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.gate_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_gate_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_gate_ll);
            wholeLl.removeView(pieceLl);
        }
    }

    public void onClickSecurity(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.security_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_security_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_security_ll);
            wholeLl.removeView(pieceLl);
        }
    }
}
