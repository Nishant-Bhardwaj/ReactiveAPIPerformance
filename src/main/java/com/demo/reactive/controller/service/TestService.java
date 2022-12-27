package com.demo.reactive.controller.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TestService {

    public Mono<String> predictGender(String name) {
        //Make API call:

        return WebClient.builder()
                .build()
                .get()
                .uri("https://api.genderize.io/?name=" + name)
                .retrieve()
                .bodyToMono(String.class);

    }

    public ResponseEntity<String> predictGenderResponse(String name) {
        //Make API call:

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate
                .exchange(
                        "https://api.genderize.io/?name=" + name,
                        HttpMethod.GET, null,
                        String.class
                );

    }

    public Mono<String> predictGenderResponseWeb(String name) {

        return WebClient.builder()
                .build()
                .get()
                .uri("https://api.genderize.io/?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
    }
}
