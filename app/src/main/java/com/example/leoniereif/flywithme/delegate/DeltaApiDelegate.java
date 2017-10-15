package com.example.leoniereif.flywithme.delegate;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.leoniereif.flywithme.model.FlightInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sam on 10/14/17.
 */
public class DeltaApiDelegate {
    private RequestQueue queue;
    private static String tempStatus;
    private static String tempDepartureAirport;
    private static String tempDepartureGate;
    private static String tempDepartureLocalTimeActual;
    private static String tempArrivalLocalTimeActual;
    public static String tempArrivalAirport;
    private static String tempArrivalGate;

    public String getTempArrivalAirport() {
        return tempArrivalAirport;
    }
    public DeltaApiDelegate(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    // Return whether or not there are new values
    public boolean prepareFlightInfoForRetrieval(String flightID, String date) {
        String flightInfoUrl = String.format("http://deltaairlines-dev.apigee.net/v1/hack/flight/status?flightNumber=1969&flightOriginDate=2017-10-14");
        //String flightInfoUrl = String.format("http://deltaairlines-dev.apigee.net/v1/hack/flight/status?flightNumber=%s&flightOriginDate=%s", flightID, date);

        JsonObjectRequest response = new JsonObjectRequest(Request.Method.GET, flightInfoUrl, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public  void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", "Response : " + response.toString());

                        try {
                            JSONObject reader = new JSONObject(response.toString());
                            JSONObject statusResponse = reader.getJSONObject("flightStatusResponse").getJSONObject("statusResponse").getJSONObject("flightStatusTO");
                            JSONObject statusList = statusResponse.getJSONObject("flightStatusLegTOList");

                            tempStatus = reader.getJSONObject("flightStatusResponse").getString("status");
                            System.out.println("Status: " + tempStatus);
                            //flightStatusResponse.status

                            tempDepartureAirport = statusList.getString("departureAirportCode");
                            System.out.println("Departure Airport Name: " + tempDepartureAirport);
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].departureAirportName

                            tempDepartureGate = statusList.getString("departureGate");
                            System.out.println("Departure Gate: " + tempDepartureGate);
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].departureGate

                            tempDepartureLocalTimeActual = statusList.getString("departureLocalTimeEstimatedActual");
                            System.out.println("Departure time: " + tempDepartureLocalTimeActual.substring(12,16));
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalLocalTimeEstimatedActual

                            tempArrivalLocalTimeActual = statusList.getString("arrivalLocalTimeEstimatedActual");
                            System.out.println("Arrival time: " + tempArrivalLocalTimeActual.substring(12,16));
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalLocalTimeEstimatedActual

                            tempArrivalAirport = statusList.getString("arrivalAirportCode");
                            System.out.println("Arrival Airport Name: " +  tempArrivalAirport);
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalAirportName

                            tempArrivalGate = statusList.getString("arrivalGate");
                            System.out.println("Arrival Gate: " + tempArrivalGate);
                            //flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalGate
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "Error : " + error.toString());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer O68OqqGKNrb5EC2hEGE6YIVFGeae");
                return headers;
            }
        };

        queue.add(response);
        return tempDepartureAirport == null;
    }

    public FlightInfo getFlightInfo(String flightID, String date) {
        if (null == tempDepartureAirport) {
            return null;
        }
        FlightInfo info = new FlightInfo();
        info.setFlightNumber(flightID);
        info.setTakeOff(tempDepartureLocalTimeActual);
        info.setLanding(tempArrivalLocalTimeActual);
        info.setStartLocation(tempDepartureAirport);
        info.setEndLocation(tempArrivalAirport);
        info.setHasBaggage(false);
        info.setAtGate(false);

        return info;
    }

    public String getStartAirportByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempDepartureAirport);
        return tempDepartureAirport;
    }

    public String getDestinationAirportByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempArrivalAirport);
        return tempArrivalAirport;
    }

    /*public String getFlightNumberByUID(String FlightID) {

        return null; }
    */

    public String getArrivalTimeByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempArrivalLocalTimeActual);
        return tempArrivalLocalTimeActual;
    }

    public String getDepartureTimeByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempDepartureLocalTimeActual);
        return tempDepartureLocalTimeActual;
    }

    public String getDepartureGateByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempDepartureGate);
        return tempDepartureGate;
    }

    public String getArrivalGateByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempArrivalGate);
        return tempArrivalGate;
    }

    public String getStatusByFlightID(String flightID, String date) {
        System.out.println("temp: " + tempStatus);
        return tempStatus;
    }

    public String getBaggageTimeByUID(String uID) {
        return null;
    }

    public String getTSAWaitTimeByUID(String uID) {
        return null;
    }
}
