package com.example.leoniereif.flywithme.model;

/**
 * Created by sam on 10/14/17.
 */

public class FlightModel {
    private FlightInfo flightInfo;
    private PassengerFlightStatus passengerStatus;

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public PassengerFlightStatus getPassengerStatus() {
        return passengerStatus;
    }

    public void setPassengerStatus(PassengerFlightStatus passengerStatus) {
        this.passengerStatus = passengerStatus;
    }
}
