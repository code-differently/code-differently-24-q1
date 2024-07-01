package main.java.com.codedifferently.lesson5.dataprovider;

import com.codedifferently.lesson5.dataprovider.DataProvider;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JordanEldridgeProvider extends DataProvider {
  public String getProviderName() {
    return "JordanEldridge";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", Integer.class,
        "column3", Short.class,
        "column4", Long.class,
        "column5", Boolean.class,
        "column6", String.class,
        "column7", Double.class);
  }
}
