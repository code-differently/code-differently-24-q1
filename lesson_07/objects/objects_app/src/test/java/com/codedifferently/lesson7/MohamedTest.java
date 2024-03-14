package com.codedifferently.lesson7;




import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson7.MohamedObjects.Main.CPU;
import com.codedifferently.lesson7.MohamedObjects.Main.GPU;
import com.codedifferently.lesson7.MohamedObjects.Main.IllegalYearExeption;
import com.codedifferently.lesson7.MohamedObjects.Main.cpuBrands;
import com.codedifferently.lesson7.MohamedObjects.Main.portTypes;

import java.util.*;

class MohamedTest {
  
  @Test
  public void setClockSpeed(){
    CPU cpu = new CPU("cpu1", 2000, cpuBrands.INTEL ,23.32);
    assertEquals(23.32,cpu.getClockSpeed());
  }

  @Test
  void gpuReleaseYear() throws IllegalYearExeption{
    GPU aGpu = new GPU();
    try {
      aGpu.setReleaseYear(1999);
      fail("Expected IllegalYearExeption");
    } catch (IllegalYearExeption e) {
      assertEquals("Year is out of expected range. 2000 - 2024", e.getMessage());
    }
  }

  @Test
  void testGpuPorts(){
  
    Set<portTypes> porty = Set.of(portTypes.DP, portTypes.HDMI, portTypes.VGA );
    GPU bGpu = new GPU("Radion 560 xt", 2015, "AMD", 8);
    bGpu.addPorts(portTypes.DP);
    bGpu.addPorts(portTypes.HDMI);
    bGpu.addPorts(portTypes.VGA);
    assertEquals(bGpu.getPorts(), porty);
  }

  @Test
  void testSize(){
    GPU bGpu = new GPU("GTX 1050", 2015, "Navidia", 8);
    bGpu.addPorts(portTypes.DP);
    bGpu.addPorts(portTypes.HDMI);
    bGpu.addPorts(portTypes.VGA);
    assertEquals(bGpu.printNumPorts(), 3 );
  }

  @Test
  void testCores(){
    CPU m1 = new CPU("M1", 2020, cpuBrands.APPLE, 4.0, 8);
    assertEquals(m1.getCores(), 8);;
  }
}
