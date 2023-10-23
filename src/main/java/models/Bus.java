package models;

import java.util.List;

/**
 * Bus modela los autobuses que soportan la operación de transporte de personas
 * en el STM.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class Bus extends models.Entity {
  private String licensePlate;
  private String type;
  private List<String> adjustments;

  /**
   * Crea un bus que tiene identificador, placa de tránsito, tipo; pero no cuenta
   * inicialmente con ayudas para gente con discapacidad.
   *
   * @param id           Identificador del bus.
   * @param licensePlate Placa de tránsito.
   * @param type         Tipo del bus.
   */
  public Bus(Integer id, String licensePlate, String type) {
    this(id, licensePlate, type, null);
  }

  /**
   * Crea un bus que tiene identificador, placa de tránsito, tipo y ayudas para
   * gente con discapacidad.
   *
   * @param id           Identificador del bus.
   * @param licensePlate Placa de tránsito.
   * @param type         Tipo del bus.
   * @param adjustments  Soportes o ayudas para gente con discapacidad.
   */
  public Bus(Integer id, String licensePlate, String type, List<String> adjustments) {
    super(id);
    //
  }

  /**
   * Retorna la placa de tránsito que tiene el bus.
   *
   * @return Cadena con la placa de tránsito.
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Retorna el tipo de bus.
   *
   * @return Cadena que describe el tipo de bus.
   */
  public String getType() {
    return type;
  }

  /**
   * Retorna todas las ayudas que posee el bus.
   *
   * @return Lista de cadenas, cada una es una ayuda que posee el bus.
   */
  public List<String> getAdjustments() {
    return adjustments;
  }

  /**
   * Cambia la placa de tránsito.
   *
   * @param licensePlate Nueva placa de tránsito.
   */
  public void setLicensePlate(String licensePlate) {
    //
  }

  /**
   * Cambia el tipo del que es el bus.
   *
   * @param type Nueva tipo del bus.
   */
  public void setType(String type) {
    //
  }

  /**
   * Agrega una ayuda para gente discapacitada.
   *
   * @param adjustment Nueva ayuda que se agregó.
   */
  public void addAdjustments(String adjustment) {
    //
  }

  /**
   * Elimina una de las ayudas que posea el autobus.
   *
   * @param adjustment Ayuda que se desea eliminar.
   */
  public void rmAdjustment(String adjustment) {
    //
  }
}
