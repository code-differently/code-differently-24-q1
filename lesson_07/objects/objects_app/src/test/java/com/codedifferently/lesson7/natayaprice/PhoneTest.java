package com.codedifferently.lesson7.natayaprice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.codedifferently.lesson7.natayaprice.Phone.Color;
import com.codedifferently.lesson7.natayaprice.Phone.InvalidPriceException;
import org.junit.jupiter.api.Test;

public class PhoneTest {

  @Test
  public void testConstructor() {
    Phone phone = new Phone(Color.BLUE, 500.0, "Samsung", "Verizon", 128);
    assertNotNull(phone);
    assertEquals(Color.BLUE, phone.getColor());
    assertEquals(500.0, phone.getPrice(), 0.01);
    assertEquals("Samsung", phone.getBrand());
    assertEquals("Verizon", phone.getServiceProvider());
    assertEquals(128, phone.getStorageCapacity());
  }

  @Test
  public void testGetColor() {
    Phone phone = new Phone(Color.BLUE, 500.0, "Samsung", "Verizon", 128);
    assertEquals(Color.BLUE, phone.getColor());
  }

  @Test
  public void testGetPrice() {
    Phone phone = new Phone(Color.GREEN, 600.0, "Apple", "AT&T", 256);
    assertEquals(600.0, phone.getPrice(), 0.01);
  }

  @Test
  public void testSetNegativePrice() throws Phone.InvalidPriceException {
    Phone phone = new Phone(Color.PINK, 700.0, "Google", "T-Mobile", 64);
    assertThrows(
        InvalidPriceException.class,
        () -> {
          phone.setPrice(-1);
        });
  }

  @Test
  public void testGetStorageCapacity() {
    Phone phone = new Phone(Color.BLACK, 800.0, "OnePlus", "Sprint", 512);
    assertEquals(512, phone.getStorageCapacity());
  }

  @Test
  public void testGetServiceProvider() {
    Phone phone = new Phone(Color.WHITE, 900.0, "Huawei", "AT&T", 256);
    assertEquals("AT&T", phone.getServiceProvider());
  }

  @Test
  public void testGetBrand() {
    Phone phone = new Phone(Color.YELLOW, 1000.0, "Motorola", "Verizon", 128);
    assertEquals("Motorola", phone.getBrand());
  }

  @Test
  public void testComparePrice() {
    int price1 = 500;
    int price2 = 600;
    int expectedDifference = -100;
    int actualDifference = Phone.comparePrice(price1, price2);
    assertThat(actualDifference).isEqualTo(expectedDifference);
  }

  @Test
  public void testListColor() {
    Phone phone = new Phone(Color.BLUE, 500.0, "Samsung", "Verizon", 128);
    try {
      phone.listColor();
    } catch (Exception e) {
      fail("Should not throw any exceptions");
    }
  }
}
