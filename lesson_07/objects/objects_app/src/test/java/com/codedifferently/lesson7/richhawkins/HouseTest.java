package com.codedifferently.lesson7.richhawkins;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson7.richhawkins.House.HouseType;
import org.junit.jupiter.api.Test;

public class HouseTest {

  @Test
  public void testCheckValidYear() {
    House house = new House("oak", 53);
    assertThatThrownBy(() -> house.checkValidYear(2030))
        .isInstanceOf(InvalidYearException.class)
        .hasMessage("Year must be equal to or less than current year.");
    assertThat(house.checkValidYear(2020)).isTrue();
  }

  @Test
  public void testPrintFullAddress() {
    House house = new House("Oak", 53);
    String fullAddress = house.printFullAddress();
    assertEquals("Your address is 53 Oak", fullAddress);
  }

  @Test
  public void testConstructor() {
    House house = new House("main", 123);
    assertEquals("main", house.streetName);
    assertEquals(123, house.streetNum);
  }

  @Test
  public void testEnum() {
    assertEquals(11, HouseType.values().length);
    assertEquals(HouseType.BUNGALOW, HouseType.valueOf("BUNGALOW"));
  }

  @Test
  public void testAllHouseType() {
    House house = new House("pine", 321);
    String allTypes = house.allHouseType();
    assertEquals(
        "APARTMENT BUNGALOW COTTAGE CAPECOD COLONIAL FARMHOUSE MANSION TINYHOME TOWNHOUSE SINGLEFAMILY SPLITLEVEL ",
        allTypes);
  }
}
