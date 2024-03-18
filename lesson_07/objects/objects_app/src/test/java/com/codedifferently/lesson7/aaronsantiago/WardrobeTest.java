package com.codedifferently.lesson7.aaronsantiago;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WardrobeTest {

    @Test
    public void testAddClothes() throws Exception {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 5, "2024-01-01", "Walk-in", 12345);
        wardrobe.addClothes("T-shirt");
        assertEquals(1, wardrobe.getClothes().size());
    }

    @Test
    public void testRemoveClothes() throws Exception {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 5, "2024-01-01", "Walk-in", 12345);
        wardrobe.addClothes("T-shirt");
        wardrobe.removeClothes("T-shirt");
        assertEquals(0, wardrobe.getClothes().size());
    }

    @Test
    public void testAddClothesExceedingCapacity() {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 1, "2024-01-01", "Walk-in", 12345);
        assertDoesNotThrow(() -> wardrobe.addClothes("T-shirt"));
        Exception exception = assertThrows(Exception.class, () -> wardrobe.addClothes("Jeans"));
        assertEquals("Wardrobe is full! Cannot add more clothes.", exception.getMessage());
    }

    @Test
    public void testRemoveClothesNotInWardrobe() {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 5, "2024-01-01", "Walk-in", 12345);
        Exception exception = assertThrows(Exception.class, () -> wardrobe.removeClothes("Sweater"));
        assertEquals("Item not found in the wardrobe.", exception.getMessage());
    }

    @Test
    public void testAddAdditionalInfo() {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 5, "2024-01-01", "Walk-in", 12345);
        wardrobe.addAdditionalInfo(1, "Preferred style: Casual");
        assertEquals("Preferred style: Casual", wardrobe.getAdditionalInfo(1));
    }

    @Test
    public void testRemoveAdditionalInfo() {
        Wardrobe wardrobe = new Wardrobe("Aaron Santiago", 5, "2024-01-01", "Walk-in", 12345);
        wardrobe.addAdditionalInfo(1, "Preferred style: Casual");
        wardrobe.removeAdditionalInfo(1);
        assertNull(wardrobe.getAdditionalInfo(1));
    }
}
