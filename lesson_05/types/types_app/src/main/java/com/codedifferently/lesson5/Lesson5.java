package com.codedifferently.lesson5;

import static com.codedifferently.lesson5.generator.Generators.*;

import java.io.File;
import java.nio.file.Paths;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson5 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson5.class);
    application.run(args);
  }

  public void run(String... args) {
    // var providerName = "anthonymays";
    // String path = getDataPath();
    // var fileGenerator = new SampleFileGenerator();
    // fileGenerator.createTestFile(path, providerName);

    var parser = new com.codedifferently.lesson5.parser.AnthonyMaysParser();
    System.out.println(parser.getParsedData().get(0).get("column1"));
  }

  private static String getDataPath() {
    String[] pathParts = {
      Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", "data"
    };
    return String.join(File.separator, pathParts);
  }
}
