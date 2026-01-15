package com.example.dailybrief;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class WeatherService {
    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient();

    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getWeather(String location) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&units=metric";
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject(response.body().string());
            String desc = json.getJSONArray("weather").getJSONObject(0).getString("description");
            double temp = json.getJSONObject("main").getDouble("temp");
            return "Weather in " + location + ": " + desc + ", " + temp + "°C.";
        } catch (Exception e) {
            return "Weather unavailable.";
        }
    }
}
