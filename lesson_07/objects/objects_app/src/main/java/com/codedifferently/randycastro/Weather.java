package com.codedifferently.randycastro;

import java.lang.reflect.Array;

public class Weather {
  
   //enum
   public enum WeatherCondition { 
    SUNNY, RAINY;
  
  public int temp;
  public String windDirection;
  public WeatherCondition weatherCondition;
  public int humidity;
  public int sunrise;
  public int sunset;
}

  private int temp;
  private String windDirection;
  private WeatherCondition weatherCondition;
  private int humidity;
  private int sunrise;
  private int sunset;
 
  
  // Constructor

  public Weather( 
    int temp, 
    String windDirection,
    WeatherCondition weatherCondition,
    int humidity, 
    int sunrise, 
     int sunset) {

    this.temp = temp;
    this.windDirection = windDirection;
    this.weatherCondition = weatherCondition;
    this.humidity = humidity;
    this.sunrise = sunrise;
    this.sunset = sunset;
}

  // functions//
  // created getters and setters 

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

  public void setSunset( int sunset) {
    this.sunset = sunset;
  
    // for loop
    for (int i = 1; i <= 3; i++) {
      System.out.println("Day" + i + "Sunrise at" + sunrise + " and sunset at" + sunset);
    }
  
  }

// if loop, If sunny it will print out "It will be a sunny day!". Else, it will print out "It will be a rainy day!".

public void checkWeatherCondition() {
  if (weatherCondition == WeatherCondition.SUNNY) {
      System.out.println("It will be a sunny day!");
  } else {
      System.out.println("It will be a rainy day!");


  }
//Array

// Constructor for Array 
public static class Weather {
  private int [] Tempatures;
  private int[] tempatures;
  private String[] temperatures;
  public Weather (int[] Tempatures ) {
    this.tempatures = Tempatures;
  
}


  public void printTempatures() {
int[] tempatures = {10,20,30,40,50,60,70,80,90,100};

for(int i = 0; i < tempatures.length; i++){
  try {
    // Print temperature information
    System.out.println("Temperature " + (i + 1) + ": " + temperatures[i]);
} catch (ArrayIndexOutOfBoundsException e) {
    // Handle the exception (if index is out of bounds)
    System.out.println("Error: Temp is out of bounds[] " + i);
}
}
}
}
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
