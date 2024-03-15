import com.codedifferently.lesson7.Weather;


class weathertest {

  public class Main {
    public static void main(String[] args) {
      // Create an instance of the Weather class
      Weather weather = new Weather();

      // Set sunrise and sunset times for testing
      weather.setSunrise("6:00 AM");
      weather.setSunset("6:00 PM");

      // Call the printSunriseAndSunset method with the number of days
      weather.printSunriseAndSunset(7);
    }
  }
}

    // if loop. To print out message during Sunset/Sunrise hours.
    // if(time == 7:13am, 7:33am)
    // system.outPrintln (Sunrise, Good Morning);

    // else if(time == 7:09pm, 7:39pm)
    // sustem.outPrintln (Sunset, Good Night)
