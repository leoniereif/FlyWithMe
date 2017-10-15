package com.example.leoniereif.flywithme.model;

import java.util.Date;

/**
 * Created by wolfgangreif on 14/10/17
 */

public class FlightInfo {

    private String uid;
    private String flightNumber;
    private Date takeOff;
    private Date landing;
    private Date baggage;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Date takeOff) {
        this.takeOff = takeOff;
    }

    public Date getLanding() {
        return landing;
    }

    public void setLanding(Date landing) {
        this.landing = landing;
    }

    public Date getBaggage() {
        return baggage;
    }

    public void setBaggage(Date baggage) {
        this.baggage = baggage;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
