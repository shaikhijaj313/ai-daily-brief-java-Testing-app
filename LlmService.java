package com.example.dailybrief;

import java.util.List;

public class LlmService {
    private final String apiKey;

    public LlmService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String summarize(List<String> items, String tone) {
        // Placeholder: integrate with OpenAI API if desired
        StringBuilder sb = new StringBuilder();
        sb.append("Here is your ").append(tone).append(" daily brief:\n\n");
        for (String item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("\nStay informed and have a great day!");
        return sb.toString();
    }

    public String askQuestion(String question, List<String> context) {
        if (question.toLowerCase().contains("top news") && !context.isEmpty()) {
            return context.get(0);
        }
        return "I'm not sure, but here's something: " + (context.isEmpty() ? "No news available." : context.get(0));
    }
}
