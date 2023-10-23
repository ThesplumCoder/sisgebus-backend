package models;

import java.util.List;

/**
 * Route modelas las rutas de autobus que recorren los buses del sistema.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class Route extends NamedEntity {
  private List<Bus> buses;
  private List<BusStand> busStands;

  public Route(Integer id, String name, List<BusStand> busStands, List<Bus> buses) {
    super(id, name);
    //
  }
}
