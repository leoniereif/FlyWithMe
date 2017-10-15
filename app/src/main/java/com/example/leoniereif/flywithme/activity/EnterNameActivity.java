package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.leoniereif.flywithme.R;

public class EnterNameActivity extends AppCompatActivity {

    private EditText inputNameEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        inputNameEt = (EditText) findViewById(R.id.name_et);
    }

    public void enterNameActivityOnClick(View view) {

        Intent enterNameIntent = new Intent(this, EnterFlightNumberActivity.class);
        enterNameIntent.putExtra("name", inputNameEt.getText().toString());
        startActivity(enterNameIntent);
        finish();
    }


}
