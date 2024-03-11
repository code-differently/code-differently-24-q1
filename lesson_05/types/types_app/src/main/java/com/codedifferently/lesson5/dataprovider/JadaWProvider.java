package main.java.com.codedifferently.lesson5.dataprovider;

import com.codedifferently.lesson5.dataprovider.DataProvider;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JadaWProvider extends DataProvider {
  public String getProviderName() {
    return "jadawhite";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1",
        Integer.class,
        "column2",
        String.class,
        "column3",
        Boolean.class,
        "column4",
        Float.class,
        "column5",
        Double.class,
        "column6",
        Long.class,
        "column7",
        Short.class);
  }
}
