package com.example.leoniereif.flywithme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.leoniereif.flywithme.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.result_tv);
    }

    public void clickMeOnClick(View view) {
        resultText.setText("You did it");
    }

    public void startActivityOnClick(View view) {
        Intent apiTestIntent = new Intent(this, ApiTestActivity.class);
        apiTestIntent.putExtra("currentText", resultText.getText());
        startActivity(apiTestIntent);
    }
}
