package com.codedifferently.lesson7.javyenware;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class BookTest {


 @Test
 public void testConstructor() {
   assertThat(new Lesson7()).isNotNull();
   
 }
}
