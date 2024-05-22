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
import org.springframework.web.client.RestClientException;

@Service
public class ImgGeneratorService {

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate;

    // Liste de 10 prompts pour générer des images
    private final List<String> prompts = Arrays.asList(
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
    );

    public ImgGeneratorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestImageGeneration(String prompt) {
        String url = "http://tp.cpe.fr:8088/img-service/prompt/req";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        String body = "{ \"promptTxt\": \"" + prompt + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return response.getBody();
        } catch (RestClientException e) {
            // Log and handle the exception
            e.printStackTrace();
            return null;
        }
    }

    public String getImageGenerationStatus(String requestId) {
        String url = "http://tp.cpe.fr:8088/img-service/prompt/req/api/" + requestId;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (RestClientException e) {
            // Log and handle the exception
            e.printStackTrace();
            return null;
        }
    }

    public String getImageUrl(String requestId) {
        String statusJson = getImageGenerationStatus(requestId);
        if (statusJson != null) {
            // Extract URL from the JSON response
            String imageUrl = extractImageUrlFromJson(statusJson);
            if (imageUrl != null) {
                return "http://tp.cpe.fr:8088/img-service" + imageUrl;
            }
        }
        return null;
    }

    private String extractImageUrlFromJson(String json) {
       

        String url = "http://tp.cpe.fr:8088/img-service/" + json.split("\"url\": \"")[1].split("\"")[0];
        return url;
    }

    public List<String> generateAllImages() {
        List<String> imageUrls = new ArrayList<>();
        for (String prompt : prompts) {
            String requestId = requestImageGeneration(prompt);
            if (requestId != null) {
                String imageUrl = getImageUrl(requestId);
                if (imageUrl != null) {
                    imageUrls.add(imageUrl);
                }
            }
        }
        return imageUrls;
    }
}
