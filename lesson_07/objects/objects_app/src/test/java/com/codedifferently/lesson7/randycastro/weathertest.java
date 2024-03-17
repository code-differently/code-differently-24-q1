package com.codedifferently.lesson7.randycastro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class weathertest {


class Weather {

public static Object WeatherCondition;

@Test
void getWeatherC(){

}

public void setSunrise(String string) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'setSunrise'");
}

public void setSunset(String string) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'setSunset'");
}

public void printSunriseAndSunset(int i) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'printSunriseAndSunset'");
}

public void checkWeatherCondition() {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'checkWeatherCondition'");
}

public void printTemperatures() {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'printTemperatures'");
}



}

public class WeatherTest {
  // Inner class Weather
  public class Weather {

    public void setSunrise(String string) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setSunrise'");
    }

    public void setSunset(String string) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setSunset'");
    }

    public void printSunriseAndSunset(int i) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'printSunriseAndSunset'");
    }
      // Weather class implementation
  }
@Test
    public static void main(String[] args) {
      // Create an instance of the Weather class
      Weather weather = new Weather();

      // Set sunrise and sunset times for testing
      weather.setSunrise("6:00 AM");
      weather.setSunset("6:00 PM");

      // Call the printSunriseAndSunset method with the number of days
      weather.printSunriseAndSunset(7);
    }
  



    public void testCheckWeatherCondition() {
        Weather weather = new Weather(75, "N", Weather.WeatherCondition.SUNNY, 60, 600, 1800);
        weather.checkWeatherCondition();
    }
  }
}