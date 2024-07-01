package com.codedifferently.lesson7.richhawkins;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson7.richhawkins.House.HouseType;
import org.junit.jupiter.api.Test;

public class HouseTest {

  @Test
  public void testSetYearBuilt() {
    House house = new House("Pine", 234);

    house.setYearBuilt(2020);
    assertEquals(2020, house.getYearBuilt());

    assertThatThrownBy(() -> house.setYearBuilt(2030))
        .isInstanceOf(InvalidYearException.class)
        .hasMessage("Error: Must enter a valid year.");
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
    assertEquals("main", house.getStreetName());
    assertEquals(123, house.getStreetNum());
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

  @Test
  public void testHasGarage() {
    House house = new House("Oak", 123);
    house.setHasGarage(true);
    assertEquals(true, house.getHasGarage());
  }

  @Test
  public void testNumberOfBedrooms() {
    House house = new House("Oak", 123);
    house.setNumberOfBedrooms(4);
    assertEquals(4, house.getNumberOfBedrooms());
  }
}
