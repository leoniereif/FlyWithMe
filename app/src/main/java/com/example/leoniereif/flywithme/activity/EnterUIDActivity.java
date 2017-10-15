package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.leoniereif.flywithme.R;

public class EnterUIDActivity extends AppCompatActivity {

    private EditText inputUIDEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_uid);
    }

    public void enterUIDActivityOnClick(View view) {

        Intent enterUIDIntent = new Intent(this, ApiTestActivity.class);
        enterUIDIntent.putExtra("uID", inputUIDEt.getText().toString());
        startActivity(enterUIDIntent);

    }


}
