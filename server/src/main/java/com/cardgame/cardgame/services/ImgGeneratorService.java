package com.cardgame.cardgame.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImgGeneratorService {

    // liste de 10 prompts pour générer des images
    List<String> prompts = new ArrayList<String>(Arrays.asList(
        "A beautiful sunset over the ocean",
        "A cat with a hat",
        "A dog playing with a ball",
        "A dragon flying over a castle",
        "A forest with a river",
        "A house in the mountains",
        "A lion in the savannah",
        "A robot in a city",
        "A spaceship in space",
        "A unicorn in a field"
    ));

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate;

    public ImgGeneratorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestImageGeneration(String prompt) {
        String url = "tp.cpe.fr:8088/img-service/prompt/req";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        String body = "{ \"promptTxt\": \"" + prompt + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    

    public String getImageGenerationStatus(String requestId) {
        String url = "tp.cpe.fr:8088/img-service/prompt/req/api/" + requestId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public List<String> generateAllImages() {
        List<String> imageUrls = new ArrayList<>();
        for (String prompt : prompts) {
            String requestiD = requestImageGeneration(prompt);
            String imageUrl = getImageGenerationStatus(requestiD);
            imageUrls.add(imageUrl);
        }
        return imageUrls;
    }
}
