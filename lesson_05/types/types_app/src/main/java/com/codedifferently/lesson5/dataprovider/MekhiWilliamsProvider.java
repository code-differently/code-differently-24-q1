

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MekhiWilliamsProvider extends DataProvider {

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", String.class,

  }
}
