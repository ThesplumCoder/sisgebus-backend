package models;

/**
 * Modela las paradas de autobus.
 *
 * Esta clase permite tener estas paradas de autobus que se pueden reconocer por
 * la dirección física que tienen en la ciudad.
 * 
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class BusStand extends Place {

  /**
   * Crea un parada de autobus.
   *
   * @param id      Identificador numérico autogenerado por la BD.
   * @param address Dirección física de la parada de autobus en la ciudad.
   */
  public BusStand(Integer id, String address) {
    super(id, address);
  }
}
