package com.example.dailybrief;

import java.util.ArrayList;
import java.util.List;

public class Prioritizer {
    public List<String> rankItems(String weather, List<String> news, List<String> events) {
        List<String> prioritized = new ArrayList<>();
        prioritized.addAll(news);   // Breaking news first
        prioritized.add(weather);   // Weather next
        prioritized.addAll(events); // Calendar last
        return prioritized;
    }
}
