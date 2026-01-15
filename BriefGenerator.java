package com.example.dailybrief;

import java.util.List;

public class BriefGenerator {
    private final LlmService llmService;

    public BriefGenerator(LlmService llmService) {
        this.llmService = llmService;
    }

    public String generateBrief(List<String> prioritized, String tone) {
        return llmService.summarize(prioritized, tone);
    }
}
