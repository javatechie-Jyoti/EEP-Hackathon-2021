package com.user.service;

import com.user.model.UserProfileDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class FinTechApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FinTechApplication.class, args);
        System.out.println("Server Started");

       /* Runnable runnable = new Runnable() {
            @Override
            public void run() {
                retrieveUserProfile();
            }
        };

       *//* ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(runnable, 0,30, TimeUnit.SECONDS);*/
        retrieveUserProfile();

    }

    public static void retrieveUserProfile(){
        System.out.println("Connecting to Facebook Graph API");
        String url = "https://graph.facebook.com/v12.0/me?fields=id,name,gender,email&access_token=EAAF6WGskJN8BACzpXPetu2fqTgMkHC03wWQ9ZA8QLeo2iDsLDG1p7CrVWy3OkA1GeqGKPHxrGFtEyBAZCJHnDujRpJaHxuVzNAEO0YheOFEkjHvZB0e4xLDZAZBHXl9rgldhYw7Js7Wz8w1KutlcIuf6agZAZBD7vWKnpoMODdvHxJaMIpWE2ocLIM7sCEg8ZClUXg8J1Ts5JJDGoMSvAP8yululWgDmG7k1VHAzJvHRktiDWBdDiK41JkMk6XwYk1cZD";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("accept", "application/json");
//        httpHeaders.set("Accept-Language", "hi_IN");
//        httpHeaders.set("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");

        HttpEntity<UserProfileDTO> requestEntity = new HttpEntity<UserProfileDTO>(httpHeaders);

        ResponseEntity<UserProfileDTO> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserProfileDTO.class);

        System.out.println("Retrieved User Profile:" + response.getBody());
    }
}
