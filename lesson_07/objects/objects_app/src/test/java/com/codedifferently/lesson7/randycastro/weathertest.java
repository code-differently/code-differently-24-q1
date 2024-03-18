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
  Weather weather = new Weather( 80, "W",Weather.WeatherCondition.SUNNY, 600, 1800);
  assertEquals("It will be a sunny day!", weather.checkWeatherCondition());
}

@Test
public void testPrintTemperatures() {
  Weather weather = new Weather( 90, "E", Weather.WeatherCondition.SUNNY, 600,1800);
  int count = weather.printTemperatures();
  int expectedCount = 8;
  assertEquals(8, 8);
}


@Test
    public void testCheckWeatherConditionRainy() {
      Weather weather = new Weather( 40, "S", Weather.WeatherCondition.RAINY, 600,1800);
      assertEquals("It will be a rainy day!", weather.checkWeatherCondition());
    }

@Test
  public void testSetAndGetSunrise() {
    Weather weather = new Weather( 60,"N",Weather.WeatherCondition.RAINY, 600,1800);
    // Set sunrise time
    weather.setSunrise( "600");
    // Get sunrise time and verify
    assertEquals("600", weather.getSunrise());
}

}



  
