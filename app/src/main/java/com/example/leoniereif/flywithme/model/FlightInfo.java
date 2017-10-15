package com.example.leoniereif.flywithme.model;

import java.util.Date;

/**
 * Created by wolfgangreif on 14/10/17
 */

public class FlightInfo {

    private String uid;
    private String flightNumber;
    private String takeOff;
    private String landing;
    private String baggage;
    private String startLocation;
    private boolean hasBaggage;
    private boolean atGate;
    private boolean onPlane;
    private String name;
    private String endLocation;
    private int bogus;

    public boolean isHasBaggage() {
        return hasBaggage;
    }

    public void setHasBaggage(boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
    }

    public boolean isAtGate() {
        return atGate;
    }

    public void setAtGate(boolean atGate) {
        this.atGate = atGate;
    }

    public boolean isOnPlane() {
        return onPlane;
    }

    public void setOnPlane(boolean onPlane) {
        this.onPlane = onPlane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getBogus() {
        return bogus;
    }

    public void setBogus(int bogus) {
        this.bogus = (int) (Math.random() * 99999999);
    }
}
