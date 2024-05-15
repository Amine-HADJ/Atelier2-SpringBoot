package com.cardgame.cardgame.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImgGeneratorService {

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String requestImageGeneration(String prompt) {
        String url = "/img-service/prompt/req";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        String body = "{ \"promptTxt\": \"" + prompt + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public String getImageGenerationStatus(String requestId) {
        String url = "/img-service/prompt/req/api/" + requestId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}
