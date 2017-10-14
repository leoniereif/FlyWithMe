package com.example.leoniereif.flywithme.activity;

import android.app.Activity;
import android.os.Bundle;
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

        LinearLayout checkinLl = (LinearLayout) findViewById(R.id.checkin_ll);
        if (cb.isChecked()) {
            LinearLayout newCheckinLl = new LinearLayout(this);
            newCheckinLl.
        }
    }
}


