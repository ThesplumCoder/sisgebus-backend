package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CodeQRTest
 */
public class CodeQRTest {

  @Test
  public void validCodeQr() {
    CodeQR cq = new CodeQR();
    Assertions.assertEquals(true, cq.isValid());
  }
}
