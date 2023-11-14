package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * BusStandTest
 */
public class BusStandTest {
  BusStand bS = new BusStand("Carrera 0 Calle 0");

  @Test
  public void verifyAddress() {
    Assertions.assertEquals("Carrera 0 Calle 0", bS.getAddress());
  }
}
