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

    public JsonObjectRequest getRequest(String url) {
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
    }

    public String getStartAirportByUID(String uID) { return null; }

    public String getDestinationAirportByUID(String uID) { return null; }

    public String getFlightNumberByUID(String uID) { return null; }

    public String getArrivalTimeByUID(String uID) {
        String uri =
                String.format("http://deltaairlines-dev.apigee.net/v1/hack/flight/status?flightNumber=1969&flightOriginDate=2017-10-14");
        queue.add(getRequest(uri));
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
