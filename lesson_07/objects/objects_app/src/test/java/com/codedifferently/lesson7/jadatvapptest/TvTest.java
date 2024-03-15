package test.java.com.codedifferently.lesson7.jadatvapptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson7.jadatvapp.DisplayTechnology;
import com.codedifferently.lesson7.jadatvapp.Tv;
import com.codedifferently.lesson7.jadatvapp.TvException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TvTest {

  @Test
  public void testGetBrand() {
    Tv myTV =
        new Tv(
            "Samsung",
            "Smart TV 2022",
            55.5,
            "4K Ultra HD",
            DisplayTechnology.QLED,
            true,
            new ArrayList<>());
    assertEquals("Samsung", myTV.getBrand());
  }

  @Test
  public void testSetBrand() {
    Tv myTV =
        new Tv(
            "Samsung",
            "Smart TV 2022",
            55.5,
            "4K Ultra HD",
            DisplayTechnology.QLED,
            true,
            new ArrayList<>());
    myTV.setBrand("Sony");
    assertEquals("Sony", myTV.getBrand());
  }

  @Test
  public void testGetResolution() {
    Tv myTV =
        new Tv(
            "Samsung",
            "Smart TV 2022",
            55.5,
            "4K Ultra HD",
            DisplayTechnology.QLED,
            true,
            new ArrayList<>());
    assertEquals("4K ULTRA HD", myTV.getResolution());
  }

  @Test
  public void testHasSmartFeatures() {
    Tv smartTV =
        new Tv(
            "Samsung",
            "Smart TV 2022",
            55.5,
            "4K Ultra HD",
            DisplayTechnology.QLED,
            true,
            new ArrayList<>());
    Tv nonSmartTV =
        new Tv(
            "Sony",
            "Non-Smart TV 2022",
            43.0,
            "Full HD",
            DisplayTechnology.LED,
            false,
            new ArrayList<>());
    assertEquals("Yes", smartTV.hasSmartFeatures());
    assertEquals("No", nonSmartTV.hasSmartFeatures());
  }

  @Test
  public void testThrowCustomException() {
    Tv smallTV =
        new Tv(
            "Sony", "Small TV 2022", 20.0, "HD", DisplayTechnology.LED, false, new ArrayList<>());
    TvException exception = assertThrows(TvException.class, () -> smallTV.testSetScreenSize(20.0));
    assertEquals("Screen size is too small.", exception.getMessage());
  }

  @Test
  public void testSetScreenSizeThrowsExceptionWhenSizeIsTooSmall() {
    Tv smallTV = new Tv("Sony", "Small TV 2022", 20.0, "HD", DisplayTechnology.LED, false, null);
    assertThrows(TvException.class, () -> smallTV.setScreenSize(20.0));
  }
}
