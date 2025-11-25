


package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.units}")
    private String units;

    public WeatherResponse getWeatherByCity(String city) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", units)
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);

        String cityName = json.getString("name");
        String country = json.getJSONObject("sys").getString("country");
        double temp = json.getJSONObject("main").getDouble("temp");
        double feelsLike = json.getJSONObject("main").getDouble("feels_like");
        int humidity = json.getJSONObject("main").getInt("humidity");
        int pressure = json.getJSONObject("main").getInt("pressure");
        double windSpeed = json.getJSONObject("wind").getDouble("speed");
        double visibility = json.getDouble("visibility");
        String condition = json.getJSONArray("weather")
                               .getJSONObject(0)
                               .getString("description");

        WeatherResponse wr = new WeatherResponse();
        wr.setCity(cityName);
        wr.setCountry(country);
        wr.setTemperature(temp);
        wr.setFeelsLike(feelsLike);
        wr.setHumidity(humidity);
        wr.setPressure(pressure);
        wr.setWindSpeed(windSpeed);
        wr.setVisibility(visibility);
        wr.setCondition(condition);

        return wr;
    }
}
