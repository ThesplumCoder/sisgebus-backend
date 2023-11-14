package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * EntityTest
 */
public class PassengerTest {
  Passenger p1 = new Passenger("Julano");
  Passenger p2 = new Passenger("Julano", new Card());
  Passenger p3 = new Passenger("Julano", new Card(), 10);

  @Test
  public void verifyIdGeneration() {
    Assertions.assertNotEquals(null, p1.getId());
  }
}
