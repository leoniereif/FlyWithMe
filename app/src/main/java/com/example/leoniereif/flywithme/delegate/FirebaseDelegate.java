package com.example.leoniereif.flywithme.delegate;

import android.util.Log;

import com.example.leoniereif.flywithme.model.FlightInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by leoniereif on 14/10/17
 */
public class FirebaseDelegate {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    private static FirebaseDelegate fbInstance;

    public FirebaseDelegate() {}

    public static FirebaseDelegate getInstance() {
        Log.d("Firebase", "created instance");
        if (fbInstance == null) {
            fbInstance = new FirebaseDelegate();
        }
        return fbInstance;
    }

    public void addNewEntry(FlightInfo fm) {

        Log.d("Firebase", "called addNewEntry");

        DatabaseReference myRef = database.getReference("flightEntries");

        myRef.child(fm.getUid()).setValue(fm);
    }

    public FlightInfo readEntry(String uid) {
        Log.d("Firebase", "called addNewEntry");

        final FlightInfo info = new FlightInfo();
        info.setUid(uid);

        DatabaseReference myRef = database.getReference("flightEntries").child(uid);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot != null) {
                    FlightInfo temp = dataSnapshot.getValue(FlightInfo.class);
                    info.setFlightNumber(temp.getFlightNumber());
                    info.setEndLocation(temp.getEndLocation());
                    info.setStartLocation(temp.getStartLocation());
                    info.setBaggage(temp.getBaggage());
                    info.setLanding(temp.getLanding());
                    info.setTakeOff(temp.getTakeOff());
                    info.setName(temp.getName());
                    info.setAtGate(temp.isAtGate());
                    info.setHasBaggage(temp.isHasBaggage());
                    Log.d("Firebase", "FlightNumber is: " + info.getFlightNumber());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });
        return info;
    }

}
