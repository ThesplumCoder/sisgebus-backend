package models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Bus modela los autobuses que soportan la operación de transporte de personas
 * en el STM.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class Bus extends Entity {

  private String licensePlate;
  private String type;
  private List<String> adjustments;

  /**
   * Crea un bus que tiene identificador, placa de tránsito, y tipo; pero no
   * cuenta inicialmente con ayudas para gente con discapacidad.
   *
   * @param licensePlate Placa de tránsito.
   * @param type         Tipo del bus.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(String licensePlate, String type) throws IllegalArgumentException, NullPointerException {
    this(licensePlate, type, null);
  }

  /**
   * Crea un bus que tiene identificador, placa de tránsito, tipo y ayudas para
   * gente con discapacidad.
   *
   * @param licensePlate Placa de tránsito.
   * @param type         Tipo del bus.
   * @param adjustments  Soportes o ayudas para gente con discapacidad.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(String licensePlate, String type, List<String> adjustments)
      throws IllegalArgumentException, NullPointerException {
    super();
    setLicensePlate(licensePlate);
    setType(type);

    if (adjustments.equals(null)) {
      this.adjustments = new ArrayList<>();
    } else {
      setAdjustments(adjustments);
    }
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
   * @throws IllegalArgumentException Si la placa de tránsito está vacía o solo
   *                                  contiene espacios en blanco.
   * @throws NullPointerException     Si la placa de tránsito apunta a un valor
   *                                  nulo.
   */
  public void setLicensePlate(String licensePlate) throws IllegalArgumentException, NullPointerException {
    if (licensePlate.equals(null)) {
      throw new NullPointerException("The supplied license plate is null.");
    }
    if (licensePlate.isBlank()) {
      throw new IllegalArgumentException("The license plate can't be empty.");
    }

    this.licensePlate = licensePlate;
  }

  /**
   * Cambia el tipo del que es el bus.
   *
   * Los posibles valores son: Alimentador, Pre-troncal y Troncal.
   *
   * @param type Nuevo tipo del bus.
   * @throws IllegalArgumentException Si el tipo ingresado no corresponde con
   *                                  alguno de los valores posibles.
   */
  public void setType(String type) throws IllegalArgumentException {
    List<String> types = new ArrayList<>(3);
    types.add("Alimentador");
    types.add("Pre-troncal");
    types.add("Troncal");

    if (types.contains(type)) {
      this.type = type;
    } else {
      throw new IllegalArgumentException("The supplied type isn't valid.");
    }
  }

  /**
   * Cambia la lista de ayudas que tiene el autobus.
   *
   * @param adjustments Una lista con las nuevas ayudas que posee el bus, cada una
   *                    como un texto.
   * @throws NullPointerException Si la lista apunta a un valor nulo.
   */
  public void setAdjustments(List<String> adjustments) throws NullPointerException {
    if (adjustments.equals(null)) {
      throw new NullPointerException("The supplied adjustments is null.");
    }

    this.adjustments = new ArrayList<String>(adjustments);
  }

  /**
   * Agrega una ayuda para gente discapacitada.
   *
   * @param adjustment Nueva ayuda que se agregó.
   * @throws IllegalArgumentException Si la ayuda a agregar es una cadena vacía o
   *                                  de solo espacios.
   * @throws NullPointerException     Si la ayuda a agregar es un valor nulo.
   */
  public void addAdjustments(String adjustment) throws IllegalArgumentException, NullPointerException {
    if (licensePlate.equals(null)) {
      throw new NullPointerException("The supplied license plate is null.");
    }
    if (licensePlate.isBlank()) {
      throw new IllegalArgumentException("The license plate can't be empty.");
    }

    adjustments.add(adjustment);
  }

  /**
   * Elimina una de las ayudas que posea el autobus.
   *
   * @param adjustment Ayuda que se desea eliminar.
   * @throws IllegalArgumentException Si la ayuda a eliminar es una cadena vacía o
   *                                  de solo espacios.
   * @throws NoSuchElementException   Si la ayuda a eliminar no existe en la lista
   *                                  actual de ayudas.
   * @throws NullPointerException     Si la ayuda a eliminar es un valor nulo.
   */
  public void rmAdjustment(String adjustment)
      throws IllegalArgumentException, NoSuchElementException, NullPointerException {
    if (adjustment.equals(null)) {
      throw new NullPointerException("The supplied help is null.");
    }
    if (adjustment.isBlank()) {
      throw new IllegalArgumentException("The help can't be empty.");
    }
    if (!(adjustments.remove(adjustment))) {
      throw new NoSuchElementException("The help doesn't exist.");
    }
  }
}
