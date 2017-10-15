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
    private String name;
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

    TextView mTextViewArrivalAP;
    TextView mTextViewDepartureAP;
    TextView mTextViewArrivalDate;
    TextView mTextViewDepartureDate;
    TextView titleTextView;
    TextView mTextViewDeparting;
    TextView mTextViewLanding;
    TextView mTextViewBoarding;


    public void setFirebaseModel(FlightInfo info) {
        this.firebaseModel = info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveler_screen);

        FlightInfo bogusInfo = new FlightInfo();
        bogusInfo.setBogus(10);

         mTextViewArrivalAP = (TextView) findViewById(R.id.textViewArrivalAP);
         mTextViewDepartureAP = (TextView) findViewById(R.id.textViewDepartureAP);
         mTextViewArrivalDate = (TextView) findViewById(R.id.textViewArrivalDate);
         mTextViewDepartureDate = (TextView) findViewById(R.id.textViewDepartureDate);

        mTextViewArrivalAP.setText("");
        mTextViewArrivalDate.setText("");
        mTextViewDepartureAP.setText("");
        mTextViewDepartureDate.setText("");

         mTextViewDeparting = (TextView) findViewById(R.id.textViewDeparting);
         mTextViewLanding = (TextView) findViewById(R.id.textViewLanding);
         mTextViewBoarding = (TextView) findViewById(R.id.textViewBoarding);

        mTextViewBoarding.setText("");
        mTextViewDeparting.setText("");
        mTextViewLanding.setText("");

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);

        uid = getIntent().getStringExtra("uid");
        name = getIntent().getStringExtra("name");
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
        titleTextView = (TextView) findViewById(R.id.title_tv);
        //String name = getIntent().getStringExtra("name");
        titleTextView.setText("my flight");
    }

    private void setupTimers() {
        final String uid = this.uid;
        final String name = this.name;

        final TravelerHomeScreenActivity context = this;
        updateInfoTask = new TimerTask() {
            @Override
            public void run() {
                if (null != firebaseModel) {
                    firebaseModel.setBogus(10);
                }
                delta.prepareFlightInfoForRetrieval(flightNum, "2017-10-14");

                firebaseDelegate.readEntry(context, uid);

                //System.out.print("UIDDDD"+ deltaModel.getUid());

                deltaModel = delta.getFlightInfo(flightNum, "2017-10-14");
                deltaModel.setB1(cb1.isChecked());
                deltaModel.setB2(cb2.isChecked());
                deltaModel.setB3(cb3.isChecked());
                deltaModel.setB4(cb4.isChecked());
                deltaModel.setB5(cb5.isChecked());
                deltaModel.setB6(cb6.isChecked());
                deltaModel.setUid(uid);
                deltaModel.setName(name);
                firebaseDelegate.addNewEntry(deltaModel);

                runOnUiThread(new Runnable() {
                    public void run() {
                        // Update UI elements
                        mTextViewArrivalAP.setText(deltaModel.getEndLocation());
                        mTextViewDepartureAP.setText(deltaModel.getStartLocation());

                        String formattedDate = deltaModel.getLanding().toString().substring(0,10);
                        mTextViewArrivalDate.setText(formattedDate);

                        String formattedDate2 = deltaModel.getTakeOff().toString().substring(0,10);
                        mTextViewDepartureDate.setText(formattedDate2);

                        titleTextView.setText("fly with " + deltaModel.getName());

                        String formattedDate3 = deltaModel.getTakeOff().toString().substring(12,16);
                        mTextViewDeparting.setText(formattedDate3);
                        mTextViewBoarding.setText("7:22");

                        String formattedDate4 = deltaModel.getLanding().toString().substring(12,16);
                        mTextViewLanding.setText(formattedDate4);

                        titleTextView.setText("fly with " + deltaModel.getName());

                    }
                });
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


