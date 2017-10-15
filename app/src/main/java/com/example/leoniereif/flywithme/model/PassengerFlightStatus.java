package com.example.leoniereif.flywithme.model;

/**
 * Created by sam on 10/14/17.
 */

public class PassengerFlightStatus {
    private boolean onBoard;
    private boolean atGate;

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public boolean isAtGate() {
        return atGate;
    }

    public void setAtGate(boolean atGate) {
        this.atGate = atGate;
    }
}
