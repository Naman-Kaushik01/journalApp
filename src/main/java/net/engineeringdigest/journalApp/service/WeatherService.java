package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    private static final String apiKey = "b13fd6108faeab56e7b9584fd709e739";

    private static final String API = "http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=API_KEY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        try {
            String finalAPI = API.replace("CITY", URLEncoder.encode(city, StandardCharsets.UTF_8))
                    .replace("API_KEY", apiKey);

            ResponseEntity<WeatherResponse> response =
                    restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);

            return response.getBody();

        } catch (Exception e) {
            System.out.println("Weather API error: " + e.getMessage());
            return null;
        }
    }




}
