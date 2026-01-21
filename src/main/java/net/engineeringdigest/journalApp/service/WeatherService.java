package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private  String apiKey;

    //private static final String API = "http://api.openweathermap.org/data/2.5/weather?q=CITY&appid=API_KEY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city) {
        try {
            String apiTemplate = appCache.AppCache.get("WEATHER_API");

            if(apiTemplate == null){
                throw new RuntimeException("Weather API not found in cache");
            }

            String finalAPI = apiTemplate
                    .replace("CITY", URLEncoder.encode(city, StandardCharsets.UTF_8))
                    .replace("API_KEY", apiKey);

            System.out.println("Calling API: " + finalAPI);

            ResponseEntity<WeatherResponse> response =
                    restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);

            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





}
