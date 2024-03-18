package com.codedifferently.lesson7.randycastro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.codedifferently.randycastro.Weather;

public class weathertest {

@Test
public void testConstructor() {
// Define test values for constructor parameters
int temp = 75;
String windDirection = "N";
Weather.WeatherCondition weatherCondition = Weather.WeatherCondition.SUNNY;
int sunrise = 600;
int sunset = 1800;

// Create a Weather object using the constructor
Weather weather = new Weather(temp, windDirection, weatherCondition, sunrise, sunset);

// Test getter methods to ensure values are set correctly
assertEquals(temp, weather.getTemp());
assertEquals(windDirection, weather.getWindDirection());
assertEquals(weatherCondition, weather.getWeatherCondition());
assertEquals(sunrise, weather.getSunrise());
assertEquals(sunset, weather.getSunset());
}




  @Test
  public void testCheckWeatherConditionSunny() {
    Weather weather = new Weather();  
    
    // Set the weather condition to SUNNY
      weather.setWeatherCondition(Weather.WeatherCondition.SUNNY);
      
      // Assert that the method returns the expected message for sunny weather
      assertEquals("It will be a sunny day!", weather.getWeatherCondition());
  }
}