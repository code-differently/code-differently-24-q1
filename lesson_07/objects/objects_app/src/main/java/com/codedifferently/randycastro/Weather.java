package com.codedifferently.randycastro;

import java.lang.reflect.Array;

import com.codedifferently.randycastro.Weather.WeatherCondition;

public class Weather {
   //enum
public enum WeatherCondition {
    SUNNY, RAINY;
}
private int temp;
private String windDirection;
private WeatherCondition weatherCondition;
private int sunrise;
private int sunset;
// Constructor
public Weather(int temp, String windDirection, WeatherCondition weatherCondition, int sunrise, int sunset) {
     
  this.temp = temp;
  this.windDirection = windDirection;
  this.weatherCondition = weatherCondition;
  this.sunrise = sunrise;
  this.sunset = sunset;
}
  
  // functions//
  // created getters and setters 

  public Weather() {
  //TODO Auto-generated constructor stub
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

  public void setSunrise( int sunrise) {
    this.sunrise = sunrise;
  }

  public int getSunset() {
    return sunset;
  }

 
 //public class TempOutOfBoundsException extends Exception {
    //public TempOutOfBoundsException(String message) {
       // super(message);
     
  


// if loop, If sunny it will print out "It will be a sunny day!". Else, it will print out "It will be a rainy day!".


  
//Array

// Constructor for Array 
 
public String checkWeatherCondition() {
  if (weatherCondition == WeatherCondition.SUNNY) {
      return "It will be a sunny day!";
  } else {
      return "It will be a rainy day!";
  }
}




public int printTemperatures() {
  int[] temperatures = {10,20,30,40,50,60,70,80,90,100};
  for(int i = 0; i < temperatures.length; i++) {
      try {
          // Print temperature information
          System.out.println("Temperature " + (i + 1) + ": " + temperatures[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
          // Handle the exception (if index is out of bounds)
          System.out.println("Error: Temperature is out of bounds[] " + i);
}
  }
}

public void setWeatherCondition(WeatherCondition sunny) {
 
}
}

  
  























// for loop




/*                                     5 Member Variables
1 Temp                data type: int
2 Wind direction      data type: String
3 Weather condition   data type: Boolean
4 Humidity            data type: int
5 Sunrise/ Sunset      data type: int

                                        3 Different Types
1 int
2 boolean
3 double

                                            Enum

public enum Weathercondition {
    Sunny
    Rainy
    Snow
}
                                            Constructor

public class weather {
    int temp
    string condition

}
(int temp, wind direction, weather condition, humidity, sunrise/ sunset)

Constructing weather by including these variables



                                            3 Member Functions
1
2
3

                                            1 Conditional expressions (if)
1 if time == 7:13am - 7:33am
print sunrise
else if time == 7:09pm - 7:39pm
print sunset
else
print


                                            Loop (for, while)

        for()



                                            1 Custom Exception
1





                                       Collection (array)


*/
