package com.cardgame.cardgame.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PromptGeneratorService {

    public PromptGeneratorService() {}

    // liste de 10 prompts pour générer des descriptions
    List<String> prompts = new ArrayList<String>(Arrays.asList(
        "short description for a beautiful sunset over the ocean",
        "short description in 20 words max for a cat with a hat",
        "short description in 20 words max for a dog playing with a ball",
        "short description in 20 words max for a dragon flying over a castle",
        "short description in 20 words max for a forest with a river",
        "short description in 20 words max for a house in the mountains",
        "short description in 20 words max for a lion in the savannah",
        "short description in 20 words max for a robot in a city",
        "short description in 20 words max for a spaceship in space",
        "short description in 20 words max for an unicorn in a field"
    ));

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String requestPromptGeneration(String prompt) {
        String url = "https://tp.cpe.fr:8088/llm-service/prompt/req";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        String body = "{ \"promptTxt\": \"" + prompt + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    //appel toutes les 5 secondes pour vérifier le statut de la génération de la description

    @Scheduled(fixedRate = 5000)
    public String getPromptGenerationStatus(String requestId) {
        
        String url = "https://tp.cpe.fr:8088/llm-service/prompt/req/" + requestId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());

        if  (response.getBody().split("\"state\": \"")[1] == null) {
        
            return "Error: Prompt generation request not found";
        }


        if (response.getBody().contains("PENDING")) {

            return "Prompt generation in progress";
        }

        return response.getBody().split("\"responsePromptTxt\": \"")[1];
    }

    public List<String> generateAllPrompts() {
        List<String> promptDescriptions = new ArrayList<>();
        for (String prompt : prompts) {
            String promptId = requestPromptGeneration(prompt);
            promptDescriptions.add(promptId);
        }
        return promptDescriptions;
    }

    

   
}

