package com.codedifferently.lesson6;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Lesson6.class)
@ExtendWith(SoftAssertionsExtension.class)
class Lesson6Test {
  @Test
  void testLesson6_works() {
    assertThat(true).isEqualTo(true);
  }
}
