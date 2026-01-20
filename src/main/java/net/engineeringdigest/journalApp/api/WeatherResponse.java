package net.engineeringdigest.journalApp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {

    private Main main;

    @Getter
    @Setter
    public static class Main {

        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;
    }
}
