package com.example.dailybrief;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Auto-detect location
        LocationService locationService = new LocationService();
        String location = locationService.getLocation();
        System.out.println("Detected location: " + location);

        WeatherService weatherService = new WeatherService(System.getenv("OPENWEATHER_API_KEY"));
        NewsService newsService = new NewsService(System.getenv("NEWS_API_KEY"));
        CalendarService calendarService = new CalendarService();
        Prioritizer prioritizer = new Prioritizer();
        LlmService llmService = new LlmService(System.getenv("OPENAI_API_KEY"));

        String weather = weatherService.getWeather(location);
        List<String> news = newsService.getNews(List.of("technology", "sports"));
        List<String> events = calendarService.getEvents();

        List<String> prioritized = prioritizer.rankItems(weather, news, events);

        BriefGenerator generator = new BriefGenerator(llmService);
        String brief = generator.generateBrief(prioritized, "professional");

        System.out.println("\n=== Your Daily Brief ===");
        System.out.println(brief);

        // Example Q&A
        String question = "What's the top news today?";
        String answer = llmService.askQuestion(question, news);
        System.out.println("\nQ: " + question);
        System.out.println("A: " + answer);
    }
}
