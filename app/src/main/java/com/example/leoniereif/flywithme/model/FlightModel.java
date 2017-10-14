package com.example.leoniereif.flywithme.model;

import java.util.Date;

/**
 * Created by wolfgangreif on 14/10/17
 */

class FlightModel {

    private String uid;
    private String flightNumber;
    private boolean atGate;
    private boolean enteredAirplane;
    private Date takeOff;
    private Date landing;
    private Date baggage;

    String getUid() {
        return uid;
    }

    void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isAtGate() {
        return atGate;
    }

    void setAtGate(boolean atGate) {
        this.atGate = atGate;
    }

    public boolean isEnteredAirplane() {
        return enteredAirplane;
    }

    void setEnteredAirplane(boolean enteredAirplane) {
        this.enteredAirplane = enteredAirplane;
    }

    public Date getTakeOff() {
        return takeOff;
    }

    void setTakeOff(Date takeOff) {
        this.takeOff = takeOff;
    }

    public Date getLanding() {
        return landing;
    }

    void setLanding(Date landing) {
        this.landing = landing;
    }

    public Date getBaggage() {
        return baggage;
    }

    void setBaggage(Date baggage) {
        this.baggage = baggage;
    }

    String getFlightNumber() {
        return flightNumber;
    }

    void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
