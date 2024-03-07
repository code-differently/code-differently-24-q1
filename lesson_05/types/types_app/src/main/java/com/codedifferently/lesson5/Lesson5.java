package com.codedifferently.lesson5;

import com.codedifferently.lesson5.util.SampleFileGenerator;

import com.google.common.io.Files;
import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
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
      String providerName = "test";
      String[] pathParts = { Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", providerName };
      String path = String.join(File.separator, pathParts);

      System.out.println("Creating a test file at: " + path + File.separator + "input.json");
      var fileGenerator = new SampleFileGenerator();
      fileGenerator.createTestFile(providerName);
  }
}
