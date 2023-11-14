package models;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * RouteTest
 */
public class RouteTest {

  @Test
  public void verifyName() {
    List<BusStand> bSs = new ArrayList<>();
    bSs.add(new BusStand("Avenida Gonzales Valencia"));
    Route r = new Route("Florida - UIS", bSs);

    Assertions.assertEquals("Florida - UIS", r.getName());
  }
}
