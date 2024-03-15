package com.codedifferently.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson7 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson7.class);
    application.run(args);
  }

  public class Weather {
    public int temp;
    public String windDirection;
    public Boolean weatherCondition;
    public int humidity;
    public int sunrise;
    public int sunset;
  }

  // Constructor

  public Weather(
      int temp,
      String windDirection,
      Boolean weatherCondition,
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
  // create getters and setters to grab temp

  public int gettemp(){
return temp;}
  public void setTemp(int temp) {
  this.temp = temp;
  }

  public String getWindDirection(){
    return windDirection;
  }
  public void setWindDirecction(){
    this.windDirection =windDirection;
  }
public Boolean getweatherCondition(){
    return weatherCondition;
}
public int getSunrise(){
    retrun sunrise;
}
public void setSunrise(){
    this.sunrise = sunrise;
}
public int getSunset(){
    return sunset;
}
public void setSunset(){
    this.sunset = sunset;
}


 
 

  }


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
