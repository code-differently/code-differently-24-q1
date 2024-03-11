package main.java.com.codedifferently.lesson5.dataprovider;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MekhiWilliamsProvider extends DataProvider {
    @Override
    public Map<String, Class> getColumnTypeByName() {
        return Map.of(
            "column1", Long.class,
            "column2", String.class,
            "column3", Double.class,
            "column4", Double.class,
            "column5", Boolean.class,
            "column6", Long.class,
            "column7", Integer.class
        );
    }
}
    
