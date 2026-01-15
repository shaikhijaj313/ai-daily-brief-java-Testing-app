package com.example.dailybrief;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient();

    public NewsService(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<String> getNews(List<String> interests) {
        List<String> headlines = new ArrayList<>();
        try {
            for (String interest : interests) {
                String url = "https://newsapi.org/v2/everything?q=" + interest + "&apiKey=" + apiKey + "&pageSize=2";
                Request request = new Request.Builder().url(url).build();
                Response response = client.newCall(request).execute();
                JSONObject json = new JSONObject(response.body().string());
                JSONArray articles = json.getJSONArray("articles");
                for (int i = 0; i < articles.length(); i++) {
                    headlines.add(articles.getJSONObject(i).getString("title"));
                }
            }
        } catch (Exception e) {
            headlines.add("News unavailable.");
        }
        return headlines;
    }
}
