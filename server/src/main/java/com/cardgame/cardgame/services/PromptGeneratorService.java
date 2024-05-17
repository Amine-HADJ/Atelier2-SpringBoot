package com.cardgame.cardgame.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PromptGeneratorService {

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String requestPromptGeneration(String prompt) {
        String url = "tp.cpe.fr:8088/llm-service/prompt/req";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        String body = "{ \"promptTxt\": \"" + prompt + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public String getPromptGenerationStatus(String requestId) {
        String url = "tp.cpe.fr:8088/llm-service/prompt/req/" + requestId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}
