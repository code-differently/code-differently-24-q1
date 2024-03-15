package com.codedifferently.lesson7.natayaprice; 

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.codedifferently.lesson7.natayaprice.Phones.InvalidPriceException;

public class PhonesTest {

    @Test
    public void testConstructor() {
        Phones phone = new Phones("BLUE", 500.0, "Samsung", "Verizon", 128);
        assertNotNull(phone);
        assertEquals("BLUE", phone.getColor());
        assertEquals(500.0, phone.getPrice(), 0.01);
        assertEquals("Samsung", phone.getBrand());
        assertEquals("Verizon", phone.getServiceprovider());
        assertEquals(128, phone.getStoragecapacity());
    }

 @Test
    public void testGetColor() {
        Phones phone = new Phones("BLUE", 500.0, "Samsung", "Verizon", 128);
        assertEquals("BLUE", phone.getColor());
    }


    @Test
    public void testGetPrice() {
        Phones phone = new Phones("GREEN", 600.0, "Apple", "AT&T", 256);
        assertEquals(600.0, phone.getPrice(), 0.01);
    }

    @Test
    public void testSetNegativePrice() throws Phones.InvalidPriceException {
        Phones phone = new Phones("PINK", 700.0, "Google", "T-Mobile", 64);
            assertThrows(
            InvalidPriceException.class,
            () -> {
              phone.setPrice(-1);
            });
    }

    @Test
    public void testGetStorageCapacity() {
        Phones phone = new Phones("BLACK", 800.0, "OnePlus", "Sprint", 512);
        assertEquals(512, phone.getStoragecapacity());
    }

    @Test
    public void testGetServiceProvider() {
        Phones phone = new Phones("WHITE", 900.0, "Huawei", "AT&T", 256);
        assertEquals("AT&T", phone.getServiceprovider());
    }

    @Test
    public void testGetBrand() {
        Phones phone = new Phones("YELLOW", 1000.0, "Motorola", "Verizon", 128);
        assertEquals("Motorola", phone.getBrand());
    }

    @Test
    public void testComparePrice() {
        Phones.comparePrice(500, 600);
        // Output should be "The difference between 500 && 600 is: -100"
    }

    @Test
    public void testListColor() {
        Phones phone = new Phones("BLUE", 500.0, "Samsung", "Verizon", 128);
        phone.listColor();
        // This test will print out all colors in the Color enum
    }
}

    

