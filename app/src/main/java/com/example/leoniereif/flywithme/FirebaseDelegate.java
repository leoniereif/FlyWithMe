package com.example.leoniereif.flywithme;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by leoniereif on 14/10/17
 */

class FirebaseDelegate {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    private static FirebaseDelegate fbInstance;

    private FirebaseDelegate() {}

    static FirebaseDelegate getInstance() {
        Log.d("Firebase", "created instance");
        if (fbInstance == null) {
            fbInstance = new FirebaseDelegate();
        }
        return fbInstance;
    }

    void addNewEntry(FlightModel fm) {

        Log.d("Firebase", "called addNewEntry");

        DatabaseReference myRef = database.getReference("flightEntries");

        myRef.child(fm.getUid()).setValue(fm);
    }

    void readEntry(String uid) {
        Log.d("Firebase", "called addNewEntry");

        DatabaseReference myRef = database.getReference("flightEntries").child(uid);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot != null) {
                    FlightModel value = dataSnapshot.getValue(FlightModel.class);
                    Log.d("Firebase", "FlightNumber is: " + value.getFlightNumber());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });

    }

}
