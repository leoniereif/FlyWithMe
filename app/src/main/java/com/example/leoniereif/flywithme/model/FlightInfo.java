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
    private boolean b1, b2, b3, b4, b5, b6;
    private String name;
    private String endLocation;
    private int bogus;

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public boolean isB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    public boolean isB4() {
        return b4;
    }

    public void setB4(boolean b4) {
        this.b4 = b4;
    }

    public boolean isB5() {
        return b5;
    }

    public void setB5(boolean b5) {
        this.b5 = b5;
    }

    public boolean isB6() {
        return b6;
    }

    public void setB6(boolean b6) {
        this.b6 = b6;
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
