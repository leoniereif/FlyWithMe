package com.example.leoniereif.flywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView changeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeText= (TextView) findViewById(R.id.changeText_tv);
    }

    public void ClickMeOnClick (View view) {
        changeText.setText("You did it!");
    }


}
