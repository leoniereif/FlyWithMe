package com.example.leoniereif.flywithme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;
import com.example.leoniereif.flywithme.delegate.DeltaApiDelegate;
import com.example.leoniereif.flywithme.delegate.FirebaseDelegate;
import com.example.leoniereif.flywithme.model.FlightInfo;

import java.util.Timer;
import java.util.TimerTask;


public class AllyHomeScreenActivity extends Activity {

    private FlightInfo firebaseModel;
    private FlightInfo deltaModel;
    private String flightNum;
    private String uid;
    private Timer timer;
    private TimerTask updateInfoTask;
    private DeltaApiDelegate delta;
    private FirebaseDelegate firebaseDelegate;
    int currentState = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        TextView titleTextView = (TextView) findViewById(R.id.title_tv);
        titleTextView.setText("fly with LACEY");


        ImageView mImageView1 = (ImageView) findViewById(R.id.imageView001);
        ImageView mImageView2 = (ImageView) findViewById(R.id.imageView002);
        ImageView mImageView3 = (ImageView) findViewById(R.id.imageView003);
        ImageView mImageView4 = (ImageView) findViewById(R.id.imageView004);
        ImageView mImageView5 = (ImageView) findViewById(R.id.imageView005);
        ImageView mImageView6 = (ImageView) findViewById(R.id.imageView006);

        TextView mTextViewArrivalAP = (TextView) findViewById(R.id.textViewArrivalAP);
        TextView mTextViewDepartureAP = (TextView) findViewById(R.id.textViewDepartureAP);
        TextView mTextViewArrivalDate = (TextView) findViewById(R.id.textViewArrivalDate);
        TextView mTextViewDepartureDate = (TextView) findViewById(R.id.textViewDepartureDate);

        mTextViewArrivalAP.setText("ATL");
        mTextViewArrivalDate.setText("01-02-2018");
        mTextViewDepartureAP.setText("DUS");
        mTextViewDepartureDate.setText("01-01-2018");

        TextView mTextViewDeparting = (TextView) findViewById(R.id.textViewDeparting);
        TextView mTextViewLanding = (TextView) findViewById(R.id.textViewLanding);
        TextView mTextViewBoarding = (TextView) findViewById(R.id.textViewBoarding);

        mTextViewBoarding.setText("12:00PM");
        mTextViewDeparting.setText("12:30PM");
        mTextViewLanding.setText("2:00AM");

        if (currentState > 1) {
            mImageView1.setImageResource(R.drawable.checkmark_simple);
            mImageView2.setImageResource(R.drawable.arrow_simple);

        }
        if (currentState > 2) {
            mImageView2.setImageResource(R.drawable.checkmark_simple);
            mImageView3.setImageResource(R.drawable.arrow_simple);

        }
        if (currentState > 3) {
            mImageView3.setImageResource(R.drawable.checkmark_simple);
            mImageView4.setImageResource(R.drawable.arrow_simple);
        }
        if (currentState > 4) {
            mImageView4.setImageResource(R.drawable.checkmark_simple);
            mImageView5.setImageResource(R.drawable.arrow_simple);
        }
        if (currentState > 5) {
            mImageView5.setImageResource(R.drawable.checkmark_simple);
            mImageView6.setImageResource(R.drawable.arrow_simple);
        }
        uid = getIntent().getStringExtra("uid");
        delta = new DeltaApiDelegate(this);
        firebaseDelegate = new FirebaseDelegate();
        firebaseModel = firebaseDelegate.readEntry(uid);
        flightNum = firebaseModel.getFlightNumber();
        delta.prepareFlightInfoForRetrieval(firebaseModel.getFlightNumber(), "2017-10-14");
        timer = new Timer();
        setupTimers();
        timer.schedule(updateInfoTask, 2000, 30000);
    }

    private void setupTimers() {
        final String uid = this.uid;
        updateInfoTask = new TimerTask() {
            @Override
            public void run() {
                Log.d("Success", "Task running");
                delta.prepareFlightInfoForRetrieval(flightNum, "2017-10-14");
                firebaseModel = firebaseDelegate.readEntry(uid);
                deltaModel = delta.getFlightInfo(flightNum, "2017-10-14");
                System.out.println(firebaseModel.getFlightNumber());
            }
        };
    }

    /*boolean inflated = false;
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
    }*/
}
