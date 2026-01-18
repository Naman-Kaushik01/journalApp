package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String apiKey = "7cc951e2f85da879566d1bed0d047ae7";

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        try {
            String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);

            ResponseEntity<WeatherResponse> response =
                    restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);

            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();   // 🔥 THIS will show real cause in console
            return null;
        }
    }



}
