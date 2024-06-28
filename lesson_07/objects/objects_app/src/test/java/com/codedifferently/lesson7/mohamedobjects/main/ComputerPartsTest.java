package com.codedifferently.lesson7.mohamedobjects.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.Test;

class ComputerPartsTest {

  @Test
  public void testCpuConstruction() {
    CPU cpu = new CPU("M1", 2020, cpuBrand.INTEL, 23.32);

    assertEquals(23.32, cpu.getClockSpeed());
    assertNotEquals(8, cpu.getCores());

    cpu.setCores(8);

    assertEquals(8, cpu.getCores());
    assertEquals(2020, cpu.getReleaseYear());
    assertNotEquals("M2", cpu.getName());
  }

  @Test
  void testGpuConstruction() {
    GPU bGpu = new GPU("Radion 560 xt", 2015, "AMD", 8);
    Set<portType> porty = Set.of(portType.DP, portType.HDMI, portType.VGA);

    bGpu.addPorts(portType.DP);
    bGpu.addPorts(portType.HDMI);
    bGpu.addPorts(portType.VGA);

    assertEquals(porty, bGpu.getPorts());
    assertEquals(3, bGpu.calculateNumPorts());
  }

  @Test
  void testYearValadation() {
    GPU bGpu = new GPU("Radion 560 xt", 2015, "AMD", 8);

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
    Part apart = new Part();

    apart.setBrand("A Brand");
    apart.setName("A Part");
    apart.setReleaseYear(2011);

    assertEquals("A Brand", apart.getBrand());
    assertEquals("A Part", apart.getName());
    assertEquals(2011, apart.getReleaseYear());
  }

  @Test
  void testCpuPerformance() {
    CPU acpu = new CPU("M1", 2020, cpuBrand.INTEL, 23.32);

    assertEquals(0, acpu.calcPerformance());
    acpu.setCores(8);

    assertEquals(Math.round(87463805373.55), acpu.calcPerformance());
  }
}
