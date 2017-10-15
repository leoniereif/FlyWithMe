package com.example.leoniereif.flywithme.activity;

import android.app.Activity;
import android.os.Bundle;
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


public class TravelerHomeScreenActivity extends Activity {

    private FlightInfo firebaseModel;
    private FlightInfo deltaModel;
    private String flightNum;
    private String uid;
    private Timer timer;
    private TimerTask updateInfoTask;
    private DeltaApiDelegate delta;
    private FirebaseDelegate firebaseDelegate;

    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    CheckBox cb5;
    CheckBox cb6;

    public void setFirebaseModel(FlightInfo info) {
        this.firebaseModel = info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveler_screen);

        FlightInfo bogusInfo = new FlightInfo();
        bogusInfo.setBogus(10);

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

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);

        uid = getIntent().getStringExtra("uid");
        delta = new DeltaApiDelegate(this);
        firebaseDelegate = new FirebaseDelegate();
        firebaseDelegate.readEntry(this, uid);
        if (null != firebaseModel) {
            flightNum = firebaseModel.getFlightNumber();
            delta.prepareFlightInfoForRetrieval(firebaseModel.getFlightNumber(), "2017-10-14");
        }
        timer = new Timer();
        setupTimers();
        timer.schedule(updateInfoTask, 2000, 15000);

        // needs to happen later!!
        TextView titleTextView = (TextView) findViewById(R.id.title_tv);
        //String name = getIntent().getStringExtra("name");
        titleTextView.setText("my flight");
    }

    private void setupTimers() {
        final String uid = this.uid;
        final TravelerHomeScreenActivity context = this;
        updateInfoTask = new TimerTask() {
            @Override
            public void run() {
                if (null != firebaseModel) {
                    firebaseModel.setBogus(10);
                }
                delta.prepareFlightInfoForRetrieval(flightNum, "2017-10-14");
                firebaseDelegate.readEntry(context, uid);
                deltaModel = delta.getFlightInfo(flightNum, "2017-10-14");
                deltaModel.setB1(cb1.isChecked());
                deltaModel.setB2(cb2.isChecked());
                deltaModel.setB3(cb3.isChecked());
                deltaModel.setB4(cb4.isChecked());
                deltaModel.setB5(cb5.isChecked());
                deltaModel.setB6(cb6.isChecked());
                System.out.println(firebaseModel.getFlightNumber());
                if(deltaModel.getUid() != null)
                    firebaseDelegate.addNewEntry(deltaModel);
            }
        };
    }

    public void onCheckboxClickedChecked(View view) {}

    public void onCheckboxClickedSecurity(View view) {
        if(!cb1.isChecked()) {
            cb2.setChecked(false);
        }
    }

    public void onCheckboxClickedGate(View view) {
        if(!cb2.isChecked()) {
            cb3.setChecked(false);
        }
    }
    public void onCheckboxClickedBoarding(View view) {
        if(!cb3.isChecked()) {
            cb4.setChecked(false);
        }
    }
    public void onCheckboxClickedInFlight(View view) {
        if(!cb4.isChecked()) {
            cb5.setChecked(false);
        }
    }
    public void onCheckboxClickedBaggage(View view) {
        if(!cb5.isChecked()) {
            cb6.setChecked(false);
        }
    }

       /*LinearLayout wholeLl = (LinearLayout) findViewById(R.id.checkin_ll);
        if (!inflated) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_checkin_piece, null);
            wholeLl.addView(pieceLl);
            inflated = true;
        } else {
            View pieceLl = findViewById(R.id.parent_new_checkin_ll);
            wholeLl.removeView(pieceLl);
            inflated = false;
        }*/

/*
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


