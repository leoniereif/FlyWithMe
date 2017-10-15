package com.example.leoniereif.flywithme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.leoniereif.flywithme.R;


public class MainScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
    }

    public void onClickCheckin(View view) {
        CheckBox cb = (CheckBox) view;

        LinearLayout wholeLl = (LinearLayout) findViewById(R.id.checkin_ll);
        if (cb.isChecked()) {
            View pieceLl = LayoutInflater.from(this).inflate(R.layout.parent_checkin_piece, null);
            wholeLl.addView(pieceLl);
        } else {
            View pieceLl = findViewById(R.id.parent_new_checkin_ll);
            wholeLl.removeView(pieceLl);
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
