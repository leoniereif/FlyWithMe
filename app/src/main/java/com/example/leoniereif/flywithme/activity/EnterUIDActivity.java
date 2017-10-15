package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;

public class EnterUIDActivity extends AppCompatActivity {

    private EditText inputUIDEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_uid);

        inputUIDEt = (EditText) findViewById(R.id.uid_et);
        final Button txt_submit = (Button) findViewById(R.id.input_uid_bttn);


        inputUIDEt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    txt_submit.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void enterUIDActivityOnClick(View view) {

        /*if (inputUIDEt != null && !inputUIDEt.getText().toString().isEmpty()) {
            Intent enterUIDIntent = new Intent(this, AllyHomeScreenActivity.class);
            enterUIDIntent.putExtra("uID", inputUIDEt.getText().toString());
            startActivity(enterUIDIntent);

        }*/


        Intent enterUIDIntent = new Intent(this, AllyHomeScreenActivity.class);
        enterUIDIntent.putExtra("uid", inputUIDEt.getText().toString());
        if(inputUIDEt.getText().toString().isEmpty()) { //make sure it's a valid flight number

        }

        //enterUIDIntent.putExtra("name", inputName);
        //enterUIDIntent.putExtra("flightNumber", inputFlightNumEt.getText().toString());
        startActivity(enterUIDIntent);


    }


}
