package com.codedifferently.lesson7.mohamedobjects.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.Test;

class ComputerPartsTest {
  CPU cpu = new CPU("M1", 2020, cpuBrand.INTEL, 23.32);
  GPU bGpu = new GPU("Radion 560 xt", 2015, "AMD", 8);
  Part apart = new Part();

  @Test
  public void testCpuConstruction() {
    assertEquals(23.32, cpu.getClockSpeed());

    assertNotEquals(8, cpu.getCores());

    cpu.setCores(8);

    assertEquals(8, cpu.getCores());

    assertEquals(2020, cpu.getReleaseYear());

    assertNotEquals("M2", cpu.getName());
  }

  @Test
  void testGpuConstruction() {

    Set<portType> porty = Set.of(portType.DP, portType.HDMI, portType.VGA);
    bGpu.addPorts(portType.DP);
    bGpu.addPorts(portType.HDMI);
    bGpu.addPorts(portType.VGA);
    assertEquals(porty, bGpu.getPorts());

    assertEquals(3, bGpu.calculateNumPorts());
  }

  @Test
  void testYearValadation() {
    assertThrows(
        IllegalYearExeption.class,
        () -> {
          bGpu.checkValidYear(1999);
        });
    assertThrows(
        IllegalYearExeption.class,
        () -> {
          bGpu.checkValidYear(3000);
        });
  }

  @Test
  void testPartConstruction() {
    apart.setBrand("A Brand");
    apart.setName("A Part");
    apart.setReleaseYear(2011);
    assertEquals("A Brand", apart.getBrand());
    assertEquals("A Part", apart.getName());
    assertEquals(2011, apart.getReleaseYear());
  }
}
