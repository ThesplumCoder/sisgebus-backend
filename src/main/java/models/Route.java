package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Route modelas las rutas de autobus que recorren los buses del sistema.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class Route extends NamedEntity {
  private List<Bus> buses;
  private List<BusStand> busStands;

  public Route(String name, List<BusStand> busStands) {
    this(name, busStands, null);
  }

  public Route(String name, List<BusStand> busStands, List<Bus> buses) {
    super(name);
    setBusStands(busStands);
    setBuses(buses);
  }

  /**
   * Retorna los buses que hacen la ruta.
   *
   * @return Una lista con los buses adscritos a la ruta.
   */
  public List<Bus> getBuses() {
    return buses;
  }

  /**
   * Retorna las paradas de autobus.
   *
   * @return Una lista con las paradas de autobus que conforman la ruta.
   */
  public List<BusStand> getBusStands() {
    return busStands;
  }

  /**
   * Cambia la lista de buses que hacen la ruta.
   *
   * @param buses Nueva lista de autobuses que hacen la ruta.
   * @throws NullPointerException Si la lista de autobuses apunta a un valor nulo.
   */
  public void setBuses(List<Bus> buses) throws NullPointerException {
    if (buses.equals(null)) {
      throw new NullPointerException("The supplied list of buses is null.");
    }

    this.buses = new ArrayList<Bus>(buses);
  }

  /**
   * Cambia la lista de paradas de autobus.
   *
   * @param busStands Nueva lista de paradas de autobus que conforman la ruta.
   * @throws NullPointerException Si la lista de paradas de autobus apunta a un
   *                              valor nulo.
   */
  public void setBusStands(List<BusStand> busStands) {
    if (busStands.equals(null)) {
      throw new NullPointerException("The supplied list of bus stands is null.");
    }

    this.busStands = new LinkedList<BusStand>(busStands);
  }

  /**
   * Agrega un autobus a la lista de buses que hacen la ruta.
   *
   * @param bus Nuevo autobus.
   * @throws NullPointerException Si el autobus pasada apunta a un valor nulo.
   */
  public void addBus(Bus bus) throws NullPointerException {
    if (bus.equals(null)) {
      throw new NullPointerException("The supplied bus is null.");
    }

    this.buses.add(bus);
  }

  /**
   * Elimina uno de los autobuses de la lista.
   *
   * @param bus Autobus que se desea eliminar.
   * @throws NoSuchElementException Si el autobus a eliminar no existe en la lista
   *                                actual de autobuses.
   * @throws NullPointerException   Si el autobus a eliminar es un valor nulo.
   */
  public void rmBus(Bus bus) throws NoSuchElementException, NullPointerException {
    if (bus.equals(null)) {
      throw new NullPointerException("The supplied bus is null.");
    }
    if (!(buses.remove(bus))) {
      throw new NoSuchElementException("The bus doesn't exist.");
    }
  }
}
