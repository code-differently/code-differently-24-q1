package com.codedifferently.lesson3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@SpringBootApplication
@PropertySource("classpath:answers.properties")
public class TestConfiguration {}
