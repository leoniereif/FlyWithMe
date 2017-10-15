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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sam on 10/14/17.
 */

public class DeltaApiDelegate {
    private RequestQueue queue;
    public DeltaApiDelegate(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    /*public JsonObjectRequest getRequest(String url) {
        // Request a string response from the provided URL.
        JsonObjectRequest response = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", "Response : " + response.toString());
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

        return response;
    }*/
    public HashMap<String, String> getFlightInfoByFlightID(final String flightID, String date) {
        String url = String.format("http://deltaairlines-dev.apigee.net/v1/hack/flight/status?flightNumber=1969&flightOriginDate=2017-10-14");
        //String url = String.format("http://deltaairlines-dev.apigee.net/v1/hack/flight/status?flightNumber=%s&flightOriginDate=%s", flightID, date);

        // tmp hash map results
        final HashMap<String, String> flightInfo = new HashMap<>();
        JsonObjectRequest response = new JsonObjectRequest(Request.Method.GET, url, null,
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

                            String status = reader.getJSONObject("flightStatusResponse").getString("status");
                            flightInfo.put("status: ", status);
                            /*flightStatusResponse.status*/

                            String flightNumber = statusResponse.getString("flightNumber");
                            flightInfo.put("flightNumber", flightNumber);
                            System.out.println("Flight Number: " + flightNumber);
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightNumber*/

                            String departureAirportCode = statusList.getString("departureAirportCode");
                            String departureAirportName = statusList.getString("departureAirportName");
                            String departureAirportResult = departureAirportName + " (" + departureAirportCode + ")";
                            flightInfo.put("departureAirportResult", departureAirportResult);
                            System.out.println("Departure Airport Name: " + departureAirportResult);
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].departureAirportName*/

                            String departureGate = statusList.getString("departureGate");
                            flightInfo.put("departureGate",departureGate);
                            System.out.println("Departure Gate: " + departureGate);
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].departureGate*/

                            String departureLocalTimeActual = statusList.getString("departureLocalTimeEstimatedActual");
                            flightInfo.put("departureLocalTimeActual", departureLocalTimeActual);
                            System.out.println("Departure time: " + departureLocalTimeActual.substring(12,16));
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalLocalTimeEstimatedActual*/

                            String arrivalLocalTimeActual = statusList.getString("arrivalLocalTimeEstimatedActual");
                            flightInfo.put("arrivalLocalTimeActual", arrivalLocalTimeActual);
                            System.out.println("Arrival time: " + arrivalLocalTimeActual.substring(12,16));
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalLocalTimeEstimatedActual*/

                            String arrivalAirportCode = statusList.getString("arrivalAirportCode");
                            String arrivalAirportName = statusList.getString("arrivalAirportName");
                            String arrivalAirportResult = arrivalAirportName + " (" + arrivalAirportCode + ")";
                            flightInfo.put("arrivalAirportResult", arrivalAirportResult);
                            System.out.println("Arrival Airport Name: " + arrivalAirportResult);
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalAirportName*/

                            String arrivalGate = statusList.getString("arrivalGate");
                            flightInfo.put("arrivalGate",arrivalGate);
                            System.out.println("Arrival Gate: " + arrivalGate);
                            /*flightStatusResponse.statusResponse.flightStatusTO.flightStatusLegTOList[].arrivalGate*/

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

        System.out.println(flightInfo);
        return flightInfo;
    }

    public String getStartAirportByFlightID(String flightID, String date) {
        HashMap<String, String> map = getFlightInfoByFlightID(flightID, date);
        System.out.println(map.get("arrivalAirportResult"));

        return null;
    }

    public String getDestinationAirportByFlightID(String uID) { return null; }

    public String getFlightNumberByUID(String FlightID) { return null; }

    public String getArrivalTimeByFlightID(String flightID, String date) {
        return null;
    }

    public String getDepartureTimeByUID(String uID) {
        return null;
    }

    public String getBaggageTimeByUID(String uID) {

        return null;
    }

    public String getTSAWaitTimeByUID(String uID) {
        return null;
    }

}
