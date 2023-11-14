package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CardTest
 */
public class CardTest {

  @Test
  public void createCard() {
    Assertions.assertNotEquals(null, new Card());
  }
}
