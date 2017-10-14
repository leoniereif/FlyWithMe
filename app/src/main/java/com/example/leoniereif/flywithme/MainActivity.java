package com.example.leoniereif.flywithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("FireBase", "YAYYY");
                FirebaseDelegate fbd = FirebaseDelegate.getInstance();
                fbd.addNewEntry("TEST");
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("FireBase", "YAYYY");
                FirebaseDelegate fbd = FirebaseDelegate.getInstance();
                fbd.readEntry("TEST");
            }
        });

    }
}
