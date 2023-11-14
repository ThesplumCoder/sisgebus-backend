package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * PhysicalPointTest
 */
public class PhysicalPointTest {
  PhysicalPoint pp = new PhysicalPoint("Carrera 0 Calle 0");

  @Test
  public void verifyAddress() {
    Assertions.assertEquals("Carrera 0 Calle 0", pp.getAddress());
  }
}
