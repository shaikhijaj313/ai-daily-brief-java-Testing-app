package com.example.dailybrief;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class LocationService {
    private final OkHttpClient client = new OkHttpClient();

    public String getLocation() {
        try {
            Request request = new Request.Builder()
                .url("http://ip-api.com/json")
                .build();
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject(response.body().string());
            String city = json.getString("city");
            String countryCode = json.getString("countryCode");
            return city + "," + countryCode;
        } catch (Exception e) {
            return "Delhi,IN"; // fallback
        }
    }
}
