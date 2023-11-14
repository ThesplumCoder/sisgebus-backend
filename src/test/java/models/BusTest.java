package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * BusTest
 */
public class BusTest {
  Bus b = new Bus("111-AAA", "Alimentador");

  @Test
  public void verifyLicensePlate() {
    Assertions.assertEquals("111-AAA", b.getLicensePlate());
  }
}
