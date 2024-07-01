package com.codedifferently.lesson7.randycastro;

public class Weather {
  // enum
  public enum WeatherCondition {
    SUNNY,
    RAINY;
  }

  private int temp;
  private String windDirection;
  private WeatherCondition weatherCondition;
  private int sunrise;
  private int sunset;

  // Constructor
  public Weather(
      int temp, String windDirection, WeatherCondition weatherCondition, int sunrise, int sunset) {

    this.temp = temp;
    this.windDirection = windDirection;
    this.weatherCondition = weatherCondition;
    this.sunrise = sunrise;
    this.sunset = sunset;
  }

  // functions//
  // created getters and setters

  public Weather() {
    // TODO Auto-generated constructor stub
  }

  public int getTemp() {
    return temp;
  }

  public void setTemp(int temp) {
    this.temp = temp;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public WeatherCondition getWeatherCondition() {
    return weatherCondition;
  }

  public int getSunrise() {
    return sunrise;
  }

  public void setSunrise(int i) {
    this.sunrise = i;
  }

  public int getSunset() {
    return sunset;
  }

  // public class TempOutOfBoundsException extends Exception {
  // public TempOutOfBoundsException(String message) {
  // super(message);

  // if loop, If sunny it will print out "It will be a sunny day!". Else, it will print out "It will
  // be a rainy day!".

  // Array

  // Constructor for Array

  public String checkWeatherCondition() {
    if (weatherCondition == WeatherCondition.SUNNY) {
      return "It will be a sunny day!";
    } else {
      return "It will be a rainy day!";
    }
  }

  public int printTemperatures() {
    int[] temperatures = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int count = 0;
    for (int i = 0; i < temperatures.length; i++) {
      try {
        // Print temperature information
        System.out.println("Temperature " + (i + 1) + ": " + temperatures[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        // Handle the exception (if index is out of bounds)
        System.out.println("Error: Temperature is out of bounds[] " + i);
      }
    }
    return count;
  }

  public void setWeatherCondition(WeatherCondition sunny) {}
}
